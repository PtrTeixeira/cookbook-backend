plugins {
    kotlin("jvm") version "1.2.71"
    id("com.diffplug.gradle.spotless") version "3.14.0"
}

apply {
    from("$rootDir/gradle/kotlin.gradle")
}

spotless {
    kotlin {
        ktlint()
    }
}

val versions: Map<String, String> by extra
dependencies {
    implementation("io.dropwizard", "dropwizard-core", versions["DROPWIZARD"])
    implementation("io.dropwizard", "dropwizard-auth", versions["DROPWIZARD"])
}
