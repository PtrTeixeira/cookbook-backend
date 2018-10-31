plugins {
    kotlin("jvm")
    id("com.diffplug.gradle.spotless")
}

apply {
    from("$rootDir/gradle/kotlin.gradle")
    from("$rootDir/gradle/junit.gradle")
}

spotless {
    kotlin {
        ktlint()
    }
}

val versions: Map<String, String> by extra
dependencies {
    compile("io.sentry", "sentry-logback", versions["SENTRY"])
    compile("com.fasterxml.jackson.core", "jackson-annotations", versions["JACKSON"])
    compile("io.dropwizard", "dropwizard-logging", versions["DROPWIZARD"])

    testCompile("org.assertj", "assertj-core", versions["ASSERTJ"])
}
