package strava

import (
	jsonpb "github.com/golang/protobuf/jsonpb"
)

// Config is configuration elements for the client
type Config struct {
	Unmarshaler jsonpb.Unmarshaler
}

// NewConfig creates a new configuration object
func NewConfig(allowUnknownFields bool) *Config {
	return &Config{
		jsonpb.Unmarshaler{
			allowUnknownFields,
			nil,
		},
	}
}
