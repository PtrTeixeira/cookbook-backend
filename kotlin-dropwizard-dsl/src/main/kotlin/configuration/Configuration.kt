package com.github.ptrteixeira.cookbook.support.configuration

import io.dropwizard.Configuration
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment

fun <T: Configuration> configure(bootstrap: Bootstrap<T>?,
                                 builder: (@BootstrapConfigurationDsl BootstrapConfiguration<T>).() -> Unit) {
    bootstrap?.let {
        builder(BootstrapConfiguration(it))
    }
}

fun configure(environment: Environment,
              builder: (@EnvironmentConfigurationDsl EnvironmentConfiguration).() -> Unit) {
    builder(EnvironmentConfiguration(environment))
}
