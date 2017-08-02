package com.github.ptrteixeira.cookbook.base

import com.codahale.metrics.MetricRegistry
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.github.ptrteixeira.cookbook.CookbookConfiguration
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.dropwizard.db.DataSourceFactory
import io.dropwizard.setup.Environment

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
}
