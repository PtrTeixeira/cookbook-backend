package com.github.ptrteixeira.cookbook

import com.github.ptrteixeira.cookbook.base.BaseModule
import com.github.ptrteixeira.cookbook.data.DataModule
import com.github.ptrteixeira.cookbook.resources.ResourcesModule
import dagger.Component
import io.vertx.core.http.HttpServer
import io.vertx.ext.web.Router
import org.elasticsearch.client.transport.TransportClient
import javax.inject.Named

@Component(
    modules = arrayOf(
        BaseModule::class,
        DataModule::class,
        ResourcesModule::class,
        ApplicationModule::class
        ))
internal interface ApplicationComponent {
    @Named(ResourcesModule.PARENT_ROUTER)
    fun parentRouter(): Router

    fun server(): HttpServer

    fun elasticSearchClient(): TransportClient
}
