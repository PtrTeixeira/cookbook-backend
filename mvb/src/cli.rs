use clap::{App, Arg, Result as ClapResult, value_t};
use std::ffi::OsString;

pub struct CommandLine {
    pub from_pattern: String,
    pub to_pattern: String,
    pub preserve: bool,
    pub verbose: bool,
    pub depth: Option<u8>,
    pub show_hidden: bool,
}

pub fn parse_command_line<I, T>(args: I) -> ClapResult<CommandLine>
where
    I: IntoIterator<Item = T>,
    T: Into<OsString> + Clone,
{
    let matches = App::new("mvb")
        .author("Peter Teixeira")
        .about("Bulk renames files")
        .arg(Arg::with_name("from_pattern").required(true).index(1))
        .arg(Arg::with_name("to_pattern").required(true).index(2))
        .arg(
            Arg::with_name("verbose")
                .required(false)
                .short("v")
                .long("verbose")
                .help("List all inspected files"),
        )
        .arg(
            Arg::with_name("preserve")
                .required(false)
                .short("p")
                .long("preserve")
                .help("Preserve original files (make copies at new location)"),
        )
        .arg(
            Arg::with_name("depth")
            .required(false)
            .long("depth")
            .help("Max depth to search")
        )
        .get_matches_from_safe(args)?;

    let from_pattern = matches.value_of("from_pattern").unwrap();
    let to_pattern = matches.value_of("to_pattern").unwrap();
    let preserve = matches.is_present("preserve");
    let verbose = matches.is_present("verbose");
    let depth = value_t!(matches, "depth", u8)
      .map(|val| Some(val))
      .unwrap_or(None);
    let show_hidden = matches.is_present("hidden");

    return Ok(CommandLine {
        from_pattern: from_pattern.to_owned(),
        to_pattern: to_pattern.to_owned(),
        preserve: preserve,
        verbose: verbose,
        depth: depth,
        show_hidden: show_hidden,
    });
}

#[cfg(test)]
mod test {
    use super::*;

    #[test]
    pub fn parse_command_line_returns_err_on_help_flag() {
        if let Ok(_) = parse_command_line(&["mvb", "--help"]) {
            assert!(false, "Should have errored out on help flag")
        }
    }

    #[test]
    pub fn parse_command_line_returns_err_on_version_flag() {
        if let Ok(_) = parse_command_line(&["mvb", "--version"]) {
            assert!(false, "Should have errored out on version flag")
        }
    }

    #[test]
    pub fn parse_command_line_returns_err_on_help_flag_even_if_other_args_passed() {
        if let Ok(_) = parse_command_line(&["mvb", "--help", "name1", "name2"]) {
            assert!(false, "Should have errored out on version flag")
        }
    }

    #[test]
    pub fn parse_command_line_sets_preserve_flag_if_present() {
        let command_line = parse_command_line(&["mvb", "-p", "name1", "name2"]).unwrap();

        assert!(command_line.preserve, "Preserve flag should be set");
    }

    #[test]
    pub fn parse_command_line_sets_verbose_flag_if_present() {
        let command_line = parse_command_line(&["mvb", "-v", "name1", "name2"]).unwrap();

        assert!(command_line.verbose, "Verbose flag should be set")
    }

    #[test]
    pub fn perserve_flag_defaults_to_false() {
        let command_line = parse_command_line(&["mvb", "name1", "name2"]).unwrap();

        assert!(!command_line.preserve, "Preserve flag should be false");
    }

    #[test]
    pub fn verbose_flag_defaults_to_false() {
        let command_line = parse_command_line(&["mvb", "name1", "name2"]).unwrap();

        assert!(!command_line.verbose, "Verbose flag should be false");
    }

    #[test]
    pub fn parse_command_line_sets_from_and_to_patterns() {
        let command_line = parse_command_line(&["mvb", "name1", "name2"]).unwrap();

        assert_eq!(command_line.from_pattern, "name1");
        assert_eq!(command_line.to_pattern, "name2");
    }
}
