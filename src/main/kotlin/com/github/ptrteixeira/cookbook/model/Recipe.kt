package com.github.ptrteixeira.cookbook.model

/**
 * Represents a Recipe in the domain model of this project.
 *
 * @property [id] Identifier in the database for this recipe
 * @property [name] Name of this recipe when displayed
 * @property [ingredients] What goes into the recipe?
 * @property [instructions] How do you make this? Interpreted more in paragraph style than step style
 * @property [summary] Long description of the recipe
 * @property [description] Short description of the recipe
 */
data class Recipe(
    val id : Int,
    val name: String,
    val ingredients: List<String>,
    val instructions: String,
    val summary: String,
    val description: String
)
