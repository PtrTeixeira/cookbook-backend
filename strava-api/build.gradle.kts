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
    compile("com.squareup.retrofit2", "retrofit", versions["RETROFIT"])
    compile("io.projectreactor", "reactor-core", versions["REACTOR"])

    implementation("com.fasterxml.jackson.datatype", "jackson-datatype-jdk8", versions["JACKSON"])
    implementation("com.fasterxml.jackson.core", "jackson-annotations", versions["JACKSON"])
    implementation("com.fasterxml.jackson.module", "jackson-module-kotlin", versions["JACKSON"])

    testCompile("org.mockito", "mockito-core", versions["MOCKITO"])
    testCompile("io.projectreactor", "reactor-test", versions["REACTOR"])
}
