package com.github.ptrteixeira.cookbook

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.github.ptrteixeira.cookbook.resources.RecipesResource
import com.github.ptrteixeira.cookbook.resources.Serializer
import io.vertx.core.Vertx
import io.vertx.ext.web.Router


fun main(args: Array<String>) {
    val vertx = Vertx.vertx()
    val server = vertx.createHttpServer()
    val mainRouter = Router.router(vertx)
    val apiRouter = Router.router(vertx)
    val objectMapper = jacksonObjectMapper()
    val serializer = Serializer(objectMapper)

    val recipes = RecipesResource(apiRouter, objectMapper, serializer)

    mainRouter.mountSubRouter("/api/v1", recipes.get())
    server
        .requestHandler(mainRouter::accept)
        .listen(8080)
}
