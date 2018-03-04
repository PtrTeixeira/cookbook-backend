package com.github.ptrteixeira.cookbook.support.configuration

import kotlin.annotation.AnnotationTarget.CLASS
import kotlin.annotation.AnnotationTarget.TYPE

@DslMarker
@Target(TYPE)
annotation class EnvironmentConfigurationDsl

@DslMarker
@Target(TYPE, CLASS)
annotation class BootstrapConfigurationDsl
