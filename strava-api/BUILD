load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library", "kt_jvm_test")

kt_jvm_library(
    name = "strava-api",
    srcs = glob(["src/main/**/*.kt"]),
    deps = [
        "//third-party/java:com_squareup_retrofit2_retrofit",
        "//third-party/java:org_reactivestreams_reactive_streams",
        "//third-party/java:io_projectreactor_reactor_core",
        "//third-party/java:com_fasterxml_jackson_core_jackson_databind",
        "//third-party/java:com_fasterxml_jackson_datatype_jackson_datatype_jdk8",
        "//third-party/java:com_fasterxml_jackson_core_jackson_annotations",
        "//third-party/java:com_fasterxml_jackson_module_jackson_module_kotlin",
    ],
)

load("//third-party/java:junit.bzl", "kt_junit5_test")

kt_junit5_test(
    name = "strava_service_test",
    size = "small",
    srcs = ["src/test/kotlin/StravaServiceTest.kt"],
    test_class = "StravaServiceTest",
    deps = [
        ":strava-api",
        "//third-party/java:com_squareup_retrofit2_retrofit",
        "//third-party/java:org_reactivestreams_reactive_streams",
        "//third-party/java:io_projectreactor_reactor_core",
        "//third-party/java:com_fasterxml_jackson_core_jackson_core",
        "//third-party/java:com_fasterxml_jackson_core_jackson_databind",
        "//third-party/java:com_fasterxml_jackson_datatype_jackson_datatype_jdk8",
        "//third-party/java:com_fasterxml_jackson_core_jackson_annotations",
        "//third-party/java:com_fasterxml_jackson_module_jackson_module_kotlin",
        "//third-party/java:org_assertj_assertj_core",
        "//third-party/java:org_mockito_mockito_core",
        "//third-party/java:io_projectreactor_reactor_test",
    ]
)

kt_junit5_test(
    name = "token_response_test",
    size = "small",
    srcs = ["src/test/kotlin/models/TokenResponseTest.kt"],
    test_class = "models.TokenResponseTest",
    deps = [
        ":strava-api",
        "//third-party/java:com_fasterxml_jackson_core_jackson_core",
        "//third-party/java:com_fasterxml_jackson_core_jackson_databind",
        "//third-party/java:com_fasterxml_jackson_datatype_jackson_datatype_jdk8",
        "//third-party/java:com_fasterxml_jackson_core_jackson_annotations",
        "//third-party/java:com_fasterxml_jackson_module_jackson_module_kotlin",
        "//third-party/java:org_assertj_assertj_core",
    ]
)
