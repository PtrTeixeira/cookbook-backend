load("@bazel_tools//tools/build_defs/repo:git.bzl", "git_repository")
load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")
load("@bazel_tools//tools/build_defs/repo:maven_rules.bzl", "maven_dependency_plugin", "maven_jar")

http_archive(
    name = "io_bazel_rules_rust",
    sha256 = "c82118824b2448b77146f1dae97b6eaa717babedad0822aca4879f3cbbf2b7b5",
    strip_prefix = "rules_rust-3228ccd3814c2ad0d7307d2f87fb8ff9616149d7",
    urls = [
        "https://github.com/bazelbuild/rules_rust/archive/3228ccd3814c2ad0d7307d2f87fb8ff9616149d7.tar.gz",
    ],
)
http_archive(
    name = "bazel_skylib",
    sha256 = "eb5c57e4c12e68c0c20bc774bfbc60a568e800d025557bc4ea022c6479acc867",
    strip_prefix = "bazel-skylib-0.6.0",
    url = "https://github.com/bazelbuild/bazel-skylib/archive/0.6.0.tar.gz",
)

load("@io_bazel_rules_rust//rust:repositories.bzl", "rust_repositories")
rust_repositories()
load("@io_bazel_rules_rust//:workspace.bzl", "bazel_version")
bazel_version(name = "bazel_version")


rules_kotlin_version = "9d100403c084534d41a8b74cfe12dc40275f4dd0"
http_archive(
    name = "io_bazel_rules_kotlin",
    strip_prefix = "rules_kotlin-%s" % rules_kotlin_version,
    type = "zip",
    urls = ["https://github.com/bazelbuild/rules_kotlin/archive/%s.zip" % rules_kotlin_version],
    sha256 = "43c788de9a56afc01b61ae77b84fcc105bf0a361f2e2f66e4c46e90c420674f7"
)

RULES_JVM_EXTERNAL_TAG = "1.1"
RULES_JVM_EXTERNAL_SHA = "ade316ec98ba0769bb1189b345d9877de99dd1b1e82f5a649d6ccbcb8da51c1f"
http_archive(
    name = "rules_jvm_external",
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    sha256 = RULES_JVM_EXTERNAL_SHA,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % RULES_JVM_EXTERNAL_TAG,
)
load("@rules_jvm_external//:defs.bzl", "maven_install")


maven_install(
  artifacts = [
  "com.fasterxml.jackson.core:jackson-annotations:2.9.7",
  "com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.9.7",
  "com.fasterxml.jackson.module:jackson-module-kotlin:2.9.7",
  "com.google.inject:guice:4.2.2",
  "com.google.guava:guava:27.1-jre",
  "com.h2database:h2:1.4.197",
  "com.jakewharton.retrofit:retrofit2-reactor-adapter:2.1.0",
  "com.squareup.retrofit2:converter-jackson:2.4.0",
  "com.squareup.retrofit2:retrofit:2.4.0",
  "io.dropwizard:dropwizard-auth:1.3.5",
  "io.dropwizard:dropwizard-core:1.3.5",
  "io.dropwizard:dropwizard-jdbi3:1.3.5",
  "io.dropwizard:dropwizard-logging:1.3.5",
  "io.dropwizard:dropwizard-migrations:1.3.5",
  "io.dropwizard:dropwizard-testing:1.3.5",
  "io.projectreactor:reactor-core:3.2.2.RELEASE",
  "io.projectreactor:reactor-test:3.2.2.RELEASE",
  "io.sentry:sentry-logback:1.7.13",
  "org.assertj:assertj-core:3.11.1",
  "org.jdbi:jdbi3-kotlin-sqlobject:3.5.1",
  "org.mockito:mockito-core:2.23.0",
  "org.reactivestreams:reactive-streams:1.0.2",
  ],
  repositories = [
    "https://jcenter.bintray.com/",
    "https://repo1.maven.org/maven2/"
  ]
)


load("//third-party/cargo:crates.bzl", "raze_fetch_remote_crates")
raze_fetch_remote_crates()

load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kotlin_repositories", "kt_register_toolchains")

kotlin_repositories()

kt_register_toolchains()

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")
http_archive(
    name = "io_bazel_rules_go",
    urls = ["https://github.com/bazelbuild/rules_go/releases/download/0.18.1/rules_go-0.18.1.tar.gz"],
    sha256 = "77dfd303492f2634de7a660445ee2d3de2960cbd52f97d8c0dffa9362d3ddef9",
)
http_archive(
    name = "bazel_gazelle",
    urls = ["https://github.com/bazelbuild/bazel-gazelle/releases/download/0.17.0/bazel-gazelle-0.17.0.tar.gz"],
    sha256 = "3c681998538231a2d24d0c07ed5a7658cb72bfb5fd4bf9911157c0e9ac6a2687",
)
load("@io_bazel_rules_go//go:deps.bzl", "go_rules_dependencies", "go_register_toolchains")
go_rules_dependencies()
go_register_toolchains()
load("@bazel_gazelle//:deps.bzl", "gazelle_dependencies")
gazelle_dependencies()

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
