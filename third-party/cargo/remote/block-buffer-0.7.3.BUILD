"""
cargo-raze crate build file.

DO NOT EDIT! Replaced on runs of cargo-raze
"""
package(default_visibility = [
  # Public for visibility by "@raze__crate__version//" targets.
  #
  # Prefer access through "//third-party/cargo", which limits external
  # visibility to explicit Cargo.toml dependencies.
  "//visibility:public",
])

licenses([
  "restricted", # "MIT OR Apache-2.0"
])

load(
    "@io_bazel_rules_rust//rust:rust.bzl",
    "rust_library",
    "rust_binary",
    "rust_test",
)



rust_library(
    name = "block_buffer",
    crate_root = "src/lib.rs",
    crate_type = "lib",
    edition = "2015",
    srcs = glob(["**/*.rs"]),
    deps = [
        "@raze__block_padding__0_1_5//:block_padding",
        "@raze__byte_tools__0_3_1//:byte_tools",
        "@raze__byteorder__1_3_2//:byteorder",
        "@raze__generic_array__0_12_3//:generic_array",
    ],
    rustc_flags = [
        "--cap-lints=allow",
    ],
    version = "0.7.3",
    crate_features = [
    ],
)

