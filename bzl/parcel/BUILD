load("@build_bazel_rules_nodejs//:defs.bzl", "nodejs_binary")

nodejs_binary(
    name = "parcel",
    entry_point= "parcel-bundler/bin/cli",
    install_source_map_support = False,
    node_modules = "@npm//:node_modules",
    visibility = ["//visibility:public"],
)
