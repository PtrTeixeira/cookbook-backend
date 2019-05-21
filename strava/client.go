package strava

import (
	"fmt"
	"net/http"

	. "github.com/PtrTeixeira/cookbook/proto/strava"
)

// Client is a client for the Strava API
type Client struct {
	client *http.Client
	config *Config
}

// NewClient is the factory function for
// strava clients
func NewClient() *Client {
	return &Client{
		http.DefaultClient,
		NewConfig(true),
	}
}

// GetAthlete returns the currently logged-in user
func (c *Client) GetAthlete(token string) (*AthleteResponse, error) {
	request, err := http.NewRequest("GET", "https://www.strava.com/api/v3/athlete", nil)
	if err != nil {
		return nil, err
	}
	request.Header.Add("Authorization", fmt.Sprintf("Bearer {}", token))

	resp, err := c.client.Do(request)
	if err != nil {
		return nil, err
	}

	if 400 <= resp.StatusCode && resp.StatusCode < 600 {
		fault, err := c.config.deserializeErrorResponse(resp.Body)
		if err != nil {
			return nil, err
		}

		return nil, fault
	}

	return c.config.deserializeAthleteResponse(resp.Body)
}

// GetAthleteActivities returns the logged-in user's activities
func (c *Client) GetAthleteActivities(token string, page int, perPage int) ([]AthleteActivity, error) {
	url := fmt.Sprintf("https://www.strava.com/api/v3/athlete/activities?page={}&per_page={}", page, perPage)
	request, err := http.NewRequest("GET", url, nil)
	if err != nil {
		return nil, err
	}
	request.Header.Add("Authorization", fmt.Sprintf("Bearer {}", token))

	resp, err := c.client.Do(request)
	if err != nil {
		return nil, err
	}

	return c.config.deserializeAthleteActivitiesResponse(resp.Body)
}

// GetToken returns the *initial* token for authentication with Strava
func (c *Client) GetToken(clientID, clientSecret, code string) (*TokenResponse, error) {
	url := fmt.Sprintf(
		"https://www.strava.com/oauth/token?client_id={}&client_secret={}&code={}&grant_type=authorization_code",
		clientID,
		clientSecret,
		code)
	request, err := http.NewRequest("POST", url, nil)
	if err != nil {
		return nil, err
	}

	resp, err := c.client.Do(request)
	if err != nil {
		return nil, err
	}
	// _ := "authorization_code" // grant type
	return c.config.deserializeTokenResponse(resp.Body)
}
