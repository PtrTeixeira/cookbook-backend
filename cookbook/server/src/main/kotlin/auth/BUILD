load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "auth",
    srcs = [
        "TrivialAuth.kt",
    ],
    visibility = ["//visibility:public"],
    deps = [
        "//cookbook/models",
        "//cookbook/server/src/main/kotlin/config",
        "@maven//:com_fasterxml_jackson_core_jackson_annotations",
        "@maven//:com_fasterxml_jackson_core_jackson_core",
        "@maven//:com_fasterxml_jackson_core_jackson_databind",
        "@maven//:com_fasterxml_jackson_datatype_jackson_datatype_jdk8",
        "@maven//:com_fasterxml_jackson_module_jackson_module_kotlin",
        "@maven//:io_dropwizard_dropwizard_auth",
        "@maven//:io_dropwizard_dropwizard_core",
        "@maven//:io_dropwizard_dropwizard_lifecycle",
        "@maven//:io_dropwizard_metrics_metrics_core",
    ],
)
