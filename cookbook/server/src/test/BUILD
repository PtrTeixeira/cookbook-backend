load("//third-party/java:junit.bzl", "kt_junit5_test")

kt_junit5_test(
    name = "recipe_data_test",
    size = "small",
    srcs = [
        "kotlin/data/Helpers.kt",
        "kotlin/data/RecipeDataTest.kt",
    ],
    test_class = "com.github.ptrteixeira.cookbook.data.RecipeDataTest",
    deps = [
        "//cookbook/models",
        "//cookbook/server/src/main/kotlin/data",
        "@maven//:com_h2database_h2",
        "@maven//:org_assertj_assertj_core",
        "@maven//:org_jdbi_jdbi3_core",
        "@maven//:org_jdbi_jdbi3_kotlin",
        "@maven//:org_jdbi_jdbi3_kotlin_sqlobject",
        "@maven//:org_jdbi_jdbi3_sqlobject",
        "@maven//:org_liquibase_liquibase_core",
        "@maven//:org_mockito_mockito_core",
        "@maven//:org_slf4j_slf4j_api",
    ],
)
