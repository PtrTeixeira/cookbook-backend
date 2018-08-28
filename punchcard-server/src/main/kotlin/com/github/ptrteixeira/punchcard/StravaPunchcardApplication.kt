package com.github.ptrteixeira.punchcard

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.github.ptrteixeira.dropwizard.support.configure
import com.github.ptrteixeira.punchcard.resources.AuthResource
import com.github.ptrteixeira.punchcard.resources.MetricsResource
import com.github.ptrteixeira.punchcard.resources.PunchcardResource
import com.github.ptrteixeira.strava.api.StravaApi
import com.github.ptrteixeira.strava.api.StravaService
import com.jakewharton.retrofit2.adapter.reactor.ReactorCallAdapterFactory
import io.dropwizard.Application
import io.dropwizard.setup.Environment
import io.micrometer.core.instrument.binder.jvm.JvmGcMetrics
import io.micrometer.core.instrument.binder.jvm.JvmMemoryMetrics
import io.micrometer.core.instrument.binder.jvm.JvmThreadMetrics
import io.micrometer.core.instrument.binder.system.ProcessorMetrics
import io.micrometer.prometheus.PrometheusConfig
import io.micrometer.prometheus.PrometheusMeterRegistry
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class StravaPunchcardApplication : Application<StravaPunchcardConfiguration>() {
    override fun run(configuration: StravaPunchcardConfiguration, environment: Environment) {
        val objectMapper = jacksonObjectMapper()
        val stravaApi = strava(objectMapper)
        val registry = meterRegistry()

        configure(environment) {
            resources(
                    AuthResource(
                            baseUrl = configuration.baseUrl,
                            dashboardUiUrl = configuration.dashboardUiUrl,
                            clientId = configuration.stravaClientId,
                            clientSecret = configuration.stravaClientSecret,
                            apiClient = stravaApi,
                            registry = registry
                    ),
                    PunchcardResource(
                            strava = StravaService(stravaApi),
                            registry = registry
                    ),
                    MetricsResource(registry = registry)
            )
        }
    }

    private fun meterRegistry(): PrometheusMeterRegistry {
        val registry = PrometheusMeterRegistry(PrometheusConfig.DEFAULT)
        registry.config()
                .commonTags(
                        "application", "punchcard-service"
                )
        JvmMemoryMetrics().bindTo(registry)
        JvmGcMetrics().bindTo(registry)
        ProcessorMetrics().bindTo(registry)
        JvmThreadMetrics().bindTo(registry)

        return registry
    }

    private fun strava(objectMapper: ObjectMapper): StravaApi {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://www.strava.com/api/v3/")
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .addCallAdapterFactory(ReactorCallAdapterFactory.create())
                .build()
        return retrofit
                .create(StravaApi::class.java)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            StravaPunchcardApplication()
                    .run(*args)
        }
    }
}