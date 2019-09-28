package strava

import (
	"testing"

	"gopkg.in/h2non/gock.v1"
)

func TestRequests(t *testing.T) {
	client := NewClient()

	t.Run("it handles successful GetAthlete requests", func(t *testing.T) {
		defer gock.Off()
		gock.New("https://www.strava.com").
			Get("/api/v3/athlete").
			Reply(200).
			BodyString(`
			{
				"id": 1234567890987654321,
				"username": "PtrTeixeira",
				"firstname": "Peter",
				"lastname": "Teixeira",
				"city": "Boston",
				"state": "MA",
				"country": "US",
				"sex": "M",
				"premium": true
			}
			`)

		athlete, err := client.GetAthlete("fake-token")
		if err != nil {
			t.Error("Failed to make request", err)
		}

		if athlete.Id != 1234567890987654321 {
			t.Error("Failed to get correct athlete")
		}
	})

	t.Run("it handles unsuccessful GetAthlete requests", func(t *testing.T) {
		defer gock.Off()
		gock.New("https://www.strava.com").
			Get("/api/v3/athlete").
			Reply(403).
			BodyString(`
			{
				"errors": [
					{
						"code": "error-code",
						"field": "aspect-in-error",
						"resource": "/athlete"
					}
				],
				"message": "Please don't do that again"
			}
			`)

		athlete, err := client.GetAthlete("fake-token")
		if err == nil || athlete != nil {
			t.Error("Request should have returned an error")
		}

		if err.Error() != "Please don't do that again" {
			t.Error("Got the incorrect value for the error")
		}
	})

	t.Run("it handles successful GetToken requests", func(t *testing.T) {
		defer gock.Off()
		gock.New("https://www.strava.com").
			Post("/oauth/token").
			MatchParam("client_id", "client-id").
			MatchParam("client_secret", "client-secret").
			MatchParam("code", "redirect-code").
			MatchParam("grant_type", "authorization_code").
			Reply(200).
			BodyString(`
			{
				"token_type": "Bearer",
				"access_token": "987654321234567898765432123456789",
				"athlete": {
				  "id": 1234567890987654321
				},
				"refresh_token": "1234567898765432112345678987654321",
				"expires_at": 1531378346,
				"state": "STRAVA"
			  }
			`)

		token, err := client.GetToken("client-id", "client-secret", "redirect-code")
		if err != nil {
			t.Error("Failed to make request", err)
		}

		if token.AccessToken != "987654321234567898765432123456789" {
			t.Error("Failed to get correct athlete")
		}
	})
}
