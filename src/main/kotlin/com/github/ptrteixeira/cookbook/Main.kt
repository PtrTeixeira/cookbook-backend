package com.github.ptrteixeira.cookbook

import io.vertx.core.Vertx
import io.vertx.ext.web.Router


fun main(args: Array<String>) {
    val vertx = Vertx.vertx()
    val server = vertx.createHttpServer()
    val router = Router.router(vertx)

    router.route("/").handler {
        val response = it.response()
        response.putHeader("content-type", "text/plain")
        response.end("Hello World!")
    }

    server
        .requestHandler(router::accept)
        .listen(8080)
}
