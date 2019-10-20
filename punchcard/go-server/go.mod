module github.com/PtrTeixeira/punchcard/go-server

require (
	github.com/PtrTeixeira/cookbook/strava/api v0.0.0-20190929163527-e03c86f35e56
	github.com/PtrTeixeira/cookbook/strava/client v0.0.0-20190929163527-e03c86f35e56
	github.com/labstack/echo/v4 v4.1.11
	github.com/labstack/gommon v0.3.0
	github.com/magiconair/properties v1.8.1 // indirect
	github.com/mattn/go-colorable v0.1.4 // indirect
	github.com/mattn/go-isatty v0.0.10 // indirect
	github.com/pelletier/go-toml v1.5.0 // indirect
	github.com/spf13/afero v1.2.2 // indirect
	github.com/spf13/jwalterweatherman v1.1.0 // indirect
	github.com/spf13/pflag v1.0.5 // indirect
	github.com/spf13/viper v1.4.0
	github.com/valyala/fasttemplate v1.1.0 // indirect
	golang.org/x/crypto v0.0.0-20191011191535-87dc89f01550 // indirect
	golang.org/x/net v0.0.0-20191014212845-da9a3fd4c582 // indirect
	golang.org/x/sys v0.0.0-20191018095205-727590c5006e // indirect
	golang.org/x/text v0.3.2 // indirect
	golang.org/x/tools v0.0.0-20190521203540-521d6ed310dd // indirect
)

replace github.com/PtrTeixeira/cookbook/strava/client => ../../strava/client

replace github.com/PtrTeixeira/cookbook/strava/api => ../../strava/api

go 1.13
