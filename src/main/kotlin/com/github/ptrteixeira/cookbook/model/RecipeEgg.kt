package com.github.ptrteixeira.cookbook.model

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
    val tags: Set<String>?,
    val description: String?
) {
    fun merge(actual: Recipe): Recipe {
        val name = name ?: actual.name
        val ingredients = ingredients ?: actual.ingredients
        val instructions = instructions ?: actual.instructions
        val tags = tags ?: actual.tags
        val summary = summary ?: actual.summary
        val description = description ?: actual.description

        return Recipe(name, ingredients, instructions, tags, summary, description)
    }
}
