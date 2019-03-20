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



rust_library(
    name = "pest_generator",
    crate_root = "src/lib.rs",
    crate_type = "lib",
    edition = "2015",
    srcs = glob(["**/*.rs"]),
    deps = [
        "@raze__pest__2_1_0//:pest",
        "@raze__pest_meta__2_1_0//:pest_meta",
        "@raze__proc_macro2__0_4_27//:proc_macro2",
        "@raze__quote__0_6_11//:quote",
        "@raze__syn__0_15_29//:syn",
    ],
    rustc_flags = [
        "--cap-lints=allow",
    ],
    version = "2.1.0",
    crate_features = [
    ],
)

