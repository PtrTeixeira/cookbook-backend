load("//third-party/java:junit.bzl", "kt_junit5_test")

kt_junit5_test(
    name = "strava_service_test",
    size = "small",
    srcs = ["StravaServiceTest.kt"],
    test_class = "StravaServiceTest",
    deps = [
        "//strava-api:client",
        "//strava-api:models",
        "@maven//:com_fasterxml_jackson_core_jackson_annotations",
        "@maven//:com_fasterxml_jackson_core_jackson_core",
        "@maven//:com_fasterxml_jackson_core_jackson_databind",
        "@maven//:com_fasterxml_jackson_datatype_jackson_datatype_jdk8",
        "@maven//:com_fasterxml_jackson_module_jackson_module_kotlin",
        "@maven//:com_squareup_retrofit2_retrofit",
        "@maven//:io_projectreactor_reactor_core",
        "@maven//:io_projectreactor_reactor_test",
        "@maven//:org_assertj_assertj_core",
        "@maven//:org_mockito_mockito_core",
        "@maven//:org_reactivestreams_reactive_streams",
    ],
)
