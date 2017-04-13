package com.github.ptrteixeira.cookbook.resources

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.github.ptrteixeira.cookbook.model.Recipe
import com.github.ptrteixeira.cookbook.model.RecipeEgg
import io.vertx.core.http.HttpMethod
import io.vertx.ext.web.Router
import io.vertx.ext.web.RoutingContext
import java.util.*

private const val ID_PARAM = "id"

class RecipesResource(private val router: Router,
                      private val mapper: ObjectMapper,
                      private val getRecipes: () -> List<Recipe>,
                      private val getRecipe: (String) -> Optional<Recipe>,
                      private val createRecipe: (Recipe) -> String,
                      private val modifyRecipe: (String, RecipeEgg) -> Recipe,
                      private val deleteRecipe: (String) -> Unit
                      ) {
    fun get(): Router {
        val addRoute = withRouter(router)

        addRoute("/recipes", HttpMethod.GET, this::getRecipesResource)
        addRoute("/recipes", HttpMethod.POST, this::createRecipeResource)
        addRoute("/recipes/:$ID_PARAM", HttpMethod.GET, this::getRecipeResource)
        addRoute("/recipes/:$ID_PARAM", HttpMethod.PATCH, this::patchRecipeResource)
        addRoute("/recipes/:$ID_PARAM", HttpMethod.DELETE, this::deleteRecipeResource)

        return router
    }

    private fun getRecipesResource(context: RoutingContext) {
        val recipes = getRecipes()

        context.response()
            .end(mapper.writeValueAsString(recipes))
    }

    private fun getRecipeResource(context: RoutingContext) {
        val id = context.request().getParam(ID_PARAM)
        val recipe = getRecipe(id)

        context.response()
            .end(mapper.writeValueAsString(recipe))
    }

    private fun createRecipeResource(context: RoutingContext) {
        val body: Recipe = mapper.readValue(context.bodyAsString)
        val saved = createRecipe(body)

        context.response()
            .setStatusCode(201)
            .putHeader("content-type", "application/json")
            .end(mapper.writeValueAsString(saved))
    }

    private fun patchRecipeResource(context: RoutingContext) {
        val body: RecipeEgg = mapper.readValue(context.bodyAsString)
        val id = context.request().getParam(ID_PARAM)
        val patched = modifyRecipe(id, body)

        context.response()
            .setStatusCode(200)
            .putHeader("content-type", "application/json")
            .end(mapper.writeValueAsString(patched))
    }

    private fun deleteRecipeResource(context: RoutingContext) {
        val id = context.request().getParam(ID_PARAM)
        deleteRecipe(id)

        context.response()
            .setStatusCode(204)
            .end()
    }
}
