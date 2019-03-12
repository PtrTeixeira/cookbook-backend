load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "config",
    srcs = [
        "AuthConfiguration.kt",
        "AuthType.kt",
        "CookbookConfiguration.kt",
    ],
    visibility = ["//visibility:public"],
    deps = [
        "//third-party/java:io_dropwizard_dropwizard_core",
        "//third-party/java:io_dropwizard_dropwizard_db",
    ],
)
