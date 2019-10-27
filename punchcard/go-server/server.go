package main

import (
	"fmt"
	"net/http"
	"net/url"
	"time"

	"github.com/getsentry/sentry-go"
	sentryecho "github.com/getsentry/sentry-go/echo"
	"github.com/labstack/echo/v4"
	"github.com/labstack/echo/v4/middleware"
	"github.com/labstack/gommon/log"
	"github.com/pkg/errors"

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
	e.HideBanner = true
	e.Logger.SetLevel(log.INFO)
	h := handler{
		cfg:    config,
		client: strava.NewClient(),
		log:    e.Logger,
	}

	initializeSentry(e.Logger, config)

	// Middleware
	e.Use(middleware.Logger())
	e.Use(middleware.Recover())
	e.Use(sentryecho.New(sentryecho.Options{
		Repanic: true,
		Timeout: time.Second * 3,
	}))

	// Routes
	e.GET("/health", h.healthCheck)
	e.GET("/punchcard", h.getPunchcard)
	e.GET("/strava/login", h.redirectToStrava)
	e.GET("/strava/callback", h.stravaOauthCallback)

	// Start server
	e.Logger.Fatal(e.Start(":8080"))
}

func initializeSentry(log echo.Logger, config *Config) {
	sentryDsn := config.SentryDsn
	if sentryDsn == "" {
		log.Info("Sentry DSN was unset, will not report to Sentry")
		return
	}

	if config.Environment == "local" {
		log.Info("Environment is \"local\", won't report to Sentry")
		return
	}

	err := sentry.Init(sentry.ClientOptions{
		Dsn: sentryDsn,
	})

	if err != nil {
		log.Warnf("Sentry initialization failed: %v\n", err)
	}
}

// Handler
func (h handler) redirectToStrava(c echo.Context) error {
	dest, err := url.Parse("https://www.strava.com/oauth/authorize")
	if err != nil {
		return err
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
		return errors.New("Strava client ID or secret was blank!")
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
		h.log.Warn("Could not get redirect params", err)
		return c.NoContent(http.StatusBadRequest)
	}

	if params.Err == "access_denied" {
		h.log.Warn("Access was denied for user, cannot proceed")
		return c.Redirect(http.StatusSeeOther, "http://strava.com")
	}

	client := h.client
	response, err := client.GetToken("x"+h.cfg.StravaClientID, h.cfg.StravaClientSecret, params.Code)
	if err != nil {
		e := errors.Wrap(err, "Could not get auth token from Strava")
		if hub := sentryecho.GetHubFromContext(c); hub != nil {
			h.log.Info("Got Hub from context; sending to sentry")
			hub.CaptureException(e)
			return e
		}
		return err
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
