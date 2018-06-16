package com.github.ptrteixeira.punchcard

import com.github.ptrteixeira.dropwizard.support.configure
import com.github.ptrteixeira.punchcard.resources.AuthResource
import io.dropwizard.Application
import io.dropwizard.setup.Environment

class StravaPunchcardApplication : Application<StravaPunchcardConfiguration>() {
    override fun run(configuration: StravaPunchcardConfiguration, environment: Environment) {
        configure(environment) {
            resources(AuthResource(
                    baseUrl = configuration.baseUrl,
                    clientId = configuration.stravaClientId
            ))
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            StravaPunchcardApplication()
                    .run(*args)
        }
    }
}