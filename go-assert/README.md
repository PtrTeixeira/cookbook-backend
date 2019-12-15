# go-assert

A custom testing framework for go code. Exists to avoid adding a
dependency on an external testing library (which in Bazel is still a
little painful) and to get some experience with writing testing
libraries, which has - for better or for worse - always been
something of a dream of mine.

Does this work? Yeah, kinda. There's one sense in which the best
thing I can do now is "add more assertions," but the more serious
bug is that I need to prune the stacktrace to point into the 
tested code instead of the testing code. Otherwise it's fine.

## Usage

```go
import "testing"

func TestMyFeature(t *testing.T) {
  t.Run("MyFeatureWorks", func(t *testing.T) {
    AssertThatBool(t, MyFeature(), IsTrue())
  })
}
```

The parts that come from this library are 
`AssertThatBool` and the matcher `IsTrue`.
All the other stuff is standard go test code.

Not sure how discoverable matchers are at the moment.  But for what
I need, this library works pretty okay.
