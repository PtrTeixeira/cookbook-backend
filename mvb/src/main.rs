extern crate clap;
extern crate regex;
extern crate walkdir;

use clap::{Arg, App};
use regex::Regex;
use std::fs;
use std::borrow::Borrow;
use std::path::Path;
use walkdir::{ DirEntry, WalkDir };

fn main() {
  let matches = App::new("mvb")
      .version("0.1.0")
      .author("Peter Teixeira")
      .about("Bulk renames files")
      .arg(Arg::with_name("from_pattern").required(true).index(1))
      .arg(Arg::with_name("to_pattern").required(true).index(2))
      .get_matches();

  let from_pattern = matches.value_of("from_pattern").unwrap();
  let to_pattern = matches.value_of("to_pattern").unwrap();
  let re = Regex::new(from_pattern)
      .expect("Could not parse input pattern");

  for entry in WalkDir::new(".").into_iter().filter_map(|e| e.ok()) {
      try_move_file(entry, &to_pattern, &re);
  }
}

fn try_move_file(entry: DirEntry, target_pattern: &str, re: &Regex) -> Option<()> {
  let filename = entry.file_name().to_str()?;
  
  if !re.is_match(filename) {
      return None;
  }

  let replaced_name = re.replace(filename, target_pattern);
  let target_file_name: &str = replaced_name.borrow();
  let target_file_path = Path::new(target_file_name);

  println!("Renaming {} to {:?}", entry.path().display(), target_file_name);
  return match fs::rename(entry.path(), target_file_path) {
      Ok(_) => None,
      Err(e) => panic!(e),
  }
}
