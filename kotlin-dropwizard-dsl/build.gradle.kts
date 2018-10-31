plugins {
    kotlin("jvm")
    id("com.diffplug.gradle.spotless")
}

spotless {
    kotlin {
        ktlint()
    }
}

val versions: Map<String, String> by extra
dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("io.dropwizard", "dropwizard-core", versions["DROPWIZARD"])
    implementation("io.dropwizard", "dropwizard-auth", versions["DROPWIZARD"])
}
