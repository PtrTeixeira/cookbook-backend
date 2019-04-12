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
	})
}
