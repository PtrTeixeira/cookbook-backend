package com.github.ptrteixeira.cookbook.base

import com.codahale.metrics.MetricRegistry
import com.fasterxml.jackson.databind.ObjectMapper
import com.github.ptrteixeira.cookbook.config.AuthConfiguration
import com.google.api.client.json.JsonFactory
import dagger.Component
import io.dropwizard.db.DataSourceFactory
import io.dropwizard.setup.Environment
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
    fun authConfig(): AuthConfiguration
    fun environment(): Environment

    @Named(BASE_URL)
    fun baseUrl(): String
}
