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
        "@maven//:io_dropwizard_dropwizard_core",
        "@maven//:io_dropwizard_dropwizard_db",
    ],
)
