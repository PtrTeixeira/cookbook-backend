load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")
load("//third-party/java:junit.bzl", "kt_junit5_test")

kt_jvm_library(
    name = "server_lib",
    srcs = [
        "src/main/kotlin/com/ptrteixeira/punchcard/StravaPunchcardApplication.kt",
        "src/main/kotlin/com/ptrteixeira/punchcard/StravaPunchcardConfiguration.kt",
        "src/main/kotlin/com/ptrteixeira/punchcard/resources/AuthResource.kt",
        "src/main/kotlin/com/ptrteixeira/punchcard/resources/MetricsResource.kt",
        "src/main/kotlin/com/ptrteixeira/punchcard/resources/PunchcardResource.kt",
    ],
    resources = [
        "//punchcard/server/src/main/resources:banner.txt",
        "//punchcard/server/src/main/resources:sentry.properties",
    ],
    visibility = ["//visibility:public"],
    runtime_deps = [
        "//sentry-appender",
    ],
    deps = [
        "//kotlin-dropwizard-dsl:kotlin_dropwizard_dsl",
        "//strava-api:client",
        "//strava-api:models",
        "@maven//:com_fasterxml_jackson_core_jackson_core",
        "@maven//:com_fasterxml_jackson_core_jackson_databind",
        "@maven//:com_fasterxml_jackson_module_jackson_module_kotlin",
        "@maven//:com_google_guava_guava",
        "@maven//:com_google_inject_guice",
        "@maven//:com_jakewharton_retrofit_retrofit2_reactor_adapter",
        "@maven//:com_squareup_retrofit2_converter_jackson",
        "@maven//:com_squareup_retrofit2_retrofit",
        "@maven//:io_dropwizard_dropwizard_auth",
        "@maven//:io_dropwizard_dropwizard_core",
        "@maven//:io_dropwizard_metrics_metrics_core",
        "@maven//:io_dropwizard_metrics_metrics_json",
        "@maven//:io_projectreactor_reactor_core",
        "@maven//:javax_ws_rs_javax_ws_rs_api",
        "@maven//:org_reactivestreams_reactive_streams",
        "@maven//:org_slf4j_slf4j_api",
    ],
)

kt_junit5_test(
    name = "punchcard_resource_test",
    size = "small",
    srcs = [
        "src/test/kotlin/com/github/ptrteixeira/punchcard/resources/PunchcardResourceTest.kt",
    ],
    test_class = "PunchcardResourceTest",
    deps = [
        ":server_lib",
        "//strava-api:client",
        "//strava-api:models",
        "@maven//:com_fasterxml_jackson_core_jackson_annotations",
        "@maven//:com_fasterxml_jackson_core_jackson_core",
        "@maven//:com_fasterxml_jackson_core_jackson_databind",
        "@maven//:com_fasterxml_jackson_datatype_jackson_datatype_jdk8",
        "@maven//:com_fasterxml_jackson_module_jackson_module_kotlin",
        "@maven//:com_squareup_retrofit2_retrofit",
        "@maven//:io_dropwizard_metrics_metrics_core",
        "@maven//:io_projectreactor_reactor_core",
        "@maven//:io_projectreactor_reactor_test",
        "@maven//:javax_ws_rs_javax_ws_rs_api",
        "@maven//:org_assertj_assertj_core",
        "@maven//:org_mockito_mockito_core",
        "@maven//:org_reactivestreams_reactive_streams",
    ],
)

java_binary(
    name = "server",
    main_class = "com.github.ptrteixeira.punchcard.StravaPunchcardApplication",
    visibility = ["//visibility:public"],
    runtime_deps = [":server_lib"],
)
