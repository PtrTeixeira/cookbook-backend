module github.com/PtrTeixeira/punchcard/go-server

require (
	github.com/PtrTeixeira/cookbook/go-assert v0.0.0-20191026211910-0cd64864ad70
	github.com/PtrTeixeira/cookbook/strava/api v0.0.0-20191222040026-e0b7ce91a1a0
	github.com/PtrTeixeira/cookbook/strava/client v0.0.0-20191222040026-e0b7ce91a1a0
	github.com/gavv/monotime v0.0.0-20190418164738-30dba4353424 // indirect
	github.com/getsentry/sentry-go v0.4.0
	github.com/gorilla/schema v1.1.0 // indirect
	github.com/iris-contrib/formBinder v5.0.0+incompatible // indirect
	github.com/iris-contrib/httpexpect v0.0.0-20180314041918-ebe99fcebbce // indirect
	github.com/kataras/iris v11.1.1+incompatible // indirect
	github.com/labstack/echo/v4 v4.1.13
	github.com/labstack/gommon v0.3.0
	github.com/pelletier/go-toml v1.6.0 // indirect
	github.com/pkg/errors v0.8.1
	github.com/spf13/afero v1.2.2 // indirect
	github.com/spf13/cast v1.3.1 // indirect
	github.com/spf13/jwalterweatherman v1.1.0 // indirect
	github.com/spf13/pflag v1.0.5 // indirect
	github.com/spf13/viper v1.6.1
	github.com/xeipuuv/gojsonpointer v0.0.0-20190809123943-df4f5c81cb3b // indirect
	golang.org/x/sys v0.0.0-20200102141924-c96a22e43c9c // indirect
	golang.org/x/tools v0.0.0-20190521203540-521d6ed310dd // indirect
	gopkg.in/ini.v1 v1.51.1 // indirect
	gopkg.in/yaml.v2 v2.2.7 // indirect
)

replace github.com/PtrTeixeira/cookbook/strava/client => ../../strava/client

replace github.com/PtrTeixeira/cookbook/strava/api => ../../strava/api

replace github.com/PtrTeixeira/cookbook/go-assert => ../../go-assert

go 1.13
