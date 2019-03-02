load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "client",
    srcs = [
        ":IStravaService.kt",
        ":StravaApi.kt",
        ":StravaService.kt",
    ],
    visibility = ["//visibility:public"],
    deps = [
        "//strava-api/src/main/kotlin/models",
        "//third-party/java:com_fasterxml_jackson_core_jackson_annotations",
        "//third-party/java:com_fasterxml_jackson_core_jackson_databind",
        "//third-party/java:com_fasterxml_jackson_datatype_jackson_datatype_jdk8",
        "//third-party/java:com_fasterxml_jackson_module_jackson_module_kotlin",
        "//third-party/java:com_squareup_retrofit2_retrofit",
        "//third-party/java:io_projectreactor_reactor_core",
        "//third-party/java:org_reactivestreams_reactive_streams",
    ],
)
