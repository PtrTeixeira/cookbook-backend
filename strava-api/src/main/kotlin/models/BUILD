load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "models",
    srcs = [
        ":Athlete.kt",
        ":AthleteActivitiesResponse.kt",
        ":TokenResponse.kt",
    ],
    visibility = ["//visibility:public"],
    deps = [
        "//third-party/java:com_fasterxml_jackson_core_jackson_annotations",
        "//third-party/java:com_fasterxml_jackson_core_jackson_databind",
        "//third-party/java:com_fasterxml_jackson_datatype_jackson_datatype_jdk8",
        "//third-party/java:com_fasterxml_jackson_module_jackson_module_kotlin",
    ],
)
