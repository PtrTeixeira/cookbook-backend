load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "resources",
    srcs = [
        "RecipesResource.kt",
    ],
    visibility = ["//visibility:public"],
    deps = [
        "//cookbook/models",
        "//cookbook/server/src/main/kotlin/config",
        "//cookbook/server/src/main/kotlin/data",
        "@maven//:com_fasterxml_jackson_core_jackson_annotations",
        "@maven//:com_fasterxml_jackson_core_jackson_core",
        "@maven//:com_fasterxml_jackson_core_jackson_databind",
        "@maven//:com_fasterxml_jackson_datatype_jackson_datatype_jdk8",
        "@maven//:com_fasterxml_jackson_module_jackson_module_kotlin",
        "@maven//:com_google_inject_guice",
        "@maven//:io_dropwizard_dropwizard_auth",
        "@maven//:io_dropwizard_dropwizard_core",
        "@maven//:io_dropwizard_dropwizard_db",
        "@maven//:io_dropwizard_dropwizard_jdbi3",
        "@maven//:io_dropwizard_dropwizard_lifecycle",
        "@maven//:io_dropwizard_dropwizard_migrations",
        "@maven//:io_dropwizard_metrics_metrics_core",
        "@maven//:javax_ws_rs_javax_ws_rs_api",
        "@maven//:org_jdbi_jdbi3_core",
        "@maven//:org_jdbi_jdbi3_sqlobject",
        "@maven//:org_slf4j_slf4j_api",
    ],
)
