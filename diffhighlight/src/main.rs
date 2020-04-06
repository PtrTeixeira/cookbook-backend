extern crate regex;

use regex::Regex;
use std::io::{self, BufRead};

fn main() -> io::Result<()> {
    let stdin = io::stdin();
    let mut in_hunk = false;
    let mut added_lines = Vec::new();
    let mut removed_lines = Vec::new();

    for line in stdin.lock().lines() {
        let content = line.unwrap();
        if !in_hunk {
            println!("{}", content);
            in_hunk = is_start_of_hunk(&content);
        } else if is_line_added(&content) {
            added_lines.push(content);
        } else if is_line_removed(&content) {
            removed_lines.push(content);
        } else {
            flush(&mut added_lines, &mut removed_lines);
            println!("{}", content);
            in_hunk = does_hunk_continue(&content);
            if !in_hunk {
                println!("Exiting hunk")
            }
        }
    }

    if in_hunk {
        flush(&mut added_lines, &mut removed_lines);
        println!("Exiting after hunk")
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

fn flush(added: &mut Vec<String>, removed: &mut Vec<String>) -> () {
    if added.len() == 0 && removed.len() == 0 {
        return
    } else if added.len() == removed.len() {
        println!("Changed: {}", added.len())
    } else {
        print_added(added);
        print_removed(removed);
    }

    added.clear();
    removed.clear();
}

fn print_added(lines: &Vec<String>) -> () {
    let green = "\x1b[32;1m";
    let reset = "\x1b[0m";
    for line in lines {
        println!("{}{}{}", green, line, reset)
    }
}

fn print_removed(lines: &Vec<String>) -> () {
    for line in lines {
        println!("{}", line)
    }
}
