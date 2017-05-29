package com.github.ptrteixeira.cookbook.data

import com.github.ptrteixeira.cookbook.model.Recipe
import com.github.ptrteixeira.cookbook.model.RecipeEgg
import org.elasticsearch.client.transport.TransportClient
import java.util.*

val MOCK_RECIPE = Recipe(
    name = "Chocolate Chip Cookies",
    ingredients = listOf("Chocolate", "Chips", "Cookies"),
    instructions = "mix",
    tags = emptySet(),
    summary = "Who doesn't like chocolate chip cookies?",
    description = "They were invented right here in Massachusetts, you know."
)

internal fun getRecipes(client: TransportClient): () -> List<Recipe> = { ->
    emptyList()
}

internal fun getRecipe(client: TransportClient) = { id : String ->
    Optional.of(MOCK_RECIPE)
}

internal fun createRecipe(client: TransportClient) = { recipe: Recipe ->
    val id = UUID.randomUUID()

    "/recipes/$id"
}

internal fun deleteRecipe(client: TransportClient) = { id: String ->
    true
}

internal fun patchRecipe(client: TransportClient) = { id: String, recipe: RecipeEgg ->
    recipe.merge(MOCK_RECIPE)
}


internal fun getRecipes(): List<Recipe> {
    return emptyList()
}

fun getRecipe(id: String): Optional<Recipe> {
    return Optional.of(MOCK_RECIPE)
}

fun createRecipe(recipe: Recipe): String {
    val id = UUID.randomUUID()

    return "/recipes/$id"
}

// TODO need a better way of propagating errors
fun deleteRecipe(id: String): Boolean {
    return true
}

fun patchRecipe(id: String, recipe: RecipeEgg): Recipe {
    return recipe.merge(MOCK_RECIPE)
}
