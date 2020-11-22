load("@io_bazel_rules_docker//container:container.bzl", "container_push")

alias(
  name = "punchcard",
  actual = "//punchcard/go-server:go-server.tar"
)

container_push(
  name = "publish",
  image = "//punchcard/go-server:go-server",
  format = "Docker",
  registry = "gcr.io",
  repository = "sacred-result-186803/punchcard_server",
  tag = "latest",
)

