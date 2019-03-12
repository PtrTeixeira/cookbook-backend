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
  "notice", # "MIT,Apache-2.0"
])

load(
    "@io_bazel_rules_rust//rust:rust.bzl",
    "rust_library",
    "rust_binary",
    "rust_test",
)


# Unsupported target "calculator" with type "test" omitted
# Unsupported target "json" with type "test" omitted
# Unsupported target "parens" with type "example" omitted

rust_library(
    name = "pest",
    crate_root = "src/lib.rs",
    crate_type = "lib",
    edition = "2015",
    srcs = glob(["**/*.rs"]),
    deps = [
        "@raze__ucd_trie__0_1_1//:ucd_trie",
    ],
    rustc_flags = [
        "--cap-lints=allow",
    ],
    version = "2.1.0",
    crate_features = [
    ],
)

