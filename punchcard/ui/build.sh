#!/usr/bin/env bash
set -eo pipefail

# Workaround until I learn how to use bazel
bazel run //bzl/parcel -- build $PWD/public/index.html --out-dir $PWD/dist

