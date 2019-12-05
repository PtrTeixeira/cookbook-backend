extern crate clap;
extern crate regex;
extern crate walkdir;

pub mod cli;

use regex::Regex;
use std::borrow::Borrow;
use std::fs;
use std::io;
use std::path::Path;
use std::path::PathBuf;
use walkdir::{DirEntry, WalkDir};

pub struct RenameSettings {
    pub target_pattern: String,
    pub source_pattern: Regex,
}

pub fn get_new_path(filename: &str, opts: &RenameSettings) -> Option<PathBuf> {
    let target_pattern: &str = &opts.target_pattern;
    let from_pattern = &opts.source_pattern;
    if !from_pattern.is_match(filename) {
        return None;
    }

    let replaced_name = from_pattern.replace(filename, target_pattern);
    let target_file_name: &str = replaced_name.borrow();
    let target_file_path = Path::new(target_file_name);
    return Some(target_file_path.to_owned());
}

fn try_move_file(entry: DirEntry, opts: &RenameSettings) -> Option<io::Result<()>> {
    let filename = entry.path().to_str()?;
    let target_file_path = get_new_path(filename, opts)?;

    Some(fs::rename(entry.path(), target_file_path))
}

fn try_copy_file(entry: DirEntry, opts: &RenameSettings) -> Option<io::Result<()>> {
    let filename = entry.path().to_str()?;
    let target_file_path = get_new_path(filename, opts)?;

    return match fs::copy(entry.path(), target_file_path) {
        Ok(_) => Some(Ok(())),
        Err(e) => Some(Err(e)),
    };
}

pub fn move_in_directory(to_pattern: &str, re: &Regex, verbose: bool, preserve: bool) -> bool {
    let opts = RenameSettings {
        target_pattern: to_pattern.to_owned(),
        source_pattern: re.to_owned(),
    };
    let mut exit_ok = true;
    for entry in WalkDir::new(".").into_iter().filter_map(|e| e.ok()) {
        if verbose {
            println!("Checking file {}", entry.path().display());
        }

        let move_result = if preserve {
            try_copy_file(entry, &opts)
        } else {
            try_move_file(entry, &opts)
        };

        if let Some(Err(e)) = move_result {
            exit_ok = false;
            eprintln!("{:?}", e);
        }
    }

    exit_ok
}

#[cfg(test)]
mod tests {
    use super::*;
    use regex::Regex;

    #[test]
    fn it_returns_none_if_filename_doesnt_match_from_pattern() {
        let filename = "/app/file1.txt";
        let opts = RenameSettings {
            source_pattern: Regex::new("file2.txt").unwrap(),
            target_pattern: "$0.bkp".to_owned(),
        };

        let result = get_new_path(filename, &opts);
        assert_eq!(result, None);
    }

    #[test]
    fn it_returns_some_of_path_if_replacement_made() {
        let filename = "/app/file1.txt";
        let opts = RenameSettings {
            source_pattern: Regex::new("file1.txt").unwrap(),
            target_pattern: "$0.bkp".to_owned(),
        };

        let result = get_new_path(filename, &opts);
        assert_eq!(result, Some(PathBuf::from(r"/app/file1.txt.bkp")));
    }
}
