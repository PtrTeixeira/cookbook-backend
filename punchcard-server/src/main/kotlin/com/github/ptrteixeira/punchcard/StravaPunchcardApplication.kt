package com.github.ptrteixeira.punchcard

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.github.ptrteixeira.dropwizard.support.configure
import com.github.ptrteixeira.punchcard.resources.AuthResource
import com.github.ptrteixeira.punchcard.resources.PunchcardResource
import com.github.ptrteixeira.strava.api.StravaApi
import com.github.ptrteixeira.strava.api.StravaService
import io.dropwizard.Application
import io.dropwizard.setup.Environment
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory

class StravaPunchcardApplication : Application<StravaPunchcardConfiguration>() {
    override fun run(configuration: StravaPunchcardConfiguration, environment: Environment) {
        val objectMapper = jacksonObjectMapper()
        val retrofit = Retrofit.Builder()
                .baseUrl("https://www.strava.com/api/v3/")
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        val stravaApi = retrofit
                .create(StravaApi::class.java)

        configure(environment) {
            resources(
                    AuthResource(
                            baseUrl = configuration.baseUrl,
                            dashboardUiUrl = configuration.dashboardUiUrl,
                            clientId = configuration.stravaClientId,
                            clientSecret = configuration.stravaClientSecret,
                            apiClient = stravaApi
                    ),
                    PunchcardResource(StravaService(stravaApi)))
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