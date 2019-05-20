load("@io_bazel_rules_rust//rust:rust.bzl", "rust_binary", "rust_library", "rust_test")

rust_library(
    name = "lib",
    srcs = [
        "src/cli.rs",
        "src/lib.rs",
    ],
    deps = [
        "//third-party/cargo:clap",
        "//third-party/cargo:regex",
    ],
)

rust_binary(
    name = "mvb",
    srcs = [
        "src/main.rs",
    ],
    deps = [
        ":lib",
        "//third-party/cargo:regex",
        "//third-party/cargo:walkdir",
    ],
)

rust_test(
    name = "mvb_test",
    crate = ":lib",
)
