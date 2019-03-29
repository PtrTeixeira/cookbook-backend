load("//third-party/java:junit.bzl", "kt_junit5_test")

kt_junit5_test(
    name = "recipe_egg_test",
    size = "small",
    srcs = ["kotlin/RecipeEggTest.kt"],
    resources = [
        "resources/recipe-egg.json",
        "resources/recipe-egg-absent-field.json",
    ],
    test_class = "com.github.ptrteixeira.cookbook.model.RecipeEggTest",
    deps = [
        "//cookbook/models",
        "@maven//:com_fasterxml_jackson_core_jackson_core",
        "@maven//:com_fasterxml_jackson_core_jackson_databind",
        "@maven//:com_fasterxml_jackson_datatype_jackson_datatype_jdk8",
        "@maven//:com_fasterxml_jackson_module_jackson_module_kotlin",
        "@maven//:io_dropwizard_dropwizard_testing",
        "@maven//:org_assertj_assertj_core",
    ],
)

kt_junit5_test(
    name = "recipe_test",
    size = "small",
    srcs = ["kotlin/RecipeTest.kt"],
    resources = [
        "resources/recipe.json",
    ],
    test_class = "com.github.ptrteixeira.cookbook.model.RecipeTest",
    deps = [
        "//cookbook/models",
        "@maven//:com_fasterxml_jackson_core_jackson_core",
        "@maven//:com_fasterxml_jackson_core_jackson_databind",
        "@maven//:com_fasterxml_jackson_datatype_jackson_datatype_jdk8",
        "@maven//:com_fasterxml_jackson_module_jackson_module_kotlin",
        "@maven//:io_dropwizard_dropwizard_testing",
        "@maven//:org_assertj_assertj_core",
    ],
)
