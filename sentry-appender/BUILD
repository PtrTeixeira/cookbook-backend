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
        "@maven//:ch_qos_logback_logback_classic",
        "@maven//:ch_qos_logback_logback_core",
        "@maven//:com_fasterxml_jackson_core_jackson_annotations",
        "@maven//:com_fasterxml_jackson_core_jackson_core",
        "@maven//:com_fasterxml_jackson_core_jackson_databind",
        "@maven//:com_fasterxml_jackson_datatype_jackson_datatype_jdk8",
        "@maven//:com_fasterxml_jackson_module_jackson_module_kotlin",
        "@maven//:com_google_guava_guava",
        "@maven//:io_dropwizard_dropwizard_configuration",
        "@maven//:io_dropwizard_dropwizard_core",
        "@maven//:io_dropwizard_dropwizard_jackson",
        "@maven//:io_dropwizard_dropwizard_logging",
        "@maven//:io_sentry_sentry_logback",
        "@maven//:org_slf4j_slf4j_api",
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
        "@maven//:com_fasterxml_jackson_core_jackson_annotations",
        "@maven//:com_fasterxml_jackson_core_jackson_core",
        "@maven//:com_fasterxml_jackson_core_jackson_databind",
        "@maven//:com_fasterxml_jackson_datatype_jackson_datatype_jdk8",
        "@maven//:com_google_guava_guava",
        "@maven//:io_dropwizard_dropwizard_jackson",
        "@maven//:io_dropwizard_dropwizard_logging",
        "@maven//:org_assertj_assertj_core",
        "@maven//:org_slf4j_slf4j_api",
    ],
)
