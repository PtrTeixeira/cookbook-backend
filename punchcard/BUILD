load("@rules_pkg//:pkg.bzl", "pkg_tar", "pkg_deb")

pkg_tar(
    name = "punchcard-bin",
    package_dir = "/opt/punchcard",
    srcs = ["//punchcard/server:server_deploy.jar"],
    mode = "0644",
)

pkg_tar(
    name = "punchcard-service",
    package_dir = "/etc/systemd/system",
    srcs = [":punchcard.service"],
    mode = "0644",
)

pkg_tar(
    name = "punchcard-etc",
    package_dir = "/etc/punchcard",
    srcs = [":config.yml"],
    mode = "0600",
)

pkg_tar(
    name = "debian-data",
    extension = "tar.gz",
    deps = [
        "punchcard-bin",
        "punchcard-service",
        "punchcard-etc",
    ],
)

pkg_deb(
    name = "punchcard",
    architecture = "amd64",
    data = ":debian-data",
    postinst = ":postinst.sh",
    prerm = ":prerm.sh",
    postrm = ":postrm.sh",
    depends = [
        "openjdk-8-jre-headless",
    ],
    description = "See when you run, on Strava",
    homepage = "https://github.com/PtrTeixeira/cookbook",
    maintainer = "Peter Teixeira <PtrTeixeira@gmail.com>",
    package = "punchcard",
    version = "0.1.0",
)
