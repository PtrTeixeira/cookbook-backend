package com.github.ptrteixeira.cookbook.data

import com.github.ptrteixeira.cookbook.model.Recipe
import com.github.ptrteixeira.cookbook.model.RecipeEgg
import java.util.*

interface RecipeData {
    fun getRecipes(): List<Recipe>
    fun getRecipe(id: String): Optional<Recipe>
    fun createRecipe(recipe: Recipe): String
    fun deleteRecipe(id: String): Boolean
    fun patchRecipe(id: String, recipe: RecipeEgg): Recipe
}
