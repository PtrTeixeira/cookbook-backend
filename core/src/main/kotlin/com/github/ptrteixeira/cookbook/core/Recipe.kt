package com.github.ptrteixeira.cookbook.core

/**
 * Represents a Recipe in the domain com.github.ptrteixeira.cookbook.model of this project.
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
    val userId: String,
    val name: String = "",
    val ingredients: List<String> = listOf(),
    val instructions: String = "",
    val summary: String = "",
    val description: String = ""
)
