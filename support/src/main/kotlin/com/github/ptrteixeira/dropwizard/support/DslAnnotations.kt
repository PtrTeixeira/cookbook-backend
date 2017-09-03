package com.github.ptrteixeira.dropwizard.support

import kotlin.annotation.AnnotationTarget.TYPE

@DslMarker
@Target(TYPE)
annotation class EnvironmentConfigurationDsl

@DslMarker
@Target(TYPE)
annotation class BootstrapConfigurationDsl
