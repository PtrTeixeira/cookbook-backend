package com.github.ptrteixeira.cookbook

import com.github.ptrteixeira.cookbook.base.DaggerBaseComponent
import com.github.ptrteixeira.cookbook.data.DaggerDataComponent
import com.github.ptrteixeira.cookbook.resources.DaggerResourcesComponent
import org.apache.logging.log4j.LogManager


fun main(args: Array<String>) {
    val LOG = LogManager.getLogger()

    val baseComponent = DaggerBaseComponent.create()
    val dataComponent = DaggerDataComponent.builder()
            .baseComponent(baseComponent)
            .build()
    val resourcesComponent = DaggerResourcesComponent.builder()
            .baseComponent(baseComponent)
            .dataComponent(dataComponent)
            .build()
    val applicationComponent = DaggerApplicationComponent.builder()
            .baseComponent(baseComponent)
            .resourcesComponent(resourcesComponent)
            .build()

    val server = applicationComponent.server()
    val router = applicationComponent.parentRouter()

    server
        .requestHandler(router::accept)
        .listen(8080)

    Runtime.getRuntime().addShutdownHook(Thread {
        LOG.info("Closing connection to database")
        dataComponent.elasticSearchClient().close()
    })
}
