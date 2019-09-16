module github.com/PtrTeixeira/cookbook/strava

require (
	github.com/PtrTeixeira/cookbook/strava/api v0.0.0-00010101000000-000000000000
	github.com/golang/protobuf v1.3.1
	gopkg.in/h2non/gock.v1 v1.0.14
)

replace github.com/PtrTeixeira/cookbook/strava/api => ../api

go 1.13
