package com.github.ptrteixeira.dropwizard.support

import com.fasterxml.jackson.databind.ObjectMapper
import io.dropwizard.Bundle
import io.dropwizard.Configuration
import io.dropwizard.configuration.ConfigurationSourceProvider
import io.dropwizard.setup.Bootstrap

class BootstrapConfiguration<T : Configuration>
internal constructor(private val bootstrap: Bootstrap<T>) {
    fun bundles(vararg bundles: Bundle) {
        bundles.forEach {
            bootstrap.addBundle(it)
        }
    }

    fun objectMapper(fn: (@BootstrapConfigurationDsl ObjectMapper).() -> Unit) {
        bootstrap
            .objectMapper
            ?.apply(fn)
    }

    fun configurationSource(fn: (@BootstrapConfigurationDsl ConfigurationSourceProvider) -> ConfigurationSourceProvider) {
        bootstrap.configurationSourceProvider = bootstrap
            .configurationSourceProvider
            ?.run(fn)
    }
}

