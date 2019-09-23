load("@rules_pkg//:pkg.bzl", "pkg_deb", "pkg_tar")

pkg_tar(
    name = "punchcard-bin",
    srcs = ["//punchcard/server:server_deploy.jar"],
    mode = "0644",
    package_dir = "/opt/punchcard",
)

pkg_tar(
    name = "punchcard-service",
    srcs = [":punchcard.service"],
    mode = "0644",
    package_dir = "/etc/systemd/system",
)

pkg_tar(
    name = "punchcard-etc",
    srcs = [":config.yml"],
    mode = "0600",
    package_dir = "/etc/punchcard",
)

pkg_tar(
    name = "debian-data",
    extension = "tar.gz",
    deps = [
        "punchcard-bin",
        "punchcard-etc",
        "punchcard-service",
    ],
)

pkg_deb(
    name = "punchcard",
    architecture = "amd64",
    conffiles = [
        "/etc/punchcard/config.yml",
        "/etc/systemd/system/punchcard.service",
    ],
    data = ":debian-data",
    depends = [
        "openjdk-8-jre-headless",
    ],
    description = "See when you run, on Strava",
    homepage = "https://github.com/PtrTeixeira/cookbook",
    maintainer = "Peter Teixeira <PtrTeixeira@gmail.com>",
    package = "punchcard",
    postinst = ":postinst.sh",
    postrm = ":postrm.sh",
    prerm = ":prerm.sh",
    version_file = "//:version_file",
)
