extern crate lib;
extern crate regex;
extern crate walkdir;

use lib::cli::{parse_command_line, CommandLine};
use lib::get_new_path;
use regex::Regex;
use std::env;
use std::fs;
use std::io;
use walkdir::{DirEntry, WalkDir};

fn main() {
    let result = run_app();

    if !result {
        std::process::exit(1);
    }
}

fn run_app() -> bool {
    let command_line = match parse_command_line(env::args_os()) {
        Ok(cl) => cl,
        Err(e) => {
            eprintln!("{}", e);
            return true;
        }
    };

    let CommandLine {
        from_pattern,
        to_pattern,
        preserve,
    } = command_line;

    let re = match Regex::new(&from_pattern) {
        Ok(re) => re,
        Err(_) => {
            eprintln!("Could not parse '{}' as a regular expression", from_pattern);
            return false;
        }
    };

    let mut exit_ok = true;
    for entry in WalkDir::new(".").into_iter().filter_map(|e| e.ok()) {
        let move_result = if preserve {
            try_copy_file(entry, &to_pattern, &re)
        } else {
            try_move_file(entry, &to_pattern, &re)
        };

        if let Some(Err(e)) = move_result {
            exit_ok = false;
            eprintln!("{:?}", e);
        }
    }

    exit_ok
}

fn try_move_file(entry: DirEntry, target_pattern: &str, re: &Regex) -> Option<io::Result<()>> {
    let filename = entry.file_name().to_str()?;
    let target_file_path = get_new_path(filename, target_pattern, re)?;

    Some(fs::rename(entry.path(), target_file_path))
}

fn try_copy_file(entry: DirEntry, target_pattern: &str, re: &Regex) -> Option<io::Result<()>> {
    let filename = entry.file_name().to_str()?;
    let target_file_path = get_new_path(filename, target_pattern, re)?;

    return match fs::copy(entry.path(), target_file_path) {
        Ok(_) => Some(Ok(())),
        Err(e) => Some(Err(e)),
    };
}
