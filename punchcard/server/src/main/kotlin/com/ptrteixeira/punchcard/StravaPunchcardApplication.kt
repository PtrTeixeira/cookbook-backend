package com.github.ptrteixeira.punchcard

import com.codahale.metrics.MetricFilter
import com.codahale.metrics.MetricRegistry
import com.codahale.metrics.json.MetricsModule
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.github.ptrteixeira.dropwizard.support.configure
import com.github.ptrteixeira.punchcard.resources.AuthResource
import com.github.ptrteixeira.punchcard.resources.MetricsResource
import com.github.ptrteixeira.punchcard.resources.PunchcardResource
import com.github.ptrteixeira.strava.api.StravaApi
import com.github.ptrteixeira.strava.api.StravaService
import com.jakewharton.retrofit2.adapter.reactor.ReactorCallAdapterFactory
import io.dropwizard.Application
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import java.time.Clock
import java.util.concurrent.TimeUnit

class StravaPunchcardApplication : Application<StravaPunchcardConfiguration>() {
    override fun initialize(bootstrap: Bootstrap<StravaPunchcardConfiguration>?) {
        configure(bootstrap) {
            configurationSource {
                useEnvironmentVariables()
            }

            objectMapper {
                registerKotlinModule()
                registerModule(MetricsModule(TimeUnit.SECONDS, TimeUnit.MICROSECONDS, false, MetricFilter.ALL))
            }
        }
    }


    override fun run(configuration: StravaPunchcardConfiguration, environment: Environment) {
        val metrics = MetricRegistry()
        val stravaService = getStravaService()

        val authResource = AuthResource(
            configuration.baseUrl,
            configuration.dashboardUiUrl,
            configuration.stravaClientId,
            configuration.stravaClientSecret,
            stravaService,
            metrics
        )

        val punchcardRegistry = PunchcardResource(
            stravaService,
            getClock(),
            metrics
        )

        configure(environment) {
            resources(
                MetricsResource(metrics),
                authResource,
                punchcardRegistry
            )
        }
    }

    private fun getObjectMapper(): ObjectMapper {
        return jacksonObjectMapper()
    }

    private fun getStravaApi(): StravaApi {
        val objectMapper = getObjectMapper()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.strava.com/api/v3/")
            .addConverterFactory(JacksonConverterFactory.create(objectMapper))
            .addCallAdapterFactory(ReactorCallAdapterFactory.create())
            .build()
        return retrofit
            .create(StravaApi::class.java)
    }

    private fun getStravaService(): StravaService {
        return StravaService(getStravaApi())
    }

    private fun getClock(): Clock = Clock.systemUTC()

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            StravaPunchcardApplication()
                    .run(*args)
        }
    }
}