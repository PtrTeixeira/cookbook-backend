package com.github.ptrteixeira.cookbook

import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.github.ptrteixeira.cookbook.core.User
import com.github.ptrteixeira.cookbook.config.CookbookConfiguration
import com.github.ptrteixeira.cookbook.data.migrationsBundle
import com.github.ptrteixeira.cookbook.resources.RecipesResource
import com.github.ptrteixeira.dropwizard.support.configure
import com.google.inject.TypeLiteral
import com.google.inject.Guice
import com.google.inject.Key
import io.dropwizard.Application
import io.dropwizard.jdbi3.bundles.JdbiExceptionsBundle
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment
import io.dropwizard.auth.Authenticator

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

    override fun run(configuration: CookbookConfiguration, environment: Environment) {
        val injector = Guice.createInjector(ApplicationModule(configuration, environment))

        configure(environment) {
            oauthFilter<User> {
                setAuthenticator(injector.getInstance(Key.get(object: TypeLiteral<Authenticator<String, User>>() {})))
            }


            resources(injector.getInstance(RecipesResource::class.java))
        }
    }

    override fun getName(): String {
        return "cookbook"
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            CookbookApplication()
                    .run(*args)
        }
    }
}
