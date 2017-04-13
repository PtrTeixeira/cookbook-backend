package com.github.ptrteixeira.cookbook

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.github.ptrteixeira.cookbook.data.*
import com.github.ptrteixeira.cookbook.resources.RecipesResource
import io.vertx.core.Vertx
import io.vertx.ext.web.Router


fun main(args: Array<String>) {
    val vertx = Vertx.vertx()
    val server = vertx.createHttpServer()
    val mainRouter = Router.router(vertx)
    val apiRouter = Router.router(vertx)
    val objectMapper = jacksonObjectMapper()

    val recipes = RecipesResource(
        router = apiRouter,
        mapper = objectMapper,
        getRecipes = ::getRecipes,
        getRecipe = ::getRecipe,
        createRecipe = ::createRecipe,
        modifyRecipe = ::patchRecipe,
        deleteRecipe = ::deleteRecipe
        )

    mainRouter.mountSubRouter("/api/v1", recipes.get())
    server
        .requestHandler(mainRouter::accept)
        .listen(8080)
}

fun getRouter(vertx: Vertx): Router {
    val mainRouter = Router.router(vertx)
    val apiRouter = Router.router(vertx)
    val objectMapper = jacksonObjectMapper()

    val recipes = RecipesResource(
        router = apiRouter,
        mapper = objectMapper,
        getRecipes = ::getRecipes,
        getRecipe = ::getRecipe,
        createRecipe = ::createRecipe,
        modifyRecipe = ::patchRecipe,
        deleteRecipe = ::deleteRecipe
    )

    return mainRouter.mountSubRouter("/api/v1", recipes.get())
}
