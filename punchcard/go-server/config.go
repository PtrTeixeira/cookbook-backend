package main

// Config is the configuration data for the server
type Config struct {
	// BaseUrl is the url of the REST server
	BaseURL string
	// DashboardUiUrl is the url of the frondend app
	DashboardURL string
	// StravaClientId is the strava client id
	StravaClientID string
	// StravaClientSecret is the strava client secret
	StravaClientSecret string
}
