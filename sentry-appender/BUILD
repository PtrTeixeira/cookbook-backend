load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")
load("//third-party/java:junit.bzl", "kt_junit5_test")

kt_jvm_library(
    name = "sentry-appender",
    srcs = [
        "src/main/kotlin/com/github/ptrteixeira/cookbook/sentry/SentryAppenderFactory.kt",
    ],
    resources = [
        "//sentry-appender/src/main/resources/META-INF/services:io.dropwizard.logging.AppenderFactory",
    ],
    visibility = ["//visibility:public"],
    deps = [
        "//third-party/java:ch_qos_logback_logback_classic",
        "//third-party/java:ch_qos_logback_logback_core",
        "//third-party/java:com_fasterxml_jackson_core_jackson_annotations",
        "//third-party/java:com_fasterxml_jackson_core_jackson_core",
        "//third-party/java:com_fasterxml_jackson_core_jackson_databind",
        "//third-party/java:com_fasterxml_jackson_datatype_jackson_datatype_jdk8",
        "//third-party/java:com_fasterxml_jackson_module_jackson_module_kotlin",
        "//third-party/java:com_google_guava_guava",
        "//third-party/java:io_dropwizard_dropwizard_configuration",
        "//third-party/java:io_dropwizard_dropwizard_core",
        "//third-party/java:io_dropwizard_dropwizard_jackson",
        "//third-party/java:io_dropwizard_dropwizard_logging",
        "//third-party/java:io_sentry_sentry_logback",
        "//third-party/java:org_slf4j_slf4j_api",
    ],
)

kt_junit5_test(
    name = "sentry_appender_test",
    size = "small",
    srcs = [
        "src/test/kotlin/SentryAppenderFactoryTest.kt",
    ],
    test_class = "com.github.ptrteixeira.cookbook.sentry.SentryAppenderFactory",
    deps = [
        ":sentry-appender",
        "//cookbook/models",
        "//cookbook/server/src/main/kotlin/data",
        "//third-party/java:com_fasterxml_jackson_core_jackson_annotations",
        "//third-party/java:com_fasterxml_jackson_core_jackson_core",
        "//third-party/java:com_fasterxml_jackson_core_jackson_databind",
        "//third-party/java:com_fasterxml_jackson_datatype_jackson_datatype_jdk8",
        "//third-party/java:com_google_guava_guava",
        "//third-party/java:io_dropwizard_dropwizard_jackson",
        "//third-party/java:io_dropwizard_dropwizard_logging",
        "//third-party/java:org_assertj_assertj_core",
        "//third-party/java:org_slf4j_slf4j_api",
    ],
)
