load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "kotlin_dropwizard_dsl",
    srcs = glob(["src/main/**/*.kt"]),
    visibility = ["//visibility:public"],
    deps = [
        "//third-party/java:com_fasterxml_jackson_core_jackson_core",
        "//third-party/java:com_fasterxml_jackson_core_jackson_databind",
        "//third-party/java:io_dropwizard_dropwizard_auth",
        "//third-party/java:io_dropwizard_dropwizard_configuration",
        "//third-party/java:io_dropwizard_dropwizard_core",
        "//third-party/java:io_dropwizard_dropwizard_jersey",
        "//third-party/java:io_dropwizard_dropwizard_metrics",
        "//third-party/java:io_dropwizard_metrics_metrics_healthchecks",
        "//third-party/java:javax_ws_rs_javax_ws_rs_api",
        "//third-party/java:org_apache_commons_commons_text",
        "//third-party/java:org_glassfish_hk2_hk2_api",
        "//third-party/java:org_glassfish_jersey_core_jersey_server",
    ],
)
