import org.gradle.api.plugins.ApplicationPluginConvention
import org.gradle.script.lang.kotlin.*
import org.jetbrains.kotlin.gradle.dsl.Coroutines
import org.jetbrains.kotlin.gradle.dsl.KotlinProjectExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    group = "com.github.ptrteixeira.cookbook"
    version = "0.1.0"

    repositories {
        gradleScriptKotlin()
        mavenCentral()
    }
    dependencies {
        classpath(kotlinModule("gradle-plugin", "1.1.0"))
        classpath("org.junit.platform:junit-platform-gradle-plugin:1.0.0-M3")
    }
}

plugins {
    application
}

apply {
    plugin("kotlin")
    plugin("org.junit.platform.gradle.plugin")
}

configure<ApplicationPluginConvention> {
    mainClassName = "com.github.ptrteixeira.cookbook.MainKt"
    applicationDefaultJvmArgs = listOf(
        "-Dvertx.logger-delegate-factory-class-name=io.vertx.core.logging.Log4j2LogDelegateFactory",
        "-DLog4jContextSelector=org.apache.logging.log4j.core.async.AsyncLoggerContextSelector"
    )
}

configure<KotlinProjectExtension> {
    experimental.coroutines = Coroutines.ENABLE
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        javaParameters = true
        jvmTarget = "1.8"
    }
}


repositories {
    gradleScriptKotlin()
    mavenCentral()
}

enum class Dependencies(val version: String) {
    KOTLIN("1.1.0"),
    VERTX("3.4.0"),
    ASSERTJ("3.6.1"),
    JUNIT("5.0.0-M3"),
    JACKSON("2.8.7"),
    LOG4J("2.8.1");

    override fun toString() = version
}

dependencies {
    compile(kotlinModule("stdlib-jre8", Dependencies.KOTLIN.toString()))
    compile("io.vertx:vertx-core:${Dependencies.VERTX}")
    compile("io.vertx:vertx-web:${Dependencies.VERTX}")
    compile("org.apache.logging.log4j:log4j-api:${Dependencies.LOG4J}")
    compile("org.apache.logging.log4j:log4j-core:${Dependencies.LOG4J}")
    compile("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:${Dependencies.JACKSON}")

    testCompile("org.junit.jupiter:junit-jupiter-api:${Dependencies.JUNIT}")
    testRuntime("org.junit.jupiter:junit-jupiter-engine:${Dependencies.JUNIT}")
    testCompile("org.assertj:assertj-core:${Dependencies.ASSERTJ}")
}
