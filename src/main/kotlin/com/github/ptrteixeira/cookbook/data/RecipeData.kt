package com.github.ptrteixeira.cookbook.data

import com.github.ptrteixeira.cookbook.model.Recipe
import com.github.ptrteixeira.cookbook.model.RecipeEgg
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys
import org.jdbi.v3.sqlobject.statement.SqlQuery
import org.jdbi.v3.sqlobject.statement.SqlUpdate
import java.util.Optional

interface RecipeData {
    @SqlQuery("""
SELECT `id`, `name`, `ingredients`, `instructions`, `summary`, `description`
FROM RECIPES
""")
    fun getRecipes(): List<Recipe>

    @SqlQuery("""
SELECT `id`, `name`, `ingredients`, `instructions`, `summary`, `description`
FROM RECIPES
WHERE id = :id
""")
    fun getRecipe(id: Int): Optional<Recipe>

    @GetGeneratedKeys
    @SqlUpdate("""
INSERT INTO RECIPES (`name`, `ingredients`, `instructions`, `summary`, `description`)
VALUES (:recipe.name, :recipe.ingredients, :recipe.instructions, :recipe.summary, :recipe.description)
    """)
    fun createRecipeKeys(recipe: RecipeEgg): Int

    @SqlUpdate("DELETE FROM RECIPES WHERE id = :id")
    fun deleteRecipe(id: Int)

    @SqlUpdate("""
UPDATE RECIPES
SET
  `name` = :recipe.name,
  `ingredients` = :recipe.ingredients,
  `instructions` = :recipe.instructions,
  `summary` = :recipe.summary,
  `description` = :recipe.description
WHERE
  `id` = :id
    """)
    fun patchRecipeKeys(id: Int, recipe: RecipeEgg)

    fun createRecipe(recipe: RecipeEgg): Recipe {
        val key = createRecipeKeys(recipe)
        return recipe.toRecipe(key)
    }

    fun patchRecipe(id: Int, recipe: RecipeEgg): Recipe {
        patchRecipeKeys(id, recipe)
        return recipe.toRecipe(id)
    }
}
