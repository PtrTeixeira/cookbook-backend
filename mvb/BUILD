package(default_visibility = ["//visibility:public"])

load("@io_bazel_rules_rust//rust:rust.bzl", "rust_binary", "rust_library", "rust_test")

rust_binary(
    name = "mvb",
    srcs = [
        "src/main.rs",
    ],
    deps = [
        "//third-party/cargo:clap",
        "//third-party/cargo:regex",
        "//third-party/cargo:walkdir",
    ],
)
