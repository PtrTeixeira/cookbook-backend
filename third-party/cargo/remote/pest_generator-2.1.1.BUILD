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
        "@raze__pest__2_1_2//:pest",
        "@raze__pest_meta__2_1_2//:pest_meta",
        "@raze__proc_macro2__1_0_6//:proc_macro2",
        "@raze__quote__1_0_2//:quote",
        "@raze__syn__1_0_8//:syn",
    ],
    rustc_flags = [
        "--cap-lints=allow",
    ],
    version = "2.1.1",
    crate_features = [
    ],
)

