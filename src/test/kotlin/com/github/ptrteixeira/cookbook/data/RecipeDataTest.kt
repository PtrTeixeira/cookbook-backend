package com.github.ptrteixeira.cookbook.data

import com.github.ptrteixeira.cookbook.jdbi
import com.github.ptrteixeira.cookbook.model.RecipeEgg
import org.assertj.core.api.Assertions.assertThat
import org.jdbi.v3.sqlobject.kotlin.onDemand
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory

class RecipeDataTest {
    private val ID = 0
    private val USER_ID = "test-user"

    @Test
    fun itReturnsMissingRecipesAsAbsent() {
        val result = recipeDao.getRecipe(USER_ID, ID)
        assertThat(result)
            .isEmpty()
    }

    @Test
    fun whenNoRecipesItReturnsEmptyList() {
        val result = recipeDao.getRecipes(USER_ID)

        assertThat(result)
            .isEmpty()
    }

    @Test
    fun itAllowsRecipesToBeCreated() {
        val id = recipeDao.createRecipeKeys(USER_ID, sampleRecipeEgg)
        val recipe = recipeDao.getRecipe(USER_ID, id)
            .get()

        assertThat(recipe)
            .isEqualTo(sampleRecipeEgg.toRecipe(id, USER_ID))
    }

    @Test
    fun whenRecipesAddedReturnedListContainsRecipes() {
        recipeDao.createRecipeKeys(USER_ID, sampleRecipeEgg)
        val allRecipes = recipeDao.getRecipes(USER_ID)

        assertThat(allRecipes)
            .hasSize(1)
            .extracting<String> { it.name }
            .containsExactly(sampleRecipeEgg.name)
    }

    @Test
    fun itAllowsRecipesToBeDeleted() {
        val id = recipeDao.createRecipeKeys(USER_ID, sampleRecipeEgg)

        recipeDao.deleteRecipe(USER_ID, id)

        val getResult = recipeDao.getRecipe(USER_ID, id)
        assertThat(getResult)
            .isEmpty()
    }

    @Test
    fun itAllowsRecipesToBeUpdated() {
        val id = recipeDao.createRecipeKeys(USER_ID, sampleRecipeEgg)
        val newIngredients = listOf(
            "Eggs", "White Sugar", "Brown Sugar",
            "Butter", "Flour", "Chocolate Chips"
        )

        val updated = sampleRecipeEgg.copy(ingredients = newIngredients)
        recipeDao.patchRecipeKeys(USER_ID, id, updated)
        val getResult = recipeDao.getRecipe(USER_ID, id)

        assertThat(getResult)
            .contains(updated.toRecipe(id, USER_ID))
        assertThat(getResult.get().ingredients)
            .containsExactlyInAnyOrder(*newIngredients.toTypedArray())
    }

    @BeforeEach
    fun truncateTable() {
        dbi.withHandle<Unit, Nothing> {
            it.createUpdate("DELETE FROM RECIPES")
                .execute()
        }
    }


    companion object {
        private val logger = LoggerFactory.getLogger(RecipeDataTest::class.java)
        private val dbi = jdbi()
        private val recipeDao = dbi.onDemand<RecipeData>()

        private val sampleRecipeEgg = RecipeEgg(
            name = "Chocolate Chip Cookies",
            ingredients = listOf("Chocolate", "Chips", "Cookies"),
            instructions = "Mix",
            summary = "They were invented right here in Massachusetts, you know",
            description = "They're chocolate chip cookies. Waddya want?"
        )

        @BeforeAll
        @JvmStatic
        fun migrate() {
            logger.info("Running migrations before DaoTest")
            com.github.ptrteixeira.cookbook.migrate(dbi)
        }
    }
}
