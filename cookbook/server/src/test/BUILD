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
        "//third-party/java:com_h2database_h2",
        "//third-party/java:org_assertj_assertj_core",
        "//third-party/java:org_jdbi_jdbi3_core",
        "//third-party/java:org_jdbi_jdbi3_kotlin",
        "//third-party/java:org_jdbi_jdbi3_kotlin_sqlobject",
        "//third-party/java:org_jdbi_jdbi3_sqlobject",
        "//third-party/java:org_liquibase_liquibase_core",
        "//third-party/java:org_mockito_mockito_core",
        "//third-party/java:org_slf4j_slf4j_api",
    ],
)
