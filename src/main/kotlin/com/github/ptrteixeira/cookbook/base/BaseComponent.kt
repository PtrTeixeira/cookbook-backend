package com.github.ptrteixeira.cookbook.base

import com.codahale.metrics.MetricRegistry
import com.fasterxml.jackson.databind.ObjectMapper
import dagger.Component
import io.dropwizard.db.DataSourceFactory

@Component(modules = arrayOf(BaseModule::class))
interface BaseComponent {
    fun objectMapper(): ObjectMapper
    fun dataSourceFactory(): DataSourceFactory
    fun metrics(): MetricRegistry
}
