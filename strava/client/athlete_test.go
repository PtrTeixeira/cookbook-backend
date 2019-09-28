package strava

import (
	"strings"
	"testing"
)

func TestDeserialize(t *testing.T) {
	t.Run("it deserializes an AthleteResponse response missing some fields", func(t *testing.T) {
		athleteResponseMissingFields := `{"id": 5454}`
		data, err := deserializeAthleteResponse(strings.NewReader(athleteResponseMissingFields))

		if err != nil {
			t.Error("Failed to deserialize response")
		}
		if data.Id != 5454 {
			t.Error("Deserialization failed; incorrect values")
		}
	})

	t.Run("it deserializes an AthleteResponse with some extra fields", func(t *testing.T) {
		athleteResponseMissingFields := `{"id": 5454, "city": "San Francisco"}`
		data, err := deserializeAthleteResponse(strings.NewReader(athleteResponseMissingFields))

		if err != nil {
			t.Error("Failed to deserialize response", err)
		}
		if data.Id != 5454 {
			t.Error("Deserialization failed; incorrect values")
		}
	})

	t.Run("it deserializes an empty AthleteActivitiesResponse", func(t *testing.T) {
		athleteActivitiesResponse := `[]`
		data, err := deserializeAthleteActivitiesResponse(strings.NewReader(athleteActivitiesResponse))

		if err != nil {
			t.Error("Failed to deserialize response", err)
		}
		if len(data) != 0 {
			t.Error("Deserialization failed; incorrect value")
		}
	})

	t.Run("it deserializes an AthleteActivitiesResponse with data", func(t *testing.T) {
		athleteActivitiesResponse := `
		[
			{
				"id": 1001,
				"athlete": {
					"id": 5454,
					"resource_state": 1
				},
				"name": "Happy Friday",
				"start_date": "2018-05-02T12:15:09Z",
				"start_date_local": "2018-05-02T05:15:09Z"
			}
		]
		`
		data, err := deserializeAthleteActivitiesResponse(strings.NewReader(athleteActivitiesResponse))

		if err != nil {
			t.Error("Failed to deserialize response", err)
		}
		if len(data) != 1 {
			t.Error("Deserialization failed; incorrect value")
		}
		if data[0].Id != 1001 {
			t.Error("Deserialization failed; incorrect value")
		}
	})

	t.Run("it deserializes a token response", func(t *testing.T) {
		tokenResponse := `
		{
			"access_token": "blahblah",
			"token_type": "Bearer",
			"athlete": {
				"id": 5454,
				"resource_state": 1
			},
			"refresh_token": "foobar",
			"expires_at": 1531378346,
			"state": "extradata"
		}
		`
		data, err := deserializeTokenResponse(strings.NewReader(tokenResponse))

		if err != nil {
			t.Error("Failed to deserialize response", err)
		}
		if data.AccessToken != "blahblah" {
			t.Error("Deserialization failed; incorrect value")
		}
	})

	t.Run("it deserialzes an error response", func(t *testing.T) {
		errorResponse := `
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
		`
		data, err := deserializeErrorResponse(strings.NewReader(errorResponse))

		if err != nil {
			t.Error("Failed to deserialize response", err)
		}
		if data.Error() != "Please don't do that again" {
			t.Error("Deserialization failed; incorrect value")
		}
	})
}
