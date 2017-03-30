package com.github.ptrteixeira.cookbook.resources

import com.github.ptrteixeira.cookbook.model.Recipe
import com.github.ptrteixeira.cookbook.model.RecipeEgg
import io.vertx.core.http.HttpMethod
import io.vertx.ext.web.Router
import io.vertx.ext.web.RoutingContext
import java.util.*

val MOCK_RECIPE = Recipe(
    name = "Chocolate Chip Cookies",
    ingredients = listOf("Chocolate", "Chips", "Cookies"),
    instructions = "mix",
    tags = emptySet(),
    summary = "Who doesn't like chocolate chip cookies?",
    description = "They were invented right here in Massachusetts, you know."
)

private fun getRecipes(): List<Recipe> {
    return emptyList()
}

private fun getRecipe(id: String): Recipe {
    return MOCK_RECIPE
}

private fun createRecipe(recipe: Recipe): String {
    val id = UUID.randomUUID()

    return "/recipes/$id"
}

private fun deleteRecipe(id: String) {
    // Whee ...
}

private fun patchRecipe(id: String, recipe: RecipeEgg): Recipe {
    return recipe.merge(MOCK_RECIPE)
}

private const val ID_PARAM = "id"

class RecipesResource(private val router: Router,
                      private val serializer: Serializer) {
    fun getRecipes(context: RoutingContext) {
        serializer.withContext<List<Recipe>>(context) { getRecipes() }
    }
    fun getRecipe(context: RoutingContext) {
        serializer.withContextOut(context) {
            val id = it.request().getParam(ID_PARAM)
            getRecipe(id)
        }
    }
    fun createRecipe(context: RoutingContext) {
        serializer.withContext(context) { body: Recipe -> createRecipe(body) }
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

    fun get() : Router {
        val addRoute = withRouter(router)

        addRoute("/recipes", HttpMethod.GET, this::getRecipes)
        addRoute("/recipes", HttpMethod.POST, this::createRecipe)
        addRoute("/recipes/:$ID_PARAM", HttpMethod.GET, this::getRecipe)
        addRoute("/recipes/:$ID_PARAM", HttpMethod.PUT, this::patchRecipe)
        addRoute("/recipes/:$ID_PARAM", HttpMethod.DELETE, this::deleteRecipe)

        return router
    }
}
