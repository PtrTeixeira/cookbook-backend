package com.github.ptrteixeira.cookbook.auth

import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.github.ptrteixeira.cookbook.auth.resources.LoginResource
import com.github.ptrteixeira.dropwizard.support.configure
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier
import com.google.api.client.http.javanet.NetHttpTransport
import com.google.api.client.json.jackson2.JacksonFactory
import io.dropwizard.Application
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment

class AuthApplication : Application<AuthConfiguration>() {
    override fun initialize(bootstrap: Bootstrap<AuthConfiguration>?) {
        configure(bootstrap) {
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
            resources(LoginResource(googleTokenVerifier(configuration)))
        }
    }

    override fun getName(): String {
        return "auth-server"
    }

    private fun googleTokenVerifier(authConfig: AuthConfiguration): GoogleIdTokenVerifier {
        return GoogleIdTokenVerifier.Builder(NetHttpTransport(), JacksonFactory())
                .setAudience(listOf(authConfig.googleAppToken))
                .build()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            AuthApplication()
                    .run(*args)
        }
    }
}
