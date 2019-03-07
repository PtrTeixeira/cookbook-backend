load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "server_lib",
    srcs = [
        "CookbookApplication.kt",
    ],
    resources = [
        "//cookbook/server/src/main/resources:banner.txt",
        "//cookbook/server/src/main/resources:sentry.properties",
    ],
    visibility = ["//visibility:public"],
    deps = [
        "//cookbook/models",
        "//cookbook/server/src/main/kotlin/auth",
        "//cookbook/server/src/main/kotlin/config",
        "//cookbook/server/src/main/kotlin/data",
        "//cookbook/server/src/main/kotlin/resources",
        "//kotlin-dropwizard-dsl:kotlin_dropwizard_dsl",
        "//third-party/java:com_fasterxml_jackson_core_jackson_core",
        "//third-party/java:com_fasterxml_jackson_core_jackson_databind",
        "//third-party/java:com_fasterxml_jackson_module_jackson_module_kotlin",
        "//third-party/java:com_h2database_h2",
        "//third-party/java:io_dropwizard_dropwizard_auth",
        "//third-party/java:io_dropwizard_dropwizard_core",
        "//third-party/java:io_dropwizard_dropwizard_db",
        "//third-party/java:io_dropwizard_dropwizard_jdbi3",
        "//third-party/java:io_dropwizard_dropwizard_lifecycle",
        "//third-party/java:io_dropwizard_dropwizard_migrations",
        "//third-party/java:javax_ws_rs_javax_ws_rs_api",
        "//third-party/java:org_jdbi_jdbi3_core",
        "//third-party/java:org_jdbi_jdbi3_kotlin",
        "//third-party/java:org_jdbi_jdbi3_kotlin_sqlobject",
        "//third-party/java:org_jdbi_jdbi3_sqlobject",
    ],
)

java_binary(
    name = "server",
    main_class = "com.github.ptrteixeira.cookbook.CookbookApplication",
    visibility = ["//visibility:public"],
    runtime_deps = [":server_lib"],
)
