package main

import (
	"fmt"

	"github.com/spf13/viper"
)

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
	// Environment is the runtime environment (eg, production)
	Environment string
	// SentryDsn is the sending secret for reporting to Sentry
	SentryDsn string
}

// InitConfig loads server configuration from file or environment variables.
func InitConfig() (*Config, error) {
	viper.SetDefault("baseUrl", "http://localhost:8080")
	viper.SetDefault("dashboardUiUrl", "http://localhost:3000/dashboard")
	viper.SetDefault("stravaClientId", "")
	viper.SetDefault("stravaClientSecret", "")
	viper.SetDefault("environment", "local")
	viper.SetDefault("sentryDsn", "")

	viper.SetConfigName("config")
	viper.AddConfigPath("/etc/punchcard")
	viper.AddConfigPath(".")

	if err := viper.ReadInConfig(); err != nil {
		if _, ok := err.(viper.ConfigFileNotFoundError); ok {
			// continue; just don't read the file
		} else {
			return nil, fmt.Errorf("could not read config file %s", err)
		}
	}

	viper.BindEnv("baseUrl", "STRAVA_BASE_URL")
	viper.BindEnv("dashboardUrl", "STRAVA_DASHBOARD_URL")
	viper.BindEnv("stravaClientId", "STRAVA_CLIENT_ID")
	viper.BindEnv("stravaClientSecret", "STRAVA_CLIENT_SECRET")
	viper.BindEnv("environment", "ENVIRONMENT")
	viper.BindEnv("sentryDsn", "SENTRY_DSN")

	baseURL := viper.GetString("baseUrl")
	dashboardURL := viper.GetString("dashboardUiUrl")
	stravaClientID := viper.GetString("stravaClientId")
	stravaClientSecret := viper.GetString("stravaClientSecret")
	environment := viper.GetString("environment")
	sentryDsn := viper.GetString("sentryDsn")

	config := Config{
		BaseURL:            baseURL,
		DashboardURL:       dashboardURL,
		StravaClientID:     stravaClientID,
		StravaClientSecret: stravaClientSecret,
		Environment:        environment,
		SentryDsn:          sentryDsn,
	}
	return &config, nil
}
