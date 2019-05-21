package strava

import (
	"encoding/json"
	"io"
	"io/ioutil"

	strava_api "github.com/PtrTeixeira/cookbook/proto/strava"
)

func (c *Config) deserializeAthleteResponse(body io.Reader) (*strava_api.AthleteResponse, error) {
	data := strava_api.AthleteResponse{}
	err := c.Unmarshaler.Unmarshal(body, &data)

	return &data, err
}

func (c *Config) deserializeAthleteActivitiesResponse(body io.Reader) ([]strava_api.AthleteActivity, error) {
	data := make([]strava_api.AthleteActivity, 0)
	asBytes, err := ioutil.ReadAll(body)
	if err != nil {
		return nil, err
	}

	err = json.Unmarshal(asBytes, &data)

	return data, err
}

func (c *Config) deserializeTokenResponse(body io.Reader) (*strava_api.TokenResponse, error) {
	data := strava_api.TokenResponse{}
	err := c.Unmarshaler.Unmarshal(body, &data)

	return &data, err
}

func (c *Config) deserializeErrorResponse(body io.Reader) (*FaultWrapper, error) {
	data := strava_api.Fault{}
	err := c.Unmarshaler.Unmarshal(body, &data)

	fault := FaultWrapper{
		data,
	}

	return &fault, err
}

// A FaultWrapper is a wrapper around the Fault type returned from the
// Strava api.
type FaultWrapper struct {
	fault strava_api.Fault
}

func (f *FaultWrapper) Error() string {
	return f.fault.Message
}
