package com.github.ptrteixeira.cookbook.data

import com.github.ptrteixeira.cookbook.model.Recipe
import com.github.ptrteixeira.cookbook.model.RecipeEgg
import com.github.ptrteixeira.cookbook.model.User
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys
import org.jdbi.v3.sqlobject.statement.SqlQuery
import org.jdbi.v3.sqlobject.statement.SqlUpdate
import java.util.Optional

interface RecipeData {
    @SqlQuery("""
SELECT `userId`, `id`, `name`, `ingredients`, `instructions`, `summary`, `description`
FROM RECIPES
WHERE `userId` = :user.id
""")
    fun getRecipes(user: User): List<Recipe>

    @SqlQuery("""
SELECT `userId`, `id`, `name`, `ingredients`, `instructions`, `summary`, `description`
FROM RECIPES
WHERE `id` = :id AND `userId` = :user.id
""")
    fun getRecipe(user: User, id: Int): Optional<Recipe>

    @GetGeneratedKeys
    @SqlUpdate("""
INSERT INTO RECIPES (`userId`, `name`, `ingredients`, `instructions`, `summary`, `description`)
VALUES (:user.id, :recipe.name, :recipe.ingredients, :recipe.instructions, :recipe.summary, :recipe.description)
    """)
    fun createRecipeKeys(user: User, recipe: RecipeEgg): Int

    @SqlUpdate("DELETE FROM RECIPES WHERE id = :id AND userId = :user.id")
    fun deleteRecipe(user: User, id: Int)

    @SqlUpdate("""
UPDATE RECIPES
SET
  `name` = :recipe.name,
  `ingredients` = :recipe.ingredients,
  `instructions` = :recipe.instructions,
  `summary` = :recipe.summary,
  `description` = :recipe.description
WHERE `id` = :id AND `userId` = :user.id
    """)
    fun patchRecipeKeys(user: User, id: Int, recipe: RecipeEgg)
}
