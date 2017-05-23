package com.github.ptrteixeira.cookbook

import org.apache.logging.log4j.LogManager


fun main(args: Array<String>) {
    val LOG = LogManager.getLogger()

    val component: ApplicationComponent = DaggerApplicationComponent.create()

    val server = component.server()
    val router = component.parentRouter()

    server
        .requestHandler(router::accept)
        .listen(8080)

    Runtime.getRuntime().addShutdownHook(Thread {
        LOG.info("Closing connection to database")
        component.elasticSearchClient().close()
    })
}
