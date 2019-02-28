load("@build_bazel_rules_nodejs//:defs.bzl", "http_server", "rollup_bundle")
load("@npm_bazel_typescript//:defs.bzl", "ts_library", "ts_devserver")
# load("//bzl/webpack:webpack.bzl", "webpack")
load("//bzl/parcel:parcel.bzl", "parcel")

ts_library(
    name = "ui",
    srcs = ["src/app.tsx"],
    deps = [
        "@npm//@types/react",
        "@npm//@types/react-dom",
        "@npm//react",
        "@npm//react-dom",
    ]
)

# rollup_bundle(
#     name = "bundle",
#     entry_point = "punchcard/ui/src/app",
#     deps = [
#         ":ui",
#         "@npm//@types/react",
#         "@npm//@types/react-dom",
#         "@npm//react",
#         "@npm//react-dom"
#     ]
# )

# webpack(
#     name = "wpack",
#     entry_point = "app.js",
#     config = "webpack.config.js",
#     srcs = [
#         ":ui"
#     ]
# )

parcel(
    name = "package",
    entry_point = "index.html",
    srcs = [
        "index.html",
        "src/app.tsx",
    ],
    deps = [
        "@npm//typescript",
        "@npm//typescript/bin:tsc",
        "@npm//typescript/bin:tsserver",
        "@npm//@types/react",
        "@npm//@types/react-dom",
        "@npm//react",
        "@npm//react-dom",
    ]
)

http_server(
    name = "server",
    data = [
        ":bundle.js",
        "index.html",
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
