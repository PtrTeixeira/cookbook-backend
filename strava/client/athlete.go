package strava

import (
	"encoding/json"
	"io"
	"io/ioutil"

	strava_api "github.com/PtrTeixeira/cookbook/strava/api"
)

func deserializeAthleteResponse(body io.Reader) (*strava_api.AthleteResponse, error) {
	asBytes, err := ioutil.ReadAll(body)
	if err != nil {
		return nil, err
	}

	value := strava_api.AthleteResponse{}
	err = json.Unmarshal(asBytes, &value)

	return &value, err
}

func deserializeAthleteActivitiesResponse(body io.Reader) ([]strava_api.AthleteActivity, error) {
	data := make([]strava_api.AthleteActivity, 0)
	asBytes, err := ioutil.ReadAll(body)
	if err != nil {
		return nil, err
	}

	err = json.Unmarshal(asBytes, &data)

	return data, err
}

func deserializeTokenResponse(body io.Reader) (*strava_api.TokenResponse, error) {
	asBytes, err := ioutil.ReadAll(body)
	if err != nil {
		return nil, err
	}

	value := strava_api.TokenResponse{}
	err = json.Unmarshal(asBytes, &value)

	return &value, err
}

func deserializeErrorResponse(body io.Reader) (*FaultWrapper, error) {
	asBytes, err := ioutil.ReadAll(body)
	if err != nil {
		return nil, err
	}
	value := strava_api.Fault{}
	err = json.Unmarshal(asBytes, &value)

	fault := FaultWrapper{
		value,
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
