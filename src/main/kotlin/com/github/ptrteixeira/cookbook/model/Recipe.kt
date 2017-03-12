package com.github.ptrteixeira.cookbook.model

/**
 * Represents a Recipe in the domain model of this project.
 *
 * @property name - Name of this recipe when displayed
 * @property ingredients - What goes into the recipe?
 * @property instructions - How do you make this? Interpreted more in paragraph style than step style
 * @property tags - Selectable filters on what the recipe is
 * @property summary - Long description of the recipe
 * @property description - Short description of the recipe
 */
data class Recipe(
    val name: String,
    val ingredients: List<String>,
    val instructions: String,
    val tags: Set<String>,
    val summary: String,
    val description: String
)
