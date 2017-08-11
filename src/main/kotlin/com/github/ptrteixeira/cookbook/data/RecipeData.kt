package com.github.ptrteixeira.cookbook.data

import com.github.ptrteixeira.cookbook.model.Recipe
import com.github.ptrteixeira.cookbook.model.RecipeEgg
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys
import org.jdbi.v3.sqlobject.statement.SqlQuery
import org.jdbi.v3.sqlobject.statement.SqlUpdate
import java.util.Optional

interface RecipeData {
    @SqlQuery("""
SELECT `userId`, `id`, `name`, `ingredients`, `instructions`, `summary`, `description`
FROM RECIPES
WHERE `userId` = :userId
""")
    fun getRecipes(userId: String): List<Recipe>

    @SqlQuery("""
SELECT `userId`, `id`, `name`, `ingredients`, `instructions`, `summary`, `description`
FROM RECIPES
WHERE `id` = :id AND `userId` = :userId
""")
    fun getRecipe(userId: String, id: Int): Optional<Recipe>

    @GetGeneratedKeys
    @SqlUpdate("""
INSERT INTO RECIPES (`userId`, `name`, `ingredients`, `instructions`, `summary`, `description`)
VALUES (:userId, :recipe.name, :recipe.ingredients, :recipe.instructions, :recipe.summary, :recipe.description)
    """)
    fun createRecipeKeys(userId: String, recipe: RecipeEgg): Int

    @SqlUpdate("DELETE FROM RECIPES WHERE id = :id AND userId = :userId")
    fun deleteRecipe(userId: String, id: Int)

    @SqlUpdate("""
UPDATE RECIPES
SET
  `name` = :recipe.name,
  `ingredients` = :recipe.ingredients,
  `instructions` = :recipe.instructions,
  `summary` = :recipe.summary,
  `description` = :recipe.description
WHERE `id` = :id AND `userId` = :userId
    """)
    fun patchRecipeKeys(userId: String, id: Int, recipe: RecipeEgg)
}
