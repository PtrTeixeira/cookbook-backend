package com.github.ptrteixeira.cookbook.support.configuration

import com.fasterxml.jackson.databind.ObjectMapper
import io.dropwizard.Bundle
import io.dropwizard.Configuration
import io.dropwizard.configuration.ConfigurationSourceProvider
import io.dropwizard.configuration.EnvironmentVariableSubstitutor
import io.dropwizard.configuration.SubstitutingSourceProvider
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

    fun configurationSource(fn: ConfigSourceProviderConfiguration<T>.() -> Unit) {
        bootstrap.configurationSourceProvider = ConfigSourceProviderConfiguration(bootstrap)
            .apply(fn)
            .evaluate()
    }
}

@BootstrapConfigurationDsl
class ConfigSourceProviderConfiguration<T: Configuration> internal constructor(bootstrap: Bootstrap<T>) {
    private var configSourceProvider = bootstrap.configurationSourceProvider

    fun useEnvironmentVariables(strict: Boolean = false) {
        this.configSourceProvider = SubstitutingSourceProvider(configSourceProvider,
            EnvironmentVariableSubstitutor(strict))
    }

    fun replaceWith(replacement: ConfigurationSourceProvider) {
        this.configSourceProvider = replacement
    }

    fun evaluate(): ConfigurationSourceProvider = configSourceProvider
}
