load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "server_lib",
    srcs = [
        "ApplicationComponent.kt",
        "CookbookApplication.kt",
    ],
    visibility = ["//visibility:public"],
    deps = [
        "//cookbook/models",
        "//cookbook/server/src/main/kotlin/auth",
        "//cookbook/server/src/main/kotlin/base",
        "//cookbook/server/src/main/kotlin/config",
        "//cookbook/server/src/main/kotlin/data",
        "//cookbook/server/src/main/kotlin/resources",
        "@dagger//:dagger_with_compiler",
        "//third-party/java:com_tylerkindy_dropwizard_dagger",
        "//third-party/java:com_fasterxml_jackson_module_jackson_module_kotlin",
        "//third-party/java:io_dropwizard_dropwizard_auth",
        "//third-party/java:io_dropwizard_dropwizard_core",
        "//third-party/java:io_dropwizard_dropwizard_db",
        "//third-party/java:io_dropwizard_dropwizard_jdbi3",
        "//third-party/java:io_dropwizard_dropwizard_migrations",
    ],
)
