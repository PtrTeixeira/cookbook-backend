package strava

import (
	"fmt"
	"net/http"
	"net/url"

	. "github.com/PtrTeixeira/cookbook/strava/api"
)

// Client is a client for the Strava API
type Client struct {
	client *http.Client
}

// NewClient is the factory function for
// strava clients
func NewClient() *Client {
	return &Client{
		http.DefaultClient,
	}
}

// GetAthlete returns the currently logged-in user
func (c *Client) GetAthlete(token string) (*AthleteResponse, error) {
	request, err := http.NewRequest("GET", "https://www.strava.com/api/v3/athlete", nil)
	if err != nil {
		return nil, err
	}
	request.Header.Add("Authorization", fmt.Sprintf("Bearer %s", token))

	resp, err := c.client.Do(request)
	if err != nil {
		return nil, err
	}

	if 400 <= resp.StatusCode && resp.StatusCode < 600 {
		fault, err := deserializeErrorResponse(resp.Body)
		if err != nil {
			return nil, err
		}

		return nil, fault
	}

	return deserializeAthleteResponse(resp.Body)
}

// GetAthleteActivities returns the logged-in user's activities
func (c *Client) GetAthleteActivities(token string, page int, perPage int) ([]AthleteActivity, error) {
	url := fmt.Sprintf("https://www.strava.com/api/v3/athlete/activities?page=%d&per_page=%d", page, perPage)
	request, err := http.NewRequest("GET", url, nil)
	if err != nil {
		return nil, err
	}
	request.Header.Add("Authorization", fmt.Sprintf("Bearer %s", token))

	resp, err := c.client.Do(request)
	if err != nil {
		return nil, err
	}

	if 400 <= resp.StatusCode && resp.StatusCode < 600 {
		fault, err := deserializeErrorResponse(resp.Body)
		if err != nil {
			return nil, err
		}

		return nil, fault
	}

	return deserializeAthleteActivitiesResponse(resp.Body)
}

// GetToken returns the *initial* token for authentication with Strava
func (c *Client) GetToken(clientID, clientSecret, code string) (*TokenResponse, error) {
	dest, err := url.Parse("https://www.strava.com/oauth/token")
	if err != nil {
		return nil, err
	}

	params := dest.Query()
	params.Add("client_id", clientID)
	params.Add("client_secret", clientSecret)
	params.Add("code", code)
	params.Add("grant_type", "authorization_code")
	dest.RawQuery = params.Encode()
	request, err := http.NewRequest("POST", dest.String(), nil)
	if err != nil {
		return nil, err
	}

	resp, err := c.client.Do(request)
	if err != nil {
		return nil, err
	}

	if 400 <= resp.StatusCode && resp.StatusCode < 600 {
		fault, err := deserializeErrorResponse(resp.Body)
		if err != nil {
			return nil, err
		}

		return nil, fault
	}

	return deserializeTokenResponse(resp.Body)
}
