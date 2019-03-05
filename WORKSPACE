load("@bazel_tools//tools/build_defs/repo:git.bzl", "git_repository")
load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")
load("@bazel_tools//tools/build_defs/repo:maven_rules.bzl", "maven_dependency_plugin", "maven_jar")


git_repository(
    name = "build_bazel_rules_nodejs",
    remote = "http://github.com/bazelbuild/rules_nodejs.git",
    commit = "f49f9e1e795646d40c64f2c56f02f2a3feaae75a",
)

rules_kotlin_version = "9d100403c084534d41a8b74cfe12dc40275f4dd0"
http_archive(
    name = "io_bazel_rules_kotlin",
    urls = ["https://github.com/bazelbuild/rules_kotlin/archive/%s.zip" % rules_kotlin_version],
    type = "zip",
    strip_prefix = "rules_kotlin-%s" % rules_kotlin_version
)

http_archive(
    name = "google_bazel_common",
    strip_prefix = "bazel-common-1c225e62390566a9e88916471948ddd56e5f111c",
    urls = ["https://github.com/google/bazel-common/archive/1c225e62390566a9e88916471948ddd56e5f111c.zip"],
)

load("@google_bazel_common//:workspace_defs.bzl", "google_common_workspace_rules")
google_common_workspace_rules()


load("@build_bazel_rules_nodejs//:defs.bzl", "node_repositories", "yarn_install")
node_repositories(package_json = ["//:package.json"])
yarn_install(
    name = "npm",
    package_json = "//:package.json",
    yarn_lock = "//:yarn.lock",
)

load("@npm//:install_bazel_dependencies.bzl", "install_bazel_dependencies")
install_bazel_dependencies()

load("@npm_bazel_typescript//:defs.bzl", "ts_setup_workspace")
ts_setup_workspace()

load("//third-party/java:generate_workspace.bzl", "generated_maven_jars")
generated_maven_jars()

load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kotlin_repositories", "kt_register_toolchains")
kotlin_repositories()
kt_register_toolchains()


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

git_repository(
    name = "dagger",
    remote = "https://github.com/google/dagger",
    commit = "9e0baea74aa2b2ef83f78898bac44851b9840f30",
)
