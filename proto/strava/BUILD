load("@rules_proto//proto:defs.bzl", "proto_library")
load("@io_bazel_rules_go//go:def.bzl", "go_library")
load("@io_bazel_rules_go//proto:def.bzl", "go_proto_library")

proto_library(
    name = "strava_proto",
    srcs = ["strava-api.proto"],
    visibility = ["//visibility:public"],
)

go_proto_library(
    name = "strava_go_proto",
    importpath = "github.com/PtrTeixeira/cookbook/proto/strava",
    proto = ":strava_proto",
    visibility = ["//visibility:public"],
)

go_library(
    name = "go_default_library",
    embed = [":strava_go_proto"],
    importpath = "github.com/PtrTeixeira/cookbook/proto/strava",
    visibility = ["//visibility:public"],
)
