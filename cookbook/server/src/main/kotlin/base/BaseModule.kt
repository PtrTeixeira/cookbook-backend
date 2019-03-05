package com.github.ptrteixeira.cookbook.base

import com.codahale.metrics.MetricRegistry
import com.github.ptrteixeira.cookbook.config.CookbookConfiguration
import com.github.ptrteixeira.cookbook.config.AuthConfiguration
import dagger.Module
import dagger.Provides
import io.dropwizard.db.DataSourceFactory
import io.dropwizard.setup.Environment

@Module
internal class BaseModule(
    private val config: CookbookConfiguration,
    private val environment: Environment
) {

    @Provides
    fun environment() = environment

    @Provides
    fun dataSourceFactory(): DataSourceFactory = config.database

    @Provides
    fun metrics(): MetricRegistry = environment.metrics()

    @Provides
    fun authConfig(): AuthConfiguration = config.auth
}
