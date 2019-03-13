# punchcard

See when you run, using data from Strava.

## Background

My idea here was to see when in a week I run,
inspired roughly by GitHub's contributions chart.
So this whole application produces a grid like:

```
         Day of Week
   _________________________
H |
o |
u |
r |
  |
o |
f |
  |
D |
a |
y |
```

Which is what it does.

Notably, there's no persistent server-side
data here. Neither the Strava auth token nor
the refresh token get saved by the server.
Instead, the auth token is saved as a cookie
client-side.

## Endpoints

* `/metrics` - JSON blob of application metrics. Should probably not be
  publicly exposed.
* `/strava/login` - Start-OAuth-flow endpoint. The UI should link the user
  here, and it will redirect the user to the Strava login OAuth page to
  authorize the application.
* `/strava/callback` - End-OAuth-flow endpoint. The Strava OAuth flow
  redirects to this endpoint. It grabs all the access-token things and
  redirects the user back to the UI dashboard.
* `/punchcard` - The actually useful endpoint. Uses the user's token to
  grab user activities from Strava. Output looks like:

```json
{
  "MONDAY": {
    "18": 4,
    "19": 1
  },
  "TUESDAY": {
    "18": 4,
    "19": 1
  },
  "WEDNESDAY": {
    "18": 4,
    "19": 1
  },
  "THURSDAY": {
    "18": 4,
    "19": 1
  },
  "FRIDAY": {
    "18": 4,
    "19": 1
  },
  "SATURDAY": {
    "13": 6,
    "14": 4
  },
  "SUNDAY": {
    "8": 4,
    "9": 10
  }
}
```

So it's a `Map<DayOfWeek, Map<HourOfWeek, Count>>`. The hours are counted
from midnight (0 = midnight, 12 = noon, 18 = 6pm, etc).

## Configuration

Should look something like:

```yaml
# Base URL for the API. eg, if the puncard
# endpoint is `example.com/api/v3/punchcard`,
# then this would be `example.com/api/v3`
baseUrl: localhost:8080

# URL for dashboard. This is literally where
# the user will be redirected after logging in
dashboardUrl: localhost:3000/dashboard

# These come from Strava when you set up your application.
stravaClientId: xxxx
stravaClientSecret: xxxx
```

Technically, you don't *need* a config file; all of these have
defaults. However, I can assure you the default client ID and
client secret are incorrect, so you won't actually be able to
connect to Strava without those.
