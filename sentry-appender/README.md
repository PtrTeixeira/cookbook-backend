# sentry-appender

This binds the Sentry logback appender to the Dropwizard
logging appender factory, for easy use in Dropwizard applications.

## Usage

1. Make sure this jar is available at runtime
2. Add the following to your Dropwizard config file:

```yaml
logging:
  appenders:
   - type: sentry
     threshold: ERROR
   - type: console
```

This will send everything logged at the ERROR level to Sentry.

## Background

This is an extremely small wrapper over the existing
[sentry-logback](https://docs.sentry.io/clients/java/modules/logback/)
library. It just wraps that logger in a wrapper class and adds a
manifest file that lets Dropwizard's service loader discover it
from the configuration file.
