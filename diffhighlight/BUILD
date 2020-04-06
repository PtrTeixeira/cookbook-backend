load("@io_bazel_rules_rust//rust:rust.bzl", "rust_binary", "rust_library", "rust_test")

rust_binary(
    name = "diffhighlight",
    srcs = [
        "src/main.rs",
    ],
    deps = [
        "//third-party/cargo:regex",
    ],
)
