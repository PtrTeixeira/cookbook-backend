package com.github.ptrteixeira.cookbook.base

import com.codahale.metrics.MetricRegistry
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.github.ptrteixeira.cookbook.CookbookConfiguration
import com.github.ptrteixeira.cookbook.config.OauthConfiguration
import com.google.api.client.json.JsonFactory
import com.google.api.client.json.jackson2.JacksonFactory
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.dropwizard.db.DataSourceFactory
import io.dropwizard.setup.Environment
import javax.inject.Named

@Module
internal class BaseModule(
    private val config: CookbookConfiguration,
    private val environment: Environment
    ) {
    @Provides
    @Reusable
    fun objectMapper(): ObjectMapper {
        val objectMapper = jacksonObjectMapper()
        objectMapper.registerModule(Jdk8Module())
        return objectMapper
    }

    @Provides
    fun dataSourceFactory(): DataSourceFactory = config.database

    @Provides
    fun metrics(): MetricRegistry = environment.metrics()

    @Provides
    fun oauthConfig(): OauthConfiguration = config.oauthConfig

    @Provides
    @Named(BaseComponent.BASE_URL)
    fun baseUrl(): String = config.baseUrl


    @Provides
    fun jacksonFactory(): JsonFactory = JacksonFactory()
}
