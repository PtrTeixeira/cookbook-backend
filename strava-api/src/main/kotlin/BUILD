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
        "@maven//:com_fasterxml_jackson_core_jackson_annotations",
        "@maven//:com_fasterxml_jackson_core_jackson_databind",
        "@maven//:com_fasterxml_jackson_datatype_jackson_datatype_jdk8",
        "@maven//:com_fasterxml_jackson_module_jackson_module_kotlin",
        "@maven//:com_squareup_retrofit2_retrofit",
        "@maven//:io_projectreactor_reactor_core",
        "@maven//:org_reactivestreams_reactive_streams",
    ],
)
