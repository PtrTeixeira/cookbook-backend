buildscript {
    repositories {
        jcenter()
    }
}

plugins {
    application
    kotlin("jvm") version "1.2.60"
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
    mainClassName = "com.github.ptrteixeira.cookbook.CookbookApplication"
}

val distTar by tasks.getting(Tar::class) {
    compression = Compression.GZIP
}


val versions: Map<String, String> by extra
dependencies {
    compile(project(":recipe-api"))
    compile(project(":kotlin-dropwizard-dsl"))
    compile(project(":sentry-appender"))
    compile("io.dropwizard:dropwizard-core:${versions["DROPWIZARD"]}")
    compile("io.dropwizard:dropwizard-jdbi3:${versions["DROPWIZARD"]}")
    compile("io.dropwizard:dropwizard-migrations:${versions["DROPWIZARD"]}")
    compile("io.dropwizard:dropwizard-auth:${versions["DROPWIZARD"]}")
    compile("io.sentry:sentry-logback:${versions["SENTRY"]}")
    compile("org.jdbi:jdbi3-kotlin-sqlobject:${versions["JDBI"]}")
    compile("com.fasterxml.jackson.module:jackson-module-kotlin:${versions["JACKSON"]}")
    compile("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:${versions["JACKSON"]}")
    compile("com.h2database:h2:${versions["H2"]}")
    compile("com.google.dagger:dagger:${versions["DAGGER"]}")
    compile("com.tylerkindy:dropwizard-dagger:${versions["DROPWIZARD_DAGGER"]}")
    compile("com.google.api-client:google-api-client:${versions["GOOGLE_API"]}") {
        exclude(group = "com.google.guava", module = "guava-jdk5")
    }
    kapt("com.google.dagger:dagger-compiler:${versions["DAGGER"]}")

    testCompile("org.assertj:assertj-core:${versions["ASSERTJ"]}")
    testCompile("io.dropwizard:dropwizard-testing:${versions["DROPWIZARD"]}")
    testCompile("org.glassfish.jersey.test-framework.providers:jersey-test-framework-provider-grizzly2:${versions["JERSEY"]}") {
        exclude(group = "junit", module = "junit")
        exclude(group = "javax.servlet", module = "javax.servlet-api")
    }
    testCompile("com.google.dagger:dagger:${versions["DAGGER"]}")
    testCompile("org.mockito:mockito-core:${versions["MOCKITO"]}")
    kaptTest("com.google.dagger:dagger-compiler:${versions["DAGGER"]}")
}
