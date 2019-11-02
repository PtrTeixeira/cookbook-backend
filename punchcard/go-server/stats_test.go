package main

import (
	"testing"

	"github.com/PtrTeixeira/cookbook/strava/api"
)

func TestAddToMap(t *testing.T) {
	t.Run("it sets the value to 1 if the value was absent", func(t *testing.T) {
		dest := make(map[int]int)
		increment(4, dest)
		if dest[4] != 1 {
			t.Errorf("Expected value 1, was %v", dest[4])
		}
	})
	t.Run("it increments the value in the map if it is present", func(t *testing.T) {
		dest := make(map[int]int)
		dest[4] = 2
		increment(4, dest)
		if dest[4] != 3 {
			t.Errorf("Expected value 3, was %v", dest[4])
		}
	})
}

func TestGetSingleDistanceDifference(t *testing.T) {
	t.Run("it returns a negative number for values between x.5-(x+1)", func(t *testing.T) {
		result := getSingleDistanceDifference(4.9)
		if result != -1 {
			t.Errorf("Expected value -1, was %v", result)
		}
	})

	t.Run("it returns positive numbers for values between x-x.5", func(t *testing.T) {
		result := getSingleDistanceDifference(4.4)
		if result != 4 {
			t.Errorf("Expected value 4, was %v", result)
		}
	})
}

func TestGetDistanceDifferences(t *testing.T) {
	ONE_MILE := 1604.344

	t.Run("it computes a single distance difference", func(t *testing.T) {
		activity := api.AthleteActivity{
			Distance: 4.9 * ONE_MILE,
		}
		activities := []api.AthleteActivity{activity}
		result := GetDistanceDifference(activities)

		if len(result) != 1 {
			t.Errorf("Expected size of map to be 1, was %v", len(result))
		}

		if result[-1] != 1 {
			t.Errorf("Expected value for key -1 to be 1, was %v", result[-1])
		}
	})

	t.Run("it computes distance differences for multiple activities", func(t *testing.T) {
		activity1 := api.AthleteActivity{
			Distance: 4.9 * ONE_MILE,
		}
		activity2 := api.AthleteActivity{
			Distance: 10.2 * ONE_MILE,
		}
		activity3 := api.AthleteActivity{
			Distance: 6.24 * ONE_MILE,
		}
		activities := []api.AthleteActivity{activity1, activity2, activity3}
		result := GetDistanceDifference(activities)

		if len(result) != 2 {
			t.Errorf("Expected size of map to be 2, was %v", len(result))
		}

		if result[-1] != 1 {
			t.Errorf("Expected value for key -1 to be 1, was %v", result[-1])
		}

		if result[2] != 2 {
			t.Errorf("Expected value for key 2 to be 2, was %v", result[2])
		}
	})
}
