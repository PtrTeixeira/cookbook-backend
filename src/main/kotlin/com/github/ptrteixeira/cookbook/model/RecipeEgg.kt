package com.github.ptrteixeira.cookbook.model

import java.util.*

/**
 * Used for PATCH requests to the API. That is, it allows partial specification
 * of a recipe to be modified, so not every field needs to be re-included. The
 * interpretation of the fields is the same as in [Recipe].
 */
data class RecipeEgg (
    val name: String?,
    val ingredients: List<String>?,
    val instructions: String?,
    val summary: String?,
    val description: String?
) {
    fun merge(actual: Recipe): Recipe {
        return Recipe(
            id = actual.id,
            name = name ?: actual.name,
            ingredients = ingredients ?: actual.ingredients,
            instructions = instructions ?: actual.instructions,
            summary = summary ?: actual.summary,
            description = description ?: actual.description
        )
    }

    fun toRecipe(): Recipe {
        val id = UUID.randomUUID().toString()
        return Recipe(
            id = id,
            name = name ?: "",
            ingredients = ingredients ?: listOf(),
            instructions = instructions ?: "",
            summary = summary ?: "",
            description = description ?: ""
        )
    }
}
