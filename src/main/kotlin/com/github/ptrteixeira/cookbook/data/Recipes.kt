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
