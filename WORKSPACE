load("@bazel_tools//tools/build_defs/repo:git.bzl", "git_repository")
load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")
load("@bazel_tools//tools/build_defs/repo:maven_rules.bzl", "maven_dependency_plugin", "maven_jar")

skylib_version = "0.8.0"

http_archive(
    name = "bazel_skylib",
    sha256 = "2ef429f5d7ce7111263289644d233707dba35e39696377ebab8b0bc701f7818e",
    type = "tar.gz",
    url = "https://github.com/bazelbuild/bazel-skylib/releases/download/{}/bazel-skylib.{}.tar.gz".format(skylib_version, skylib_version),
)

http_archive(
    name = "io_bazel_rules_rust",
    sha256 = "69757af5bbb75a485775301d9e4b724f17a54eb9adc27e69adfefead6ef3ce07",
    strip_prefix = "rules_rust-761ef8f820a96c87a288b4f499b7f61772733f32",
    urls = [
        "https://github.com/bazelbuild/rules_rust/archive/761ef8f820a96c87a288b4f499b7f61772733f32.tar.gz",
    ],
)

load("@io_bazel_rules_rust//rust:repositories.bzl", "rust_repositories")

rust_repositories()

load("@io_bazel_rules_rust//:workspace.bzl", "bazel_version")

bazel_version(name = "bazel_version")

rules_kotlin_version = "59dc7473c777b5054e91c1af6b95ed0ecbdc0ace"

http_archive(
    name = "io_bazel_rules_kotlin",
    sha256 = "620546b4f03b001bd06ef8ef5d946f00c58ca1f6426507b0b0b415d1c9f2e102",
    strip_prefix = "rules_kotlin-%s" % rules_kotlin_version,
    type = "zip",
    urls = ["https://github.com/bazelbuild/rules_kotlin/archive/%s.zip" % rules_kotlin_version],
)

RULES_JVM_EXTERNAL_TAG = "2.0.1"

RULES_JVM_EXTERNAL_SHA = "55e8d3951647ae3dffde22b4f7f8dee11b3f70f3f89424713debd7076197eaca"

http_archive(
    name = "rules_jvm_external",
    sha256 = RULES_JVM_EXTERNAL_SHA,
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % RULES_JVM_EXTERNAL_TAG,
)

load("@rules_jvm_external//:defs.bzl", "maven_install")

maven_install(
    artifacts = [
        "com.fasterxml.jackson.core:jackson-annotations:2.9.8",
        "com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.9.8",
        "com.fasterxml.jackson.module:jackson-module-kotlin:2.9.8",
        "com.google.inject:guice:4.2.2",
        "com.google.guava:guava:27.1-jre",
        "com.h2database:h2:1.4.199",
        "com.jakewharton.retrofit:retrofit2-reactor-adapter:2.1.0",
        "com.squareup.retrofit2:converter-jackson:2.5.0",
        "com.squareup.retrofit2:retrofit:2.5.0",
        "io.dropwizard:dropwizard-auth:1.3.9",
        "io.dropwizard:dropwizard-core:1.3.9",
        "io.dropwizard:dropwizard-jdbi3:1.3.9",
        "io.dropwizard:dropwizard-logging:1.3.9",
        "io.dropwizard:dropwizard-migrations:1.3.9",
        "io.dropwizard:dropwizard-testing:1.3.9",
        "io.projectreactor:reactor-core:3.2.8.RELEASE",
        "io.projectreactor:reactor-test:3.2.8.RELEASE",
        "io.sentry:sentry-logback:1.7.16",
        "org.assertj:assertj-core:3.12.2",
        "org.jdbi:jdbi3-kotlin-sqlobject:3.8.0",
        "org.mockito:mockito-core:2.27.0",
        "org.reactivestreams:reactive-streams:1.0.2",
    ],
    repositories = [
        "https://jcenter.bintray.com/",
        "https://repo1.maven.org/maven2/",
    ],
)

load("//third-party/cargo:crates.bzl", "raze_fetch_remote_crates")

raze_fetch_remote_crates()

load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kotlin_repositories", "kt_register_toolchains")

kotlin_repositories()

kt_register_toolchains()

http_archive(
    name = "io_bazel_rules_go",
    sha256 = "86ae934bd4c43b99893fc64be9d9fc684b81461581df7ea8fc291c816f5ee8c5",
    urls = ["https://github.com/bazelbuild/rules_go/releases/download/0.18.3/rules_go-0.18.3.tar.gz"],
)

http_archive(
    name = "bazel_gazelle",
    sha256 = "3c681998538231a2d24d0c07ed5a7658cb72bfb5fd4bf9911157c0e9ac6a2687",
    urls = ["https://github.com/bazelbuild/bazel-gazelle/releases/download/0.17.0/bazel-gazelle-0.17.0.tar.gz"],
)

load("@io_bazel_rules_go//go:deps.bzl", "go_register_toolchains", "go_rules_dependencies")

go_rules_dependencies()

go_register_toolchains()

load("@bazel_gazelle//:deps.bzl", "gazelle_dependencies")

gazelle_dependencies()

load("//third-party/go:deps.bzl", "go_dependencies")

go_dependencies()

load("//third-party/java:junit.bzl", "junit_jupiter_java_repositories", "junit_platform_java_repositories")

maven_server(
    name = "default",
    url = "http://central.maven.org/maven2/",
)

JUNIT_JUPITER_VERSION = "5.4.0"

JUNIT_PLATFORM_VERSION = "1.4.0"

junit_jupiter_java_repositories(
    version = JUNIT_JUPITER_VERSION,
)

junit_platform_java_repositories(
    version = JUNIT_PLATFORM_VERSION,
)
