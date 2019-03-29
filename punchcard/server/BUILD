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
        "//third-party/java:com_fasterxml_jackson_core_jackson_core",
        "//third-party/java:com_fasterxml_jackson_core_jackson_databind",
        "//third-party/java:com_fasterxml_jackson_module_jackson_module_kotlin",
        "//third-party/java:com_google_guava_guava",
        "//third-party/java:com_google_inject_guice",
        "//third-party/java:com_jakewharton_retrofit_retrofit2_reactor_adapter",
        "//third-party/java:com_squareup_retrofit2_converter_jackson",
        "//third-party/java:com_squareup_retrofit2_retrofit",
        "//third-party/java:io_dropwizard_dropwizard_auth",
        "//third-party/java:io_dropwizard_dropwizard_core",
        "//third-party/java:io_dropwizard_metrics_metrics_core",
        "//third-party/java:io_dropwizard_metrics_metrics_json",
        "//third-party/java:io_projectreactor_reactor_core",
        "//third-party/java:javax_ws_rs_javax_ws_rs_api",
        "//third-party/java:org_reactivestreams_reactive_streams",
        "//third-party/java:org_slf4j_slf4j_api",
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
        "//third-party/java:com_fasterxml_jackson_core_jackson_annotations",
        "//third-party/java:com_fasterxml_jackson_core_jackson_core",
        "//third-party/java:com_fasterxml_jackson_core_jackson_databind",
        "//third-party/java:com_fasterxml_jackson_datatype_jackson_datatype_jdk8",
        "//third-party/java:com_fasterxml_jackson_module_jackson_module_kotlin",
        "//third-party/java:com_squareup_retrofit2_retrofit",
        "//third-party/java:io_dropwizard_metrics_metrics_core",
        "//third-party/java:io_projectreactor_reactor_core",
        "//third-party/java:io_projectreactor_reactor_test",
        "//third-party/java:javax_ws_rs_javax_ws_rs_api",
        "//third-party/java:org_assertj_assertj_core",
        "//third-party/java:org_mockito_mockito_core",
        "//third-party/java:org_reactivestreams_reactive_streams",
    ],
)

java_binary(
    name = "server",
    main_class = "com.github.ptrteixeira.punchcard.StravaPunchcardApplication",
    visibility = ["//visibility:public"],
    runtime_deps = [":server_lib"],
)
