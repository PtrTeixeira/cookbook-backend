package com.github.ptrteixeira.cookbook.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

/**
 * Used for the egg pattern - that is, this is everything that a client would send to the application, at least
 * initially. It contains all of the information that makes up a recipe, but it does _not_ contain an ID, as that isn't
 * something that the client should necessarily need to pass along.
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class RecipeEgg (
    val name: String = "",
    val ingredients: List<String> = listOf(),
    val instructions: String = "",
    val summary: String = "",
    val description: String = ""
) {
    fun toRecipe(id: String): Recipe {
        return Recipe(
            id = id,
            name = name,
            ingredients = ingredients,
            instructions = instructions,
            summary = summary,
            description = description
        )
    }
}
