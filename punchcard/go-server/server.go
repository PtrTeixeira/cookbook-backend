package main

import (
	"github.com/labstack/echo/v4"
	"github.com/labstack/echo/v4/middleware"
	"net/http"

	"github.com/PtrTeixeira/cookbook/strava"
)

func main() {
	config := Config{}
	config.BaseURL = "localhost:8080"
	config.DashboardURL = "localhost:3000/dashboard"
	config.StravaClientID = "fake-client-id"
	config.StravaClientSecret = "fake-client-secret"

	e := echo.New()

	// Middleware
	e.Use(middleware.Logger())
	e.Use(middleware.Recover())

	// Routes
	// e.GET("/metrics", metrics)
	e.GET("/punchcard", getPunchcard)
	e.GET("/strava/login", config.redirectToStrava)
	e.GET("/strava/callback", stravaOauthCallback)

	// Start server
	e.Logger.Fatal(e.Start(":8080"))
}

// Handler
func hello(c echo.Context) error {
	return c.String(http.StatusOK, "Hello, World!")
}

func getAthlete(c echo.Context) error {
	client := strava.NewClient()
	_, err := client.GetAthlete("fake-token")

	return err
}

func metrics(e echo.Context) error {
	return nil
}

func getPunchcard(e echo.Context) error {
	return nil
}

func stravaOauthCallback(e echo.Context) error {
	return nil
}
