package assert

import (
	"fmt"
	"testing"
)

type BooleanAssertion func(val bool) (bool, string)
type IntegerAssertion func(val int) (bool, string)

func IsTrue() BooleanAssertion {
	return IsEqualToBool(true)
}

func IsFalse() BooleanAssertion {
	return IsEqualToBool(false)
}

func IsEqualToBool(cond bool) BooleanAssertion {
	return func(val bool) (bool, string) {
		if val != cond {
			return false, fmt.Sprintf("Expected \"%v\" but was: \"%v\"", cond, val)
		}
		return true, ""
	}
}

func IsEqualToInt(cond int) IntegerAssertion {
	return func(val int) (bool, string) {
		if val != cond {
			return false, fmt.Sprintf("Expected \"%v\" but was: \"%v\"", cond, val)
		}
		return true, ""
	}
}

func AssertThatBool(t *testing.T, val bool, test BooleanAssertion) {
	if result, msg := test(val); !result {
		t.Error(msg)
	}
}

func AssertThatInt(t *testing.T, val int, test IntegerAssertion) {
	if result, msg := test(val); !result {
		t.Error(msg)
	}
}
