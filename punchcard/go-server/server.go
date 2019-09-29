package main

import (
	"fmt"
	"net/http"
	"net/url"
	"time"

	"github.com/labstack/echo/v4"
	"github.com/labstack/echo/v4/middleware"
	"github.com/labstack/gommon/log"

	strava "github.com/PtrTeixeira/cookbook/strava/client"
)

type handler struct {
	cfg    *Config
	client *strava.Client
	log    echo.Logger
}

// RedirectParams are the parameters from the Strava oauth redirect
type RedirectParams struct {
	Err   string `form:"error" query:"error"`
	Code  string `form:"code" query:"code"`
	State string `form:"email" query:"state"`
}

func main() {
	config, err := InitConfig()
	if err != nil {
		panic(err)
	}

	e := echo.New()
	e.Logger.SetLevel(log.INFO)
	h := handler{
		cfg:    config,
		client: strava.NewClient(),
		log:    e.Logger,
	}

	// Middleware
	e.Use(middleware.Logger())
	e.Use(middleware.Recover())

	// Routes
	e.GET("/health", h.healthCheck)
	e.GET("/punchcard", h.getPunchcard)
	e.GET("/strava/login", h.redirectToStrava)
	e.GET("/strava/callback", h.stravaOauthCallback)

	// Start server
	e.Logger.Fatal(e.Start(":8080"))
}

// Handler
func (h handler) redirectToStrava(c echo.Context) error {
	dest, err := url.Parse("https://www.strava.com/oauth/authorize")
	if err != nil {
		return c.NoContent(http.StatusInternalServerError)
	}

	redirectURL := fmt.Sprintf("%s/strava/callback", h.cfg.BaseURL)
	queryParams := dest.Query()
	queryParams.Set("client_id", h.cfg.StravaClientID)
	queryParams.Set("redirect_uri", redirectURL)
	queryParams.Set("response_type", "code")
	queryParams.Set("scope", "read,activity:read")

	dest.RawQuery = queryParams.Encode()

	return c.Redirect(http.StatusSeeOther, dest.String())
}

func (h handler) healthCheck(c echo.Context) error {
	if h.cfg.StravaClientID == "" || h.cfg.StravaClientSecret == "" {
		return c.NoContent(http.StatusInternalServerError)
	}

	return c.NoContent(http.StatusOK)
}

func (h handler) getPunchcard(c echo.Context) error {
	authCookie, err := c.Cookie("StravaAuthToken")
	if err != nil {
		h.log.Warn("Could not read access token from cookie", err)
		return c.NoContent(http.StatusForbidden)
	}

	response, err := h.client.GetAthleteActivities(authCookie.Value, 1, 50)
	if err != nil {
		h.log.Error("Could not read data athlete data from Strava", err)
	}
	punchcard := GetPunchcard(response)

	return c.JSON(http.StatusOK, punchcard)
}

func (h handler) stravaOauthCallback(c echo.Context) error {
	params := new(RedirectParams)
	if err := c.Bind(params); err != nil {
		h.log.Errorf("Could not get redirect params", err)
		return c.NoContent(http.StatusInternalServerError)
	}

	if params.Err == "access_denied" {
		h.log.Warn("Access was denied for user, cannot proceed")
		return c.Redirect(http.StatusSeeOther, "http://strava.com")
	}

	client := h.client
	response, err := client.GetToken(h.cfg.StravaClientID, h.cfg.StravaClientSecret, params.Code)
	if err != nil {
		h.log.Errorf("Could not get auth token from Strava: %+v", err)
		return c.NoContent(http.StatusInternalServerError)
	}

	cookie := new(http.Cookie)
	cookie.Name = "StravaAuthToken"
	cookie.Value = response.AccessToken
	cookie.Expires = time.Now().Add(24 * time.Hour)
	cookie.Path = "/"
	cookie.HttpOnly = true
	cookie.SameSite = http.SameSiteStrictMode
	c.SetCookie(cookie)
	return c.Redirect(http.StatusSeeOther, h.cfg.DashboardURL)
}
