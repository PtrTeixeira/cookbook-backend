package com.github.ptrteixeira.cookbook

import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.github.ptrteixeira.cookbook.base.BaseModule
import com.github.ptrteixeira.cookbook.core.User
import com.github.ptrteixeira.cookbook.data.migrationsBundle
import com.github.ptrteixeira.dropwizard.support.configure
import com.tylerkindy.dropwizard.dagger.DaggerApplication
import com.tylerkindy.dropwizard.dagger.DropwizardInjector
import io.dropwizard.auth.Authenticator
import io.dropwizard.jdbi3.bundles.JdbiExceptionsBundle
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment
import javax.inject.Inject

class CookbookApplication : DaggerApplication<CookbookConfiguration>() {
    @Inject
    internal lateinit var authenticator: Authenticator<String, User>

    override fun applicationInjector(
        configuration: CookbookConfiguration,
        environment: Environment
    ): DropwizardInjector<out DaggerApplication<*>> {
        return DaggerApplicationComponent.builder()
                .baseModule(BaseModule(configuration, environment))
                .build()
    }

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
        super.run()

        configure(environment) {
            oauthFilter<User> {
                setAuthenticator(authenticator)
            }
        }
    }

    override fun getName(): String {
        return "cookbook"
    }
}

fun main(args: Array<String>) {
    CookbookApplication()
        .run(*args)
}
