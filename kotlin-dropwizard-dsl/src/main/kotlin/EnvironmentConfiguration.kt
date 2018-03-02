package com.github.ptrteixeira.dropwizard.support

import com.codahale.metrics.health.HealthCheck
import io.dropwizard.auth.AuthValueFactoryProvider
import io.dropwizard.auth.basic.BasicCredentialAuthFilter
import io.dropwizard.auth.oauth.OAuthCredentialAuthFilter
import io.dropwizard.setup.Environment
import java.security.Principal

class EnvironmentConfiguration
internal constructor(val environment: Environment) {
    fun <T> resources(vararg resourceComponents: T) {
        resourceComponents.forEach {
            environment.jersey()
                .register(it)
        }
    }

    fun healthCheck(name: String, healthCheck: HealthCheck) {
        environment.healthChecks().register(name, healthCheck)
    }

    fun healthCheck(vararg healthChecks: Pair<String, HealthCheck>) {
        healthChecks.forEach { (name, check) ->
            environment
                .healthChecks()
                .register(name, check)
        }
    }

    inline fun <reified P : Principal> oauthFilter(
        fn: (@EnvironmentConfigurationDsl OAuthCredentialAuthFilter.Builder<P>).() -> Unit) {

        val builder = OAuthCredentialAuthFilter.Builder<P>()
        builder.run(fn)
        builder.setPrefix("Bearer")
        environment.jersey().register(builder.buildAuthFilter())

        environment
            .jersey()
            .register(AuthValueFactoryProvider.Binder(P::class.java))
    }

    inline fun <reified P : Principal> basicFilter(
        fn: (@EnvironmentConfigurationDsl BasicCredentialAuthFilter.Builder<P>).() -> Unit) {

        val builder = BasicCredentialAuthFilter.Builder<P>()
        builder.run(fn)
        environment.jersey().register(builder.buildAuthFilter())

        environment
            .jersey()
            .register(AuthValueFactoryProvider.Binder(P::class.java))
    }
}

