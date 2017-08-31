package com.github.ptrteixeira.cookbook.base

import com.codahale.metrics.MetricRegistry
import com.fasterxml.jackson.databind.ObjectMapper
import com.github.ptrteixeira.cookbook.config.OauthConfiguration
import com.google.api.client.json.JsonFactory
import dagger.Component
import io.dropwizard.db.DataSourceFactory
import javax.inject.Named

@Component(modules = arrayOf(BaseModule::class))
interface BaseComponent {
    companion object {
        const val BASE_URL = "com.github.ptrteixeira.cookbook.base.url"
    }

    fun objectMapper(): ObjectMapper
    fun jacksonFactory(): JsonFactory
    fun dataSourceFactory(): DataSourceFactory
    fun metrics(): MetricRegistry
    fun oauthConfig(): OauthConfiguration

    @Named(BASE_URL)
    fun baseUrl(): String
}
