package assert

import (
	"testing"
)

func TestBooleanAssertion(t *testing.T) {
  t.Run("IsTrue matches true", func(t *testing.T) {
    matcher := IsTrue()
    result, _ := matcher(true)

    if !result {
      t.Errorf("Should have matched true!")
    }
  })

  t.Run("IsTrue does not match false", func(t *testing.T) {
    matcher := IsTrue()
    result, msg := matcher(false)

    if result {
      t.Errorf("Should not have matched false!")
    }
    if msg != "Expected true but was: \"false\"" {
      t.Errorf("Got incorrect message: %q", msg)
    }
  })
}

// TODO(pteixeira) Need to modify how the stackframe unwinds 
// to get the error message to come from lines like this, 
// rather than from a line in this library
func TestAssertThat(t *testing.T) {
  t.Run("AssertThat does nothing when matched", func(t *testing.T) {
    AssertThat(t, true, IsTrue())
  })
}
