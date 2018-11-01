import com.diffplug.gradle.spotless.SpotlessTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.0" apply false
    kotlin("kapt") version "1.3.0" apply false
    id("com.diffplug.gradle.spotless") version "3.15.0" apply false
}

buildscript {
    repositories {
        jcenter()
    }
}

allprojects {
    group = "com.github.ptrteixeira.cookbook"
    version = "0.3.1"
}

subprojects {
    repositories {
        jcenter()
    }

    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = "1.8"
            freeCompilerArgs = listOf("-progressive")
        }
    }

    extra["versions"] = mapOf(
            "ASSERTJ" to "3.11.1",
            "COROUTINES" to "1.0.0",
            "DAGGER" to "2.19",
            "DROPWIZARD_DAGGER" to "0.1.0-alpha03",
            "DROPWIZARD" to "1.3.5",
            "GOOGLE_API" to "1.25.0",
            "H2" to "1.4.197",
            "JACKSON" to "2.9.7",
            "JDBI" to "3.5.1",
            "JERSEY" to "2.25.1",
            "MICROMETER" to "1.1.0",
            "MOCKITO" to "2.23.0",
            "REACTOR" to "3.2.2.RELEASE",
            "RETROFIT" to "2.4.0",
            "RETROFIT_REACTOR_ADAPTER" to "2.1.0",
            "RXJAVA" to "2.2.3",
            "SENTRY" to "1.7.13",
            "SLF4J" to "1.7.25"
    )
}
