load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "auth",
    srcs = [
        "AuthModule.kt",
        "TrivialAuth.kt",
    ],
    visibility = ["//visibility:public"],
    deps = [
        "//cookbook/models",
        "//cookbook/server/src/main/kotlin/config",
        "//cookbook/server/src/main/kotlin/base",
        "@dagger//:dagger_with_compiler",
        "//third-party/java:com_fasterxml_jackson_core_jackson_core",
        "//third-party/java:com_fasterxml_jackson_core_jackson_annotations",
        "//third-party/java:com_fasterxml_jackson_core_jackson_databind",
        "//third-party/java:com_fasterxml_jackson_datatype_jackson_datatype_jdk8",
        "//third-party/java:com_fasterxml_jackson_module_jackson_module_kotlin",
        "//third-party/java:io_dropwizard_dropwizard_auth",
        "//third-party/java:io_dropwizard_dropwizard_core",
        "//third-party/java:io_dropwizard_dropwizard_lifecycle",
        "//third-party/java:io_dropwizard_metrics_metrics_core",
    ],
)
