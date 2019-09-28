package main

import (
	"testing"
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
