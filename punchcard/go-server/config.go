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
}

func InitConfig() Config {
	viper.SetDefault("baseUrl", "http://localhost:8080")
	viper.SetDefault("dashboardUrl", "http://localhost:3000/dashboard")
	viper.SetDefault("stravaClientId", "")
	viper.SetDefault("stravaClientSecret", "")

	viper.SetConfigName("config")
	viper.AddConfigPath("/etc/punchcard")
	viper.AddConfigPath(".")

	if err := viper.ReadInConfig(); err != nil {
		if _, ok := err.(viper.ConfigFileNotFoundError); ok {
			// continue; just don't read the file
		} else {
			panic(fmt.Errorf("Could not read config file %s\n", err))
		}
	}

	viper.BindEnv("STRAVA_BASE_URL", "baseUrl")
	viper.BindEnv("STRAVA_DASHBOARD_URL", "dashboardUrl")
	viper.BindEnv("STRAVA_CLIENT_ID", "stravaClientId")
	viper.BindEnv("STRAVA_CLIENT_SECRET", "stravaClientSecret")

	baseUrl := viper.GetString("baseUrl")
	dashboardUrl := viper.GetString("dashboardUrl")
	stravaClientId := viper.GetString("stravaClientId")
	stravaClientSecret := viper.GetString("stravaClientSecret")

	return Config{
		BaseURL:            baseUrl,
		DashboardURL:       dashboardUrl,
		StravaClientID:     stravaClientId,
		StravaClientSecret: stravaClientSecret,
	}
}
