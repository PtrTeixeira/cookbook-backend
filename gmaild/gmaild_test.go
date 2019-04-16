package main

import (
	"os/user"
	"testing"
)

func TestGmaild(t *testing.T) {
	user := user.User{
		HomeDir: "/home/user",
	}

	t.Run("when passed e flag", func(t *testing.T) {
		args := []string{"gmaild", "-e", "echo hello"}
		config, err := parseCommandLine(&user, args)

		if err != nil {
			t.Error("Failed to parse config")
		}
		if config.ExecString != "echo hello" {
			t.Error("Failed to parse exec string")
		}

		// The default credentials file location
		if config.CredFile != "/home/user/credentials.json" {
			t.Error("Incorrect default credentials file location")
		}

		// The default token file location
		if config.TokFile != "/home/user/token.json" {
			t.Error("Incorrect default token file location")
		}
	})

	t.Run("when given no flags", func(t *testing.T) {
		args := []string{"gmaild"}
		_, err := parseCommandLine(&user, args)

		if err == nil {
			t.Error("Should have failed to parse command-line arguments")
		}
	})

	t.Run("when not given the -e flag", func(t *testing.T) {
		args := []string{"gmaild", "-c", "/home/user/.config/gmaild/credentials.json"}
		_, err := parseCommandLine(&user, args)

		if err == nil {
			t.Error("Should have failed to parse command-line arguments")
		}
	})
}
