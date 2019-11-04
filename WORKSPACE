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

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")
http_archive(
    name = "rules_pkg",
    url = "https://github.com/bazelbuild/rules_pkg/releases/download/0.2.2/rules_pkg-0.2.2.tar.gz",
    sha256 = "02de387c5ef874379e784ac968bf6efffe5285a168cab5a3169e08cfc634fd22",
)
load("@rules_pkg//:deps.bzl", "rules_pkg_dependencies")
rules_pkg_dependencies()

http_archive(
		name = "rules_proto",
		sha256 = "602e7161d9195e50246177e7c55b2f39950a9cf7366f74ed5f22fd45750cd208",
		strip_prefix = "rules_proto-97d8af4dc474595af3900dd85cb3a29ad28cc313",
		urls = [
			"https://mirror.bazel.build/github.com/bazelbuild/rules_proto/archive/97d8af4dc474595af3900dd85cb3a29ad28cc313.tar.gz",
			"https://github.com/bazelbuild/rules_proto/archive/97d8af4dc474595af3900dd85cb3a29ad28cc313.tar.gz",
		],
)
load("@rules_proto//proto:repositories.bzl", "rules_proto_dependencies", "rules_proto_toolchains")
rules_proto_dependencies()
rules_proto_toolchains()

http_archive(
    name = "io_bazel_rules_rust",
    sha256 = "019958e96fcb9d8b5e5f74f31ad58f9c59804e8c04cf5aae03b983001edc79e0",
    strip_prefix = "rules_rust-f727669b8ac3c9d237ed9bc7833b8e1eeec90506",
    urls = [
        "https://github.com/bazelbuild/rules_rust/archive/f727669b8ac3c9d237ed9bc7833b8e1eeec90506.tar.gz",
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
    urls = [
        "https://storage.googleapis.com/bazel-mirror/github.com/bazelbuild/rules_go/releases/download/v0.20.2/rules_go-v0.20.2.tar.gz",
        "https://github.com/bazelbuild/rules_go/releases/download/v0.20.2/rules_go-v0.20.2.tar.gz",

    ],
    sha256 = "b9aa86ec08a292b97ec4591cf578e020b35f98e12173bbd4a921f84f583aebd9",
)

http_archive(
    name = "bazel_gazelle",
    urls = [
        "https://storage.googleapis.com/bazel-mirror/github.com/bazelbuild/bazel-gazelle/releases/download/v0.19.0/bazel-gazelle-v0.19.0.tar.gz",
        "https://github.com/bazelbuild/bazel-gazelle/releases/download/v0.19.0/bazel-gazelle-v0.19.0.tar.gz",
    ],
    sha256 = "41bff2a0b32b02f20c227d234aa25ef3783998e5453f7eade929704dcff7cd4b",
)

load("@io_bazel_rules_go//go:deps.bzl", "go_register_toolchains", "go_rules_dependencies")

go_rules_dependencies()

go_register_toolchains()

load("@bazel_gazelle//:deps.bzl", "gazelle_dependencies")

gazelle_dependencies()

# gazelle:repository_macro third-party/go/deps.bzl%go_dependencies
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
