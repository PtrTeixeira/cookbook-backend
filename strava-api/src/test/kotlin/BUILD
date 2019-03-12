load("//third-party/java:junit.bzl", "kt_junit5_test")

kt_junit5_test(
    name = "strava_service_test",
    size = "small",
    srcs = ["StravaServiceTest.kt"],
    test_class = "StravaServiceTest",
    deps = [
        "//strava-api:models",
        "//strava-api:client",
        "//third-party/java:com_fasterxml_jackson_core_jackson_annotations",
        "//third-party/java:com_fasterxml_jackson_core_jackson_core",
        "//third-party/java:com_fasterxml_jackson_core_jackson_databind",
        "//third-party/java:com_fasterxml_jackson_datatype_jackson_datatype_jdk8",
        "//third-party/java:com_fasterxml_jackson_module_jackson_module_kotlin",
        "//third-party/java:com_squareup_retrofit2_retrofit",
        "//third-party/java:io_projectreactor_reactor_core",
        "//third-party/java:io_projectreactor_reactor_test",
        "//third-party/java:org_assertj_assertj_core",
        "//third-party/java:org_mockito_mockito_core",
        "//third-party/java:org_reactivestreams_reactive_streams",
    ],
)
