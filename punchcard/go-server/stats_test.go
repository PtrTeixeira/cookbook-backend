package main

import (
	"testing"

	. "github.com/PtrTeixeira/cookbook/go-assert"
)

func TestAddToMap(t *testing.T) {
	t.Run("it sets the value to 1 if the value was absent", func(t *testing.T) {
		dest := make(map[int]int)
		increment(4, dest)
		AssertThatInt(t, dest[4], IsEqualToInt(1))
	})

	t.Run("it increments the value in the map if it is present", func(t *testing.T) {
		dest := make(map[int]int)
		dest[4] = 2
		increment(4, dest)
		AssertThatInt(t, dest[4], IsEqualToInt(3))
	})
}
