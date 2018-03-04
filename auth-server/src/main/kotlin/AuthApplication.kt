package com.github.ptrteixeira.cookbook.auth

import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.github.ptrteixeira.cookbook.auth.resources.LoginResource
import com.github.ptrteixeira.dropwizard.support.configure
import io.dropwizard.Application
import io.dropwizard.jdbi.bundles.DBIExceptionsBundle
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment

class AuthApplication : Application<AuthConfiguration>() {
    override fun initialize(bootstrap: Bootstrap<AuthConfiguration>?) {
        configure(bootstrap) {
            bundles(DBIExceptionsBundle())

            configurationSource {
                useEnvironmentVariables()
            }

            objectMapper {
                registerKotlinModule()
            }
        }
    }

    override fun run(configuration: AuthConfiguration, environment: Environment) {
        configure(environment) {
            resources(LoginResource())
        }
    }

    override fun getName(): String {
        return "auth-server"
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            AuthApplication()
                    .run(*args)
        }
    }
}
