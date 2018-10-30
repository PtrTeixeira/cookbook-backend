plugins {
    kotlin("jvm") version "1.2.71"
    id("com.diffplug.gradle.spotless") version "3.14.0"
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
    implementation("com.fasterxml.jackson.module", "jackson-module-kotlin", versions["JACKSON"])
    implementation("com.fasterxml.jackson.datatype", "jackson-datatype-jdk8", versions["JACKSON"])
}
