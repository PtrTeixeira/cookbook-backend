package main

import (
	"fmt"
	"net/http"
	"net/url"

	"github.com/labstack/echo/v4"
	"github.com/labstack/echo/v4/middleware"

	strava "github.com/PtrTeixeira/cookbook/strava/client"
)

type Handler struct {
	cfg    Config
	client strava.Client
}

func main() {
	config := InitConfig()
	h := Handler{cfg: config}

	e := echo.New()

	// Middleware
	e.Use(middleware.Logger())
	e.Use(middleware.Recover())

	// Routes
	e.GET("/metrics", h.metrics)
	e.GET("/punchcard", h.getPunchcard)
	e.GET("/strava/login", h.redirectToStrava)
	// 	e.GET("/strava/callback", stravaOauthCallback)

	// Start server
	e.Logger.Fatal(e.Start(":8080"))
}

// Handler
func (h Handler) redirectToStrava(c echo.Context) error {
	dest, err := url.Parse("https://www.strava.com/oauth/authorize")
	if err != nil {
		return c.NoContent(http.StatusInternalServerError)
	}

	redirectUrl := fmt.Sprintf("%s/strava/callback", h.cfg.BaseURL)
	queryParams := dest.Query()
	queryParams.Set("client_id", h.cfg.StravaClientID)
	queryParams.Set("redirect_uri", redirectUrl)
	queryParams.Set("response_type", "code")
	queryParams.Set("scope", "read,activity:read")

	dest.RawQuery = queryParams.Encode()

	return c.Redirect(http.StatusSeeOther, dest.String())
}

func getAthlete(c echo.Context) error {
	client := strava.NewClient()
	_, err := client.GetAthlete("fake-token")

	return err
}

func (h Handler) metrics(e echo.Context) error {
	return nil
}

func (h Handler) getPunchcard(e echo.Context) error {
	return nil
}

func (h Handler) stravaOauthCallback(e echo.Context) error {
	return nil
}
