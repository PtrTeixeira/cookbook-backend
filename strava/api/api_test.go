package api

import (
  "encoding/json"
  "testing"
)

func TestApi(t *testing.T) {
  t.Run("deserializing from json", func(t *testing.T) {
    response := []byte(`
    {
      "id": 4,
      "username": "ptrteixeira",
      "firstname": "Peter",
      "lastname": "Teixeira"
    }`)
    var result AthleteResponse

    json.Unmarshal(response, &result)

    if result.Id != 4 {
      t.Errorf("Expected id to be 4")
    }
  })
}
