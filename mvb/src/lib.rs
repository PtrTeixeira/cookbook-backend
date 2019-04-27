extern crate clap;
extern crate regex;

pub mod cli;

use regex::Regex;
use std::borrow::Borrow;
use std::path::Path;
use std::path::PathBuf;

pub fn get_new_path(filename: &str, target_pattern: &str, from_pattern: &Regex) -> Option<PathBuf> {
    if !from_pattern.is_match(filename) {
        return None;
    }

    let replaced_name = from_pattern.replace(filename, target_pattern);
    let target_file_name: &str = replaced_name.borrow();
    let target_file_path = Path::new(target_file_name);
    return Some(target_file_path.to_owned());
}

#[cfg(test)]
mod tests {
    use super::*;
    use regex::Regex;

    #[test]
    fn it_returns_none_if_filename_doesnt_match_from_pattern() {
        let filename = "/app/file1.txt";
        let from_pattern = Regex::new("file2.txt").unwrap();
        let to_pattern = "$0.bkp";

        let result = get_new_path(filename, to_pattern, &from_pattern);
        assert_eq!(result, None);
    }

    #[test]
    fn it_returns_some_of_path_if_replacement_made() {
        let filename = "/app/file1.txt";
        let from_pattern = Regex::new("file1.txt").unwrap();
        let to_pattern = "$0.bkp";

        let result = get_new_path(filename, to_pattern, &from_pattern);
        assert_eq!(result, Some(PathBuf::from(r"/app/file1.txt.bkp")));
    }
}
