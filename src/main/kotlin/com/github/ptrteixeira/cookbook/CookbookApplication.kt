package com.github.ptrteixeira.cookbook

import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.github.ptrteixeira.cookbook.auth.AuthModule
import com.github.ptrteixeira.cookbook.auth.DaggerAuthComponent
import com.github.ptrteixeira.cookbook.base.BaseModule
import com.github.ptrteixeira.cookbook.base.DaggerBaseComponent
import com.github.ptrteixeira.cookbook.data.DaggerDataComponent
import com.github.ptrteixeira.cookbook.data.DataModule
import com.github.ptrteixeira.cookbook.data.migrationsBundle
import com.github.ptrteixeira.cookbook.model.User
import com.github.ptrteixeira.cookbook.resources.DaggerResourcesComponent
import io.dropwizard.Application
import io.dropwizard.auth.AuthDynamicFeature
import io.dropwizard.auth.AuthValueFactoryProvider
import io.dropwizard.auth.oauth.OAuthCredentialAuthFilter
import io.dropwizard.configuration.EnvironmentVariableSubstitutor
import io.dropwizard.configuration.SubstitutingSourceProvider
import io.dropwizard.jdbi.bundles.DBIExceptionsBundle
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment

class CookbookApplication: Application<CookbookConfiguration>() {
    override fun initialize(bootstrap: Bootstrap<CookbookConfiguration>?) {
        bootstrap?.apply {
            addBundle(migrationsBundle())
            addBundle(DBIExceptionsBundle())

            configurationSourceProvider = SubstitutingSourceProvider(
                configurationSourceProvider,
                EnvironmentVariableSubstitutor(false)
            )

            objectMapper
                ?.registerKotlinModule()
        }
    }

    override fun run(configuration: CookbookConfiguration, environment: Environment) {
        val baseComponent = DaggerBaseComponent.builder()
            .baseModule(BaseModule(configuration, environment))
            .build()
        val authComponent = DaggerAuthComponent.builder()
            .baseComponent(baseComponent)
            .authModule(AuthModule())
            .build()
        val dataComponent = DaggerDataComponent.builder()
            .baseComponent(baseComponent)
            .dataModule(DataModule())
            .build()
        val resourcesComponent = DaggerResourcesComponent.builder()
            .dataComponent(dataComponent)
            .authComponent(authComponent)
            .baseComponent(baseComponent)
            .build()

        environment
            .jersey()
            .register(resourcesComponent.recipesResource())

        environment
            .jersey()
            .register(AuthDynamicFeature(
                OAuthCredentialAuthFilter.Builder<User>()
                    .setAuthenticator(authComponent.tokenAuth())
                    .setPrefix("Bearer")
                    .buildAuthFilter()
            ))
        environment
            .jersey()
            .register(AuthValueFactoryProvider.Binder(User::class.java))
        environment
            .healthChecks()
            .register("database", dataComponent.healthCheck())
    }

    override fun getName(): String {
        return "cookbook"
    }
}

fun main(args: Array<String>) {
    CookbookApplication()
        .run(*args)
}
