import org.jetbrains.kotlin.gradle.dsl.KotlinProjectExtension
import org.jetbrains.kotlin.gradle.dsl.Coroutines
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    group = "com.github.ptrteixeira.cookbook"
    version = "0.1.0"

    repositories {
        gradleScriptKotlin()
        mavenCentral()
        jcenter()
    }
    dependencies {
        classpath(kotlinModule("gradle-plugin", "1.1.0"))
    }
}

plugins {
    application
}

apply {
    plugin("kotlin")
}

configure<ApplicationPluginConvention> {
    mainClassName = "com.github.ptrteixeira.cookbook.MainKt"
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

val versions = mapOf(
    "kotlin" to "1.1.0",
    "vertx" to "3.3.3",
    "assertj" to "3.6.1"
)

dependencies {
    compile(kotlinModule("stdlib-jre8", versions["kotlin"]))
    compile("io.vertx:vertx-core:${versions["vertx"]}")
    compile("io.vertx:vertx-web:${versions["vertx"]}")

    testCompile("org.assertj:assertj-core:${versions["assertj"]}")
}
