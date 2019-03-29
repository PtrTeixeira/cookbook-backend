load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "kotlin_dropwizard_dsl",
    srcs = glob(["src/main/**/*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "@maven//:com_fasterxml_jackson_core_jackson_core",
        "@maven//:com_fasterxml_jackson_core_jackson_databind",
        "@maven//:io_dropwizard_dropwizard_auth",
        "@maven//:io_dropwizard_dropwizard_configuration",
        "@maven//:io_dropwizard_dropwizard_core",
        "@maven//:io_dropwizard_dropwizard_jersey",
        "@maven//:io_dropwizard_dropwizard_metrics",
        "@maven//:io_dropwizard_metrics_metrics_healthchecks",
        "@maven//:javax_ws_rs_javax_ws_rs_api",
        "@maven//:org_apache_commons_commons_text",
        "@maven//:org_glassfish_hk2_hk2_api",
        "@maven//:org_glassfish_jersey_core_jersey_server",
    ],
)
