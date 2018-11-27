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
    implementation(kotlin("reflect", versions["KOTLIN"]))
    implementation("com.fasterxml.jackson.module", "jackson-module-kotlin", versions["JACKSON"])
    implementation("com.fasterxml.jackson.datatype", "jackson-datatype-jdk8", versions["JACKSON"])
}
