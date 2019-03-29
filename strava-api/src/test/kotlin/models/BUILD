load("//third-party/java:junit.bzl", "kt_junit5_test")

kt_junit5_test(
    name = "token_response_test",
    size = "small",
    srcs = ["TokenResponseTest.kt"],
    test_class = "models.TokenResponseTest",
    deps = [
        "//strava-api:models",
        "@maven//:com_fasterxml_jackson_core_jackson_annotations",
        "@maven//:com_fasterxml_jackson_core_jackson_core",
        "@maven//:com_fasterxml_jackson_core_jackson_databind",
        "@maven//:com_fasterxml_jackson_datatype_jackson_datatype_jdk8",
        "@maven//:com_fasterxml_jackson_module_jackson_module_kotlin",
        "@maven//:org_assertj_assertj_core",
    ],
)
