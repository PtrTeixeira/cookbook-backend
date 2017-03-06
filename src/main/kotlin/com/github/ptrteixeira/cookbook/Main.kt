package com.github.ptrteixeira.cookbook

import io.vertx.core.Vertx
import io.vertx.core.http.HttpMethod
import io.vertx.ext.web.Router


fun main(args: Array<String>) {
    val vertx = Vertx.vertx()
    val server = vertx.createHttpServer()
    val mainRouter = Router.router(vertx)
    val apiRouter = Router.router(vertx)

    val addRoute = withRouter(apiRouter)

    addRoute("/", HttpMethod.GET) {
        val response = it.response()
        response.end("Hello World!")
    }

    mainRouter.mountSubRouter("/api/v1", apiRouter)
    server
        .requestHandler(mainRouter::accept)
        .listen(8080)
}
