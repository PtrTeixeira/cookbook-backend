# strava-api

Bindings to the Strava API on the JVM.

## Is this good?

No. Don't use this, use the official API client instead. You 
can generate that from the OpenAPI / Swagger description by following 
the instructions [here](https://developers.strava.com/docs/#client-code).

Even *if* you for some reason you wanted to use this - and again, you 
shouldn't - it only supports the one method that I needed to write my 
application. So unless you were writing the exact same application, you 
are probably SOL.

## Usage

```kotlin
// object dependencies ...
val objectMapper = ObjectMapper()
val retrofit = Retrofit.Builder()
  .baseUrl("https://www.strava.com/api/v3")
  .addConverterFactory(JacksonConverterFactory.create(objectMapper))
  .addCallAdapterFactory(ReactorCallAdapterFactory.create())
  .build()
val stravaApi = retrofit.create(StravaApi::class.java)
val stravaService = StravaService(stravaApi)

// The interesting part
stravaService
  // clientId, clientSecret - From setting up your application in Strava
  // code - From the OAuth redirect
  // See http://developers.strava.com/docs/authentication/ for more 
  // information.
  .getAuthToken(clientId, clientSecret, code)
  .flatMapMany { authToken -> 
    // authToken also contains a refresh token. See the docs for more 
    // information
    val accessToken = authToken.accessToken
    
    stravaService.getAthleteActivities(accessToken, startTime)
  }.subscribe { 
    // Prints each activity
    println(it)
  }
```

