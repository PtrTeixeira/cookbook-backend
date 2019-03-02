load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

alias(
    name = "client",
    actual = "//strava-api/src/main/kotlin:client",
    visibility = ["//visibility:public"]
)

alias(
    name = "models",
    actual = "//strava-api/src/main/kotlin/models",
    visibility = ["//visibility:public"])

test_suite(
    name = "checkin_tests",
    tests = [
        "//strava-api/src/test/kotlin:strava_service_test",
        "//strava-api/src/test/kotlin/models:token_response_test",
    ],
)
