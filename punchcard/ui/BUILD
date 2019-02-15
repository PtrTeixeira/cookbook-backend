## TODO: Either get new plugins for Rollup working or 
## write a webpack.bzl file to use webpack instead.
## Rollup is inherently supported by Bazel, which means that 
## changes there will involve hacking through a bunch of 
## garbage.

load("@build_bazel_rules_nodejs//:defs.bzl", "http_server", "rollup_bundle")
load("@npm_bazel_typescript//:defs.bzl", "ts_library", "ts_devserver")

ts_library(
    name = "ui",
    srcs = [
        "src/app.ts",
    ],
    deps = [
        "@npm//vue",
    ]
)

rollup_bundle(
    name = "bundle",
    entry_point = "punchcard/ui/src/app",
    deps = [":ui"]
)

http_server(
    name = "server",
    data = [
        ":index.html",
        ":bundle",
    ],
    templated_args = [
        "-p", "3000",
        "punchcard/ui/",
    ],
)

ts_devserver(
    name = "dev",
    port = 3000,
    serving_path = "/bundle.min.js",
    static_files = [":index.html"],
    deps = [":ui"],
)
