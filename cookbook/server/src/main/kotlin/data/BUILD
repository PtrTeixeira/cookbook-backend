load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "data",
    srcs = [
        "DataModule.kt",
        "MigrationsBundle.kt",
        "RecipeData.kt",
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
        "//third-party/java:io_dropwizard_dropwizard_core",
        "//third-party/java:io_dropwizard_dropwizard_db",
        "//third-party/java:io_dropwizard_dropwizard_jdbi3",
        "//third-party/java:io_dropwizard_dropwizard_lifecycle",
        "//third-party/java:io_dropwizard_dropwizard_migrations",
        "//third-party/java:io_dropwizard_metrics_metrics_core",
        "//third-party/java:org_jdbi_jdbi3_core",
        "//third-party/java:org_jdbi_jdbi3_sqlobject",
    ],
)
