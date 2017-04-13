package com.github.ptrteixeira.cookbook.data

import com.github.ptrteixeira.cookbook.model.Recipe
import com.github.ptrteixeira.cookbook.model.RecipeEgg
import java.util.*

val MOCK_RECIPE = Recipe(
    name = "Chocolate Chip Cookies",
    ingredients = listOf("Chocolate", "Chips", "Cookies"),
    instructions = "mix",
    tags = emptySet(),
    summary = "Who doesn't like chocolate chip cookies?",
    description = "They were invented right here in Massachusetts, you know."
)

fun getRecipes(): List<Recipe> {
    return emptyList()
}

fun getRecipe(id: String): Optional<Recipe> {
    return Optional.of(MOCK_RECIPE)
}

fun createRecipe(recipe: Recipe): String {
    val id = UUID.randomUUID()

    return "/recipes/$id"
}

fun deleteRecipe(id: String) {
    // Whee ...
}

fun patchRecipe(id: String, recipe: RecipeEgg): Recipe {
    return recipe.merge(MOCK_RECIPE)
}
