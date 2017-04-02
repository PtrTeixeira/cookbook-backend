package com.github.ptrteixeira.cookbook.resources

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.github.ptrteixeira.cookbook.data.deleteRecipe
import com.github.ptrteixeira.cookbook.data.getRecipe
import com.github.ptrteixeira.cookbook.data.getRecipes
import com.github.ptrteixeira.cookbook.data.patchRecipe
import com.github.ptrteixeira.cookbook.model.Recipe
import com.github.ptrteixeira.cookbook.model.RecipeEgg
import io.vertx.core.http.HttpMethod
import io.vertx.ext.web.Router
import io.vertx.ext.web.RoutingContext

private const val ID_PARAM = "id"

class RecipesResource(private val router: Router,
                      private val mapper: ObjectMapper,
                      private val serializer: Serializer) {
    fun get(): Router {
        val addRoute = withRouter(router)

        addRoute("/recipes", HttpMethod.GET, this::getRecipes)
        addRoute("/recipes", HttpMethod.POST, this::createRecipe)
        addRoute("/recipes/:$ID_PARAM", HttpMethod.GET, this::getRecipe)
        addRoute("/recipes/:$ID_PARAM", HttpMethod.PUT, this::patchRecipe)
        addRoute("/recipes/:$ID_PARAM", HttpMethod.DELETE, this::deleteRecipe)

        return router
    }

    fun getRecipes(context: RoutingContext) {
        val recipes = getRecipes()

        context.response()
            .end(mapper.writeValueAsString(recipes))
    }

    fun getRecipe(context: RoutingContext) {
        val id = context.request().getParam(ID_PARAM)
        val recipe = getRecipe(id)

        context.response()
            .end(mapper.writeValueAsString(recipe))
    }

    fun createRecipe(context: RoutingContext) {
        val body: Recipe = mapper.readValue(context.bodyAsString)

        context.response()
            .setStatusCode(201)
            .putHeader("content-type", "application/json")
            .end(mapper.writeValueAsString(body))
    }

    fun patchRecipe(context: RoutingContext) {
        serializer.withContext(context) { body: RecipeEgg, context: RoutingContext ->
            val id = context.request().getParam(ID_PARAM)
            patchRecipe(id, body)
        }
    }

    fun deleteRecipe(context: RoutingContext) {
        serializer.withContextOut(context) {
            val id = it.request().getParam(ID_PARAM)
            deleteRecipe(id)
            context.response()
                .setStatusCode(204)
        }
    }
}
