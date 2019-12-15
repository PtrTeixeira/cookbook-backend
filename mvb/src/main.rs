extern crate lib;
extern crate regex;

use lib::cli::{parse_command_line, CommandLine};
use lib::{move_in_directory, RenameSettings, Options};
use regex::Regex;
use std::env;

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
        verbose,
        depth,
        show_hidden,
    } = command_line;

    let re = match Regex::new(&from_pattern) {
        Ok(re) => re,
        Err(_) => {
            eprintln!("Could not parse '{}' as a regular expression", from_pattern);
            return false;
        }
    };

    let pattern = RenameSettings {
        target_pattern: to_pattern,
        source_pattern: re,
    };

    let options = Options {
        preserve: preserve,
        verbose: verbose,
        depth: depth,
        show_hidden: show_hidden,
    };

    return move_in_directory(pattern, options);
}
