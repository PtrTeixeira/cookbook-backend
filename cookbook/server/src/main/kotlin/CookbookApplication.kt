package com.github.ptrteixeira.cookbook

import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.github.ptrteixeira.cookbook.base.BaseModule
import com.github.ptrteixeira.cookbook.core.User
import com.github.ptrteixeira.cookbook.config.CookbookConfiguration
import com.github.ptrteixeira.cookbook.data.RecipeData
import com.github.ptrteixeira.cookbook.data.migrationsBundle
import com.github.ptrteixeira.cookbook.resources.RecipesResource
import com.github.ptrteixeira.dropwizard.support.configure
import com.tylerkindy.dropwizard.dagger.DaggerApplication
import com.tylerkindy.dropwizard.dagger.DropwizardInjector
import io.dropwizard.Application
import io.dropwizard.auth.Authenticator
import io.dropwizard.jdbi3.JdbiFactory
import io.dropwizard.jdbi3.bundles.JdbiExceptionsBundle
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment
import javax.inject.Inject

class CookbookApplication : Application<CookbookConfiguration>() {
    @Inject
    internal lateinit var authenticator: Authenticator<String, User>

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
        val database = configuration.database
        val factory = JdbiFactory()
            .build(environment, database, "h2")
            .installPlugins()
            .registerArrayType(String::class.java, "varchar")
        val recipeData = factory.onDemand(RecipeData::class.java)
        val recipesResource = RecipesResource(recipeData)

        configure(environment) {
            oauthFilter<User> {
                setAuthenticator(authenticator)
            }


            resources(recipesResource)
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
