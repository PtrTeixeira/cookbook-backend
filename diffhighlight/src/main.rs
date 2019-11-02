extern crate regex;

use regex::Regex;
use std::io::{self, BufRead};

fn main() -> io::Result<()> {
    let stdin = io::stdin();
    let mut in_hunk = false;
    for line in stdin.lock().lines() {
        let content = line.unwrap();
        if !in_hunk {
            println!("{}", content);
            in_hunk = is_start_of_hunk(&content);
            if in_hunk {
                println!("Entering hunk")
            }
        } else if is_line_added(&content) {
            println!("Line added");
        } else if is_line_removed(&content) {
            println!("Line removed");
        } else {
            println!("{}", content);
            in_hunk = does_hunk_continue(&content);
            if !in_hunk {
                println!("Exiting hunk")
            }
        }
    }

    Ok(())
}

fn is_start_of_hunk(line: &str) -> bool {
    let hunk_marker = Regex::new(r"^@@ ").unwrap();
    hunk_marker.is_match(line)
}

fn is_line_added(line: &str) -> bool {
    let added_marker = Regex::new(r"^\+").unwrap();
    added_marker.is_match(line)
}

fn is_line_removed(line: &str) -> bool {
    let removed_marker = Regex::new(r"^-").unwrap();
    removed_marker.is_match(line)
}

fn does_hunk_continue(line: &str) -> bool {
    let hunk_marker = Regex::new(r"^[@ ]").unwrap();
    hunk_marker.is_match(line)
}
