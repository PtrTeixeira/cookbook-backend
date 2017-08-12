package com.github.ptrteixeira.cookbook

import com.fasterxml.jackson.module.kotlin.registerKotlinModule
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
import io.dropwizard.auth.basic.BasicCredentialAuthFilter
import io.dropwizard.jdbi.bundles.DBIExceptionsBundle
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment

class CookbookApplication: Application<CookbookConfiguration>() {
    override fun initialize(bootstrap: Bootstrap<CookbookConfiguration>?) {
        bootstrap
            ?.addBundle(migrationsBundle())
        bootstrap
            ?.addBundle(DBIExceptionsBundle())

        bootstrap
            ?.objectMapper
            ?.registerKotlinModule()
    }

    override fun run(configuration: CookbookConfiguration, environment: Environment) {
        val baseComponent = DaggerBaseComponent.builder()
            .baseModule(BaseModule(configuration, environment))
            .build()
        val authComponent = DaggerAuthComponent.create()
        val dataComponent = DaggerDataComponent.builder()
            .baseComponent(baseComponent)
            .dataModule(DataModule())
            .build()
        val resourcesComponent = DaggerResourcesComponent.builder()
            .dataComponent(dataComponent)
            .build()

        environment
            .jersey()
            .register(resourcesComponent.recipesResource())

        environment
            .jersey()
            .register(AuthDynamicFeature(
                BasicCredentialAuthFilter.Builder<User>()
                    .setAuthenticator(authComponent.auth())
                    .setRealm("com.github.ptrteixeira.cookbook")
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
