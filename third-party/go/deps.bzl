load("@bazel_gazelle//:deps.bzl", "go_repository")

def go_dependencies():
  go_repository(
    name = "org_golang_x_oauth2",
    importpath = "golang.org/x/oauth2",
    commit = "c85d3e98c914e3a33234ad863dcbff5dbc425bb8",
  )

  go_repository(
    name = "org_golang_x_oauth2_google",
    importpath = "golang.org/x/oauth2",
    commit = "c85d3e98c914e3a33234ad863dcbff5dbc425bb8",
  )

  go_repository(
    name = "org_golang_google_api",
    importpath = "google.golang.org/api",
    commit = "af986cd59464c8245c96ea197dd3de71d5930b8e",
  )

  go_repository(
    name = "com_google_cloud_go",
    importpath = "cloud.google.com/go",
    commit = "408b387e95d4ba708acd3e2361d56b4aaa3b4cf8",
  )

  go_repository(
    name = "io_opencensus_go",
    importpath = "go.opencensus.io",
    commit = "41e54b832491efe97a2aafe696f6e7d812f136bb",
	)

  go_repository(
    name = "com_github_hashicorp_golang_lru",
    importpath = "github.com/hashicorp/golang-lru",
    commit = "7087cb70de9f7a8bc0a10c375cb0d2280a8edf9c",
	)
