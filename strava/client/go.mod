module github.com/PtrTeixeira/cookbook/strava

require (
	github.com/PtrTeixeira/cookbook/strava/api v0.0.0-20190929163527-e03c86f35e56
	gopkg.in/h2non/gock.v1 v1.0.14
)

replace github.com/PtrTeixeira/cookbook/strava/api => ../api

go 1.13
