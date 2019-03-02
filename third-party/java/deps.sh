#!/usr/bin/env bash
set -eo pipefail

generate_workspace \
  --artifact com.fasterxml.jackson.core:jackson-annotations:2.9.7 \
  --artifact com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.9.7 \
  --artifact com.fasterxml.jackson.module:jackson-module-kotlin:2.9.7 \
  --artifact com.squareup.retrofit2:retrofit:2.4.0 \
  --artifact com.dropwizard:dropwizard-logging:1.3.5 \
  --artifact io.projectreactor:reactor-core:3.2.2.RELEASE \
  --artifact io.projectreactor:reactor-test:3.2.2.RELEASE \
  --artifact io.sentry:sentry-logback:1.7.13 \
  --artifact org.assertj:assertj-core:3.11.1 \
  --artifact org.mockito:mockito-core:2.23.0 \
  --artifact org.reactivestreams:reactive-streams:1.0.2 \
  --repositories=https://jcenter.bintray.com \
  --output_dir $PWD
