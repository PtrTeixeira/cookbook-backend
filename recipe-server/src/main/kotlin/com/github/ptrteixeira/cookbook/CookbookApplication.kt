package com.github.ptrteixeira.cookbook

import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.github.ptrteixeira.cookbook.auth.AuthComponent
import com.github.ptrteixeira.cookbook.auth.AuthModule
import com.github.ptrteixeira.cookbook.auth.DaggerAuthComponent
import com.github.ptrteixeira.cookbook.base.BaseModule
import com.github.ptrteixeira.cookbook.base.DaggerBaseComponent
import com.github.ptrteixeira.cookbook.config.AuthType
import com.github.ptrteixeira.cookbook.core.User
import com.github.ptrteixeira.cookbook.data.DaggerDataComponent
import com.github.ptrteixeira.cookbook.data.DataComponent
import com.github.ptrteixeira.cookbook.data.DataModule
import com.github.ptrteixeira.cookbook.data.migrationsBundle
import com.github.ptrteixeira.cookbook.resources.DaggerResourcesComponent
import com.github.ptrteixeira.cookbook.resources.ResourcesComponent
import com.github.ptrteixeira.dropwizard.support.configure
import io.dropwizard.Application
import io.dropwizard.jdbi3.bundles.JdbiExceptionsBundle
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment

class CookbookApplication : Application<CookbookConfiguration>() {
    override fun initialize(bootstrap: Bootstrap<CookbookConfiguration>?) {
        configure(bootstrap) {
            bundles(migrationsBundle(), JdbiExceptionsBundle())

            configurationSource {
                useEnvironmentVariables()
            }

            objectMapper {
                registerKotlinModule()
            }
        }
    }

    private fun configureEnvironment(
        environment: Environment,
        authType: AuthType,
        resourcesComponent: ResourcesComponent,
        authComponent: AuthComponent,
        dataComponent: DataComponent
    ) {
        configure(environment) {
            resources(resourcesComponent.recipesResource())

            oauthFilter<User> {
                setAuthenticator(authFilter(authType, authComponent))
            }
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

        configureEnvironment(environment, configuration.auth.type, resourcesComponent, authComponent, dataComponent)
    }

    override fun getName(): String {
        return "cookbook"
    }

    private fun authFilter(authType: AuthType, authComponent: AuthComponent) = when (authType) {
        AuthType.USERNAME -> authComponent.usernameAuth()
        AuthType.OAUTH -> authComponent.tokenAuth()
    }
}

fun main(args: Array<String>) {
    CookbookApplication()
        .run(*args)
}
