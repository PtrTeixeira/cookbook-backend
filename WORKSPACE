load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

http_archive(
    name = "bazel_skylib",
    sha256 = "97e70364e9249702246c0e9444bccdc4b847bed1eb03c5a3ece4f83dfe6abc44",
    urls = [
        "https://mirror.bazel.build/github.com/bazelbuild/bazel-skylib/releases/download/1.0.2/bazel-skylib-1.0.2.tar.gz",
        "https://github.com/bazelbuild/bazel-skylib/releases/download/1.0.2/bazel-skylib-1.0.2.tar.gz",
    ],
)

load("@bazel_skylib//:workspace.bzl", "bazel_skylib_workspace")

bazel_skylib_workspace()

http_archive(
    name = "rules_pkg",
    sha256 = "4ba8f4ab0ff85f2484287ab06c0d871dcb31cc54d439457d28fd4ae14b18450a",
    url = "https://github.com/bazelbuild/rules_pkg/releases/download/0.2.4/rules_pkg-0.2.4.tar.gz",
)

load("@rules_pkg//:deps.bzl", "rules_pkg_dependencies")

rules_pkg_dependencies()

http_archive(
    name = "io_bazel_rules_rust",
    sha256 = "f33bffd6b779ae5a4f57944e86307f876872b9dbfc07b3d10d0e7f0041f29d5f",
    strip_prefix = "rules_rust-959ba5692cc4e6b803b20018c9eeeadedaa4b637",
    urls = [
        "https://github.com/bazelbuild/rules_rust/archive/959ba5692cc4e6b803b20018c9eeeadedaa4b637.tar.gz",
    ],
)

load("@io_bazel_rules_rust//rust:repositories.bzl", "rust_repositories")

rust_repositories()

load("@io_bazel_rules_rust//:workspace.bzl", "bazel_version")

bazel_version(name = "bazel_version")

load("//third-party/cargo:crates.bzl", "raze_fetch_remote_crates")

raze_fetch_remote_crates()

rules_kotlin_version = "legacy-1.3.0-rc3"

http_archive(
    name = "io_bazel_rules_kotlin",
    sha256 = "54678552125753d9fc0a37736d140f1d2e69778d3e52cf454df41a913b964ede",
    strip_prefix = "rules_kotlin-%s" % rules_kotlin_version,
    type = "zip",
    urls = ["https://github.com/bazelbuild/rules_kotlin/archive/%s.zip" % rules_kotlin_version],
)

load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kotlin_repositories", "kt_register_toolchains")

kotlin_repositories()

kt_register_toolchains()

RULES_JVM_EXTERNAL_TAG = "3.1"

RULES_JVM_EXTERNAL_SHA = "e246373de2353f3d34d35814947aa8b7d0dd1a58c2f7a6c41cfeaff3007c2d14"

http_archive(
    name = "rules_jvm_external",
    sha256 = RULES_JVM_EXTERNAL_SHA,
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % RULES_JVM_EXTERNAL_TAG,
)

load("@rules_jvm_external//:defs.bzl", "maven_install")

maven_install(
    artifacts = [
        "com.fasterxml.jackson.core:jackson-annotations:2.10.1",
        "com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.10.1",
        "com.fasterxml.jackson.module:jackson-module-kotlin:2.10.1",
        "com.google.inject:guice:4.2.2",
        "com.google.guava:guava:28.2-jre",
        "com.h2database:h2:1.4.200",
        "com.jakewharton.retrofit:retrofit2-reactor-adapter:2.1.0",
        "com.squareup.retrofit2:converter-jackson:2.7.1",
        "com.squareup.retrofit2:retrofit:2.7.1",
        "io.dropwizard:dropwizard-auth:1.3.9",
        "io.dropwizard:dropwizard-core:1.3.9",
        "io.dropwizard:dropwizard-jdbi3:1.3.9",
        "io.dropwizard:dropwizard-logging:1.3.9",
        "io.dropwizard:dropwizard-migrations:1.3.9",
        "io.dropwizard:dropwizard-testing:1.3.9",
        "io.projectreactor:reactor-core:3.3.1.RELEASE",
        "io.projectreactor:reactor-test:3.3.1.RELEASE",
        "io.sentry:sentry-logback:1.7.29",
        "org.assertj:assertj-core:3.14.0",
        "org.jdbi:jdbi3-kotlin-sqlobject:3.12.0",
        "org.mockito:mockito-core:3.2.4",
        "org.reactivestreams:reactive-streams:1.0.3",
    ],
    repositories = [
        "https://jcenter.bintray.com/",
        "https://repo1.maven.org/maven2/",
    ],
)

http_archive(
    name = "io_bazel_rules_go",
    sha256 = "e88471aea3a3a4f19ec1310a55ba94772d087e9ce46e41ae38ecebe17935de7b",
    urls = [
        "https://storage.googleapis.com/bazel-mirror/github.com/bazelbuild/rules_go/releases/download/v0.20.3/rules_go-v0.20.3.tar.gz",
        "https://github.com/bazelbuild/rules_go/releases/download/v0.20.3/rules_go-v0.20.3.tar.gz",
    ],
)

http_archive(
    name = "bazel_gazelle",
    sha256 = "86c6d481b3f7aedc1d60c1c211c6f76da282ae197c3b3160f54bd3a8f847896f",
    urls = [
        "https://storage.googleapis.com/bazel-mirror/github.com/bazelbuild/bazel-gazelle/releases/download/v0.19.1/bazel-gazelle-v0.19.1.tar.gz",
        "https://github.com/bazelbuild/bazel-gazelle/releases/download/v0.19.1/bazel-gazelle-v0.19.1.tar.gz",
    ],
)

load("@io_bazel_rules_go//go:deps.bzl", "go_register_toolchains", "go_rules_dependencies")

go_rules_dependencies()

go_register_toolchains()

load("@bazel_gazelle//:deps.bzl", "gazelle_dependencies", "go_repository")

gazelle_dependencies()

# gazelle:repository_macro third-party/go/deps.bzl%go_dependencies
load("//third-party/go:deps.bzl", "go_dependencies")

go_dependencies()

load(
    "//third-party/java:junit.bzl",
    "junit_jupiter_java_repositories",
    "junit_platform_java_repositories",
)

junit_jupiter_java_repositories()

junit_platform_java_repositories()
