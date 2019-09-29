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
}

// InitConfig loads server configuration from file or environment variables.
func InitConfig() (*Config, error) {
	viper.SetDefault("baseUrl", "http://localhost:8080")
	viper.SetDefault("dashboardUiUrl", "http://localhost:3000/dashboard")
	viper.SetDefault("stravaClientId", "")
	viper.SetDefault("stravaClientSecret", "")
	viper.SetDefault("environment", "local")

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

	viper.BindEnv("STRAVA_BASE_URL", "baseUrl")
	viper.BindEnv("STRAVA_DASHBOARD_URL", "dashboardUrl")
	viper.BindEnv("STRAVA_CLIENT_ID", "stravaClientId")
	viper.BindEnv("STRAVA_CLIENT_SECRET", "stravaClientSecret")
	viper.BindEnv("ENVIRONMENT", "environment")

	baseURL := viper.GetString("baseUrl")
	dashboardURL := viper.GetString("dashboardUiUrl")
	stravaClientID := viper.GetString("stravaClientId")
	stravaClientSecret := viper.GetString("stravaClientSecret")
	environment := viper.GetString("environment")

	config := Config{
		BaseURL:            baseURL,
		DashboardURL:       dashboardURL,
		StravaClientID:     stravaClientID,
		StravaClientSecret: stravaClientSecret,
		Environment:        environment,
	}
	return &config, nil
}
