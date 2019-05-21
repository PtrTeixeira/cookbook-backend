package main

import (
	"fmt"
	"net/http"
	"net/url"
	"time"

	"github.com/labstack/echo/v4"
)

func (config *Config) redirectToStrava(c echo.Context) error {
	clientID := config.StravaClientID
	redirectURI := fmt.Sprintf("{}/strava/callback", config.BaseURL)
	responseType := "code"
	approvalPrompt := "auto"
	scope := "activity:read"
	state := "gensym"

	url, err := url.Parse("https://www.strava.com/oauth/authorize")
	if err != nil {
		panic(err)
	}
	query := url.Query()
	query.Set("client_id", clientID)
	query.Set("redirect_uri", redirectURI)
	query.Set("response_type", responseType)
	query.Set("approval_prompt", approvalPrompt)
	query.Set("scope", scope)
	query.Set("state", state)

	cookie := new(http.Cookie)
	cookie.Name = "AuthNonce"
	cookie.Value = state
	cookie.HttpOnly = true
	// cookie.Secure = true // Requres being served from an https server
	cookie.SameSite = http.SameSiteStrictMode
	cookie.Expires = time.Now().Add(24 * time.Hour)

	c.SetCookie(cookie)
	return c.Redirect(http.StatusSeeOther, "https://www.strava.com/oauth/authorize")
}
