#!/usr/bin/env bash
set -eo pipefail

generate_workspace \
  --artifact com.fasterxml.jackson.core:jackson-annotations:2.9.7 \
  --artifact com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.9.7 \
  --artifact com.fasterxml.jackson.module:jackson-module-kotlin:2.9.7 \
  --artifact com.h2database:h2:1.4.197 \
  --artifact com.squareup.retrofit2:retrofit:2.4.0 \
  --artifact com.tylerkindy.com:dropwizard-dagger:0.1.0-alpha03 \
  --artifact io.dropwizard:dropwizard-auth:1.3.5 \
  --artifact io.dropwizard:dropwizard-core:1.3.5 \
  --artifact io.dropwizard:dropwizard-jdbi3:1.3.5 \
  --artifact io.dropwizard:dropwizard-logging:1.3.5 \
  --artifact io.dropwizard:dropwizard-migrations:1.3.5 \
  --artifact io.dropwizard:dropwizard-testing:1.3.5 \
  --artifact io.projectreactor:reactor-core:3.2.2.RELEASE \
  --artifact io.projectreactor:reactor-test:3.2.2.RELEASE \
  --artifact io.sentry:sentry-logback:1.7.13 \
  --artifact org.assertj:assertj-core:3.11.1 \
  --artifact org.jdbi:jdbi3-kotlin:sqlobject:3.5.1 \
  --artifact org.mockito:mockito-core:2.23.0 \
  --artifact org.reactivestreams:reactive-streams:1.0.2 \
  --repositories=https://jcenter.bintray.com \
  --output_dir $PWD/tmp
