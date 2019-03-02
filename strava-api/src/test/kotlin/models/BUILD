load("//third-party/java:junit.bzl", "kt_junit5_test")

kt_junit5_test(
    name = "token_response_test",
    size = "small",
    srcs = ["TokenResponseTest.kt"],
    test_class = "models.TokenResponseTest",
    deps = [
        "//strava-api:models",
        "//third-party/java:com_fasterxml_jackson_core_jackson_annotations",
        "//third-party/java:com_fasterxml_jackson_core_jackson_core",
        "//third-party/java:com_fasterxml_jackson_core_jackson_databind",
        "//third-party/java:com_fasterxml_jackson_datatype_jackson_datatype_jdk8",
        "//third-party/java:com_fasterxml_jackson_module_jackson_module_kotlin",
        "//third-party/java:org_assertj_assertj_core",
    ],
)
