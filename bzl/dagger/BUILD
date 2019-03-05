package(default_visibility = ["//visibility:public"])

java_plugin(
    name = "dagger_compiler_plugin",
    generates_api = True,
    processor_class = "dagger.internal.codegen.ComponentProcessor",
    deps = [
        "@dagger//:dagger_with_compiler",
    ],
)

java_library(
    name = "dagger_with_annotation_processor",
    exported_plugins = [":dagger_compiler_plugin"],
    exports = [
        "@dagger//:dagger_with_compiler",
    ],
)
