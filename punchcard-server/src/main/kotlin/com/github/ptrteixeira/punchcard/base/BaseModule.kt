package com.github.ptrteixeira.punchcard.base

import com.fasterxml.jackson.databind.ObjectMapper
import com.github.ptrteixeira.punchcard.StravaPunchcardConfiguration
import com.github.ptrteixeira.strava.api.IStravaService
import com.github.ptrteixeira.strava.api.StravaApi
import com.github.ptrteixeira.strava.api.StravaService
import com.jakewharton.retrofit2.adapter.reactor.ReactorCallAdapterFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.micrometer.core.instrument.MeterRegistry
import io.micrometer.core.instrument.binder.jvm.JvmGcMetrics
import io.micrometer.core.instrument.binder.jvm.JvmMemoryMetrics
import io.micrometer.core.instrument.binder.jvm.JvmThreadMetrics
import io.micrometer.core.instrument.binder.system.ProcessorMetrics
import io.micrometer.prometheus.PrometheusConfig
import io.micrometer.prometheus.PrometheusMeterRegistry
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import java.time.Clock
import javax.inject.Named

@Module(includes = [BaseModule.RegistryModule::class])
internal class BaseModule(private val configuration: StravaPunchcardConfiguration) {
    @Module
    internal interface RegistryModule {
        @Binds
        fun providesMeterRegistry(prometheusMeterRegistry: PrometheusMeterRegistry): MeterRegistry
    }

    @Provides
    fun providesPrometheusMeterRegistry(): PrometheusMeterRegistry {
        val registry = PrometheusMeterRegistry(PrometheusConfig.DEFAULT)
        registry.config()
                .commonTags("application", "punchcard-service")
        JvmMemoryMetrics().bindTo(registry)
        JvmGcMetrics().bindTo(registry)
        ProcessorMetrics().bindTo(registry)
        JvmThreadMetrics().bindTo(registry)

        return registry
    }

    @Provides
    fun providesStravaApi(objectMapper: ObjectMapper): StravaApi {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://www.strava.com/api/v3/")
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .addCallAdapterFactory(ReactorCallAdapterFactory.create())
                .build()
        return retrofit
                .create(StravaApi::class.java)
    }

    @Provides
    fun providesStravaService(stravaApi: StravaApi): IStravaService {
        return StravaService(stravaApi)
    }

    @Provides
    fun providesSystemClock(): Clock {
        return Clock.systemUTC()
    }

    @Provides
    @Named(BASE_URL)
    fun providesBaseUrl(): String {
        return configuration.baseUrl
    }

    @Provides
    @Named(DASHBOARD_UI_URL)
    fun providesDashboardUiUrl(): String {
        return configuration.dashboardUiUrl
    }

    @Provides
    @Named(CLIENT_ID)
    fun providesStravaClientId(): String {
        return configuration.stravaClientId
    }

    @Provides
    @Named(CLIENT_SECRET)
    fun providesStravaClientSecret(): String {
        return configuration.stravaClientSecret
    }

    companion object {
        const val BASE_URL = "punchcard.server.base.url"
        const val DASHBOARD_UI_URL = "punchcard.server.dashboard.ui.url"
        const val CLIENT_ID = "punchcard.server.client.id"
        const val CLIENT_SECRET = "punchcard.server.client.secret"
    }
}