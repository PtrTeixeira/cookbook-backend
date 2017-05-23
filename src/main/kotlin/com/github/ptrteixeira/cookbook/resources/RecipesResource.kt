package com.github.ptrteixeira.cookbook.resources

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.github.ptrteixeira.cookbook.model.Recipe
import com.github.ptrteixeira.cookbook.model.RecipeEgg
import io.vertx.ext.web.RoutingContext
import java.util.*
import javax.inject.Inject

internal class RecipesResource
@Inject constructor(
    private val mapper: ObjectMapper,
    private val getRecipes: () -> List<Recipe>,
    private val getRecipe: (String) -> Optional<Recipe>,
    private val createRecipe: (Recipe) -> String,
    private val modifyRecipe: (String, RecipeEgg) -> Recipe,
    private val deleteRecipe: (String) -> Unit
) {
    fun getRecipesResource(context: RoutingContext) {
        val recipes = getRecipes()

        context.response()
            .end(mapper.writeValueAsString(recipes))
    }

    fun getRecipeResource(context: RoutingContext) {
        val id = context.request().getParam(ID_PARAM)
        val recipe = getRecipe(id)

        context.response()
            .end(mapper.writeValueAsString(recipe))
    }

    fun createRecipeResource(context: RoutingContext) {
        val body: Recipe = mapper.readValue(context.bodyAsString)
        val saved = createRecipe(body)

        context.response()
            .setStatusCode(201)
            .putHeader("content-type", "application/json")
            .end(mapper.writeValueAsString(saved))
    }

    fun patchRecipeResource(context: RoutingContext) {
        val body: RecipeEgg = mapper.readValue(context.bodyAsString)
        val id = context.request().getParam(ID_PARAM)
        val patched = modifyRecipe(id, body)

        context.response()
            .setStatusCode(200)
            .putHeader("content-type", "application/json")
            .end(mapper.writeValueAsString(patched))
    }

    fun deleteRecipeResource(context: RoutingContext) {
        val id = context.request().getParam(ID_PARAM)
        deleteRecipe(id)

        context.response()
            .setStatusCode(204)
            .end()
    }

    companion object {
        const val ID_PARAM = "id"
    }
}
