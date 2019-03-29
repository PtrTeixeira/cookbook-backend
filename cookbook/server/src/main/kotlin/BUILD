load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "server_lib",
    srcs = [
        "ApplicationModule.kt",
        "CookbookApplication.kt",
    ],
    resources = [
        "//cookbook/server/src/main/resources:banner.txt",
        "//cookbook/server/src/main/resources:sentry.properties",
    ],
    visibility = ["//visibility:public"],
    runtime_deps = [
        "//sentry-appender",
    ],
    deps = [
        "//cookbook/models",
        "//cookbook/server/src/main/kotlin/auth",
        "//cookbook/server/src/main/kotlin/config",
        "//cookbook/server/src/main/kotlin/data",
        "//cookbook/server/src/main/kotlin/resources",
        "//kotlin-dropwizard-dsl:kotlin_dropwizard_dsl",
        "@maven//:com_fasterxml_jackson_core_jackson_core",
        "@maven//:com_fasterxml_jackson_core_jackson_databind",
        "@maven//:com_fasterxml_jackson_module_jackson_module_kotlin",
        "@maven//:com_google_inject_guice",
        "@maven//:com_h2database_h2",
        "@maven//:io_dropwizard_dropwizard_auth",
        "@maven//:io_dropwizard_dropwizard_core",
        "@maven//:io_dropwizard_dropwizard_db",
        "@maven//:io_dropwizard_dropwizard_jdbi3",
        "@maven//:io_dropwizard_dropwizard_lifecycle",
        "@maven//:io_dropwizard_dropwizard_migrations",
        "@maven//:javax_ws_rs_javax_ws_rs_api",
        "@maven//:org_jdbi_jdbi3_core",
        "@maven//:org_jdbi_jdbi3_kotlin",
        "@maven//:org_jdbi_jdbi3_kotlin_sqlobject",
        "@maven//:org_jdbi_jdbi3_sqlobject",
    ],
)

java_binary(
    name = "server",
    main_class = "com.github.ptrteixeira.cookbook.CookbookApplication",
    visibility = ["//visibility:public"],
    runtime_deps = [":server_lib"],
)
