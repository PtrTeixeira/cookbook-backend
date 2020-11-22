workspace(name = "ptrteixeira_cookbook")

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

http_archive(
    name = "rules_pkg",
    sha256 = "6b5969a7acd7b60c02f816773b06fcf32fbe8ba0c7919ccdc2df4f8fb923804a",
    url = "https://github.com/bazelbuild/rules_pkg/releases/download/0.3.0/rules_pkg-0.3.0.tar.gz",
)

load("@rules_pkg//:deps.bzl", "rules_pkg_dependencies")

rules_pkg_dependencies()


http_archive(
    name = "io_bazel_rules_rust",
    sha256 = "b5d4d1c7609714dfef821355f40353c58aa1afb3803401b3442ed2355db9b0c7",
    strip_prefix = "rules_rust-8d2b4eeeff9dce24f5cbb36018f2d60ecd676639",
    urls = [
        # Master branch as of 2020-11-10
        "https://github.com/bazelbuild/rules_rust/archive/8d2b4eeeff9dce24f5cbb36018f2d60ecd676639.tar.gz",
    ],
)
load("@io_bazel_rules_rust//rust:repositories.bzl", "rust_repositories")
rust_repositories()
load("@io_bazel_rules_rust//:workspace.bzl", "rust_workspace")
rust_workspace()

load("//third-party/cargo:crates.bzl", "raze_fetch_remote_crates")

raze_fetch_remote_crates()

http_archive(
    name = "io_bazel_rules_kotlin",
    sha256 = "da0e6e1543fcc79e93d4d93c3333378f3bd5d29e82c1bc2518de0dbe048e6598",
    urls = [
      "https://github.com/bazelbuild/rules_kotlin/releases/download/legacy-1.4.0-rc3/rules_kotlin_release.tgz",
],
)

load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kotlin_repositories", "kt_register_toolchains")

kotlin_repositories()

kt_register_toolchains()

RULES_JVM_EXTERNAL_TAG = "3.3"

RULES_JVM_EXTERNAL_SHA = "d85951a92c0908c80bd8551002d66cb23c3434409c814179c0ff026b53544dab"

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
    sha256 = "207fad3e6689135c5d8713e5a17ba9d1290238f47b9ba545b63d9303406209c6",
    urls = [
        "https://storage.googleapis.com/bazel-mirror/github.com/bazelbuild/rules_go/releases/download/v0.24.7/rules_go-v0.24.7.tar.gz",
        "https://github.com/bazelbuild/rules_go/releases/download/v0.24.7/rules_go-v0.24.7.tar.gz",
    ],
)

http_archive(
    name = "bazel_gazelle",
    sha256 = "b85f48fa105c4403326e9525ad2b2cc437babaa6e15a3fc0b1dbab0ab064bc7c",
    urls = [
        "https://storage.googleapis.com/bazel-mirror/github.com/bazelbuild/bazel-gazelle/releases/download/v0.22.2/bazel-gazelle-v0.22.2.tar.gz",
        "https://github.com/bazelbuild/bazel-gazelle/releases/download/v0.22.2/bazel-gazelle-v0.22.2.tar.gz",
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

http_archive(
    name = "com_google_protobuf",
    sha256 = "9748c0d90e54ea09e5e75fb7fac16edce15d2028d4356f32211cfa3c0e956564",
    strip_prefix = "protobuf-3.11.4",
    urls = ["https://github.com/protocolbuffers/protobuf/archive/v3.11.4.zip"],
)

load("@com_google_protobuf//:protobuf_deps.bzl", "protobuf_deps")
protobuf_deps()

load(
    "//third-party/java:junit.bzl",
    "junit_jupiter_java_repositories",
    "junit_platform_java_repositories",
)

junit_jupiter_java_repositories()

junit_platform_java_repositories()

http_archive(
    name = "io_bazel_rules_docker",
    sha256 = "1698624e878b0607052ae6131aa216d45ebb63871ec497f26c67455b34119c80",
    strip_prefix = "rules_docker-0.15.0",
    urls = ["https://github.com/bazelbuild/rules_docker/releases/download/v0.15.0/rules_docker-v0.15.0.tar.gz"],
)
load(
    "@io_bazel_rules_docker//repositories:repositories.bzl",
    container_repositories = "repositories",
)
container_repositories()
load(
    "@io_bazel_rules_docker//go:image.bzl",
    _go_image_repos = "repositories",
)
_go_image_repos()
