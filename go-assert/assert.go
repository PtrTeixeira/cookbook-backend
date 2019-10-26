package assert

import (
	"testing"
)

type BooleanAssertion func(val bool) (bool, string)

func IsTrue() BooleanAssertion {
	return func(val bool) (bool, string) {
    if !val {
      return false, "Expected true but was: \"false\""
    }
    return val, ""
  }
}

func AssertThat(t *testing.T, val bool, test BooleanAssertion) {
  if result, msg := test(val); !result {
    t.Error(msg)
  }
}
