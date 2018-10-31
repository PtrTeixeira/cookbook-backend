buildscript {
    repositories {
        jcenter()
    }
}

subprojects {
    group = "com.github.ptrteixeira.cookbook"
    version = "0.3.1"

    repositories {
        jcenter()
    }

    extra["versions"] = mapOf(
            "ASSERTJ" to "3.10.0",
            "COROUTINES" to "0.25.0",
            "DAGGER" to "2.17",
            "DROPWIZARD_DAGGER" to "0.1.0-alpha03",
            "DROPWIZARD" to "1.3.5",
            "GOOGLE_API" to "1.23.0",
            "H2" to "1.4.197",
            "JACKSON" to "2.9.6",
            "JDBI" to "3.3.0",
            "JERSEY" to "2.25.1",
            "MICROMETER" to "1.0.6",
            "MOCKITO" to "2.21.0",
            "REACTOR" to "3.1.8.RELEASE",
            "RETROFIT" to "2.4.0",
            "RETROFIT_REACTOR_ADAPTER" to "2.1.0",
            "RXJAVA" to "2.2.0",
            "SENTRY" to "1.7.5",
            "SLF4J" to "1.7.25"
    )
}
