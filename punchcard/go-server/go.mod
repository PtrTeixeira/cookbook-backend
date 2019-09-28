module github.com/PtrTeixeira/punchcard/go-server

require (
	github.com/PtrTeixeira/cookbook/strava/api v0.0.0-00010101000000-000000000000
	github.com/PtrTeixeira/cookbook/strava/client v0.0.0-00010101000000-000000000000
	github.com/labstack/echo v3.3.10+incompatible
	github.com/labstack/echo/v4 v4.1.5
	github.com/labstack/gommon v0.2.8
	github.com/mattn/go-isatty v0.0.8 // indirect
	github.com/spf13/viper v1.4.0
	golang.org/x/crypto v0.0.0-20190513172903-22d7a77e9e5f // indirect
	golang.org/x/tools v0.0.0-20190521203540-521d6ed310dd // indirect
)

replace github.com/PtrTeixeira/cookbook/strava/client => ../../strava/client

replace github.com/PtrTeixeira/cookbook/strava/api => ../../strava/api

go 1.13
