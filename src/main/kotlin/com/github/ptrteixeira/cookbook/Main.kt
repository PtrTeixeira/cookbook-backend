package com.github.ptrteixeira.cookbook

import org.wasabifx.wasabi.app.AppServer

fun main(args: Array<String>) {
    val server = AppServer()

    server.get("/", {
        response.send("Hello, World!")
    })
    server.get("/first", {
        response.send("First Page!")
    })

    server.start()
}
