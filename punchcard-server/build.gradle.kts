plugins {
    distribution
    application
    id("nebula.kotlin") version "1.2.60"
    id("org.jetbrains.kotlin.kapt") version "1.2.60"
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

application {
    mainClassName = "com.github.ptrteixeira.punchcard.StravaPunchcardApplication"
}

val distTar by tasks.getting(Tar::class) {
    compression = Compression.GZIP
}

val versions: Map<String, String> by extra
dependencies {
    compile(project(":kotlin-dropwizard-dsl"))
    compile(project(":sentry-appender"))
    compile(project(":strava-api"))
    compile("io.dropwizard", "dropwizard-core", "${versions["DROPWIZARD"]}")
    compile("io.sentry", "sentry-logback", "${versions["SENTRY"]}")
    compile("io.micrometer", "micrometer-core", "${versions["MICROMETER"]}")
    compile("io.micrometer", "micrometer-registry-prometheus", "${versions["MICROMETER"]}")
    compile("com.fasterxml.jackson.module", "jackson-module-kotlin", "${versions["JACKSON"]}")
    compile("com.fasterxml.jackson.datatype", "jackson-datatype-jdk8", "${versions["JACKSON"]}")
    compile("com.jakewharton.retrofit", "retrofit2-reactor-adapter", "${versions["RETROFIT_REACTOR_ADAPTER"]}")
    compile("com.squareup.retrofit2", "converter-jackson", "${versions["RETROFIT"]}")
    compile("org.jetbrains.kotlinx", "kotlinx-coroutines-core", "${versions["COROUTINES"]}")
    compile("org.jetbrains.kotlinx", "kotlinx-coroutines-reactive", "${versions["COROUTINES"]}")
    compile("com.google.dagger", "dagger", "${versions["DAGGER"]}")
    compile("com.tylerkindy", "dropwizard-dagger", "${versions["DROPWIZARD_DAGGER"]}")
    kapt("com.google.dagger", "dagger-compiler", "${versions["DAGGER"]}")

    testCompile("org.assertj", "assertj-core", "${versions["ASSERTJ"]}")
    testCompile("io.dropwizard", "dropwizard-testing", "${versions["DROPWIZARD"]}")
    testCompile("org.glassfish.jersey.test-framework.providers", "jersey-test-framework-provider-grizzly2", "${versions["JERSEY"]}") {
        exclude(group = "junit", module = "junit")
        exclude(group = "javax.servlet", module = "javax.servlet-api")
    }
    testCompile("org.mockito", "mockito-core", "${versions["MOCKITO"]}")
    kaptTest("com.google.dagger", "dagger-compiler", "${versions["DAGGER"]}")
}
