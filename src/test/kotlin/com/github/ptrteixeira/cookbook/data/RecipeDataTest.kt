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

    @Test
    fun itReturnsMissingRecipesAsAbsent() {
        val result = recipeDao.getRecipe(0)
        assertThat(result)
            .isEmpty()
    }

    @Test
    fun whenNoRecipesItReturnsEmptyList() {
        val result = recipeDao.getRecipes()

        assertThat(result)
            .isEmpty()
    }

    @Test
    fun itAllowsRecipesToBeCreated() {
        val result = recipeDao.createRecipe(sampleRecipeEgg)
        assertThat(recipeDao.getRecipe(result.id))
            .contains(result)
    }

    @Test
    fun whenRecipesAddedReturnedListContainsRecipes() {
        recipeDao.createRecipe(sampleRecipeEgg)
        val allRecipes = recipeDao.getRecipes()
        assertThat(allRecipes)
            .hasSize(1)
            .extracting<String> { it.name }
            .containsExactly(sampleRecipeEgg.name)
    }

    @Test
    fun itAllowsRecipesToBeDeleted() {
        val createResult = recipeDao.createRecipe(sampleRecipeEgg)

        recipeDao.deleteRecipe(createResult.id)

        val getResult = recipeDao.getRecipe(createResult.id)
        assertThat(getResult)
            .isEmpty()
    }

    @Test
    fun itAllowsRecipesToBeUpdated() {
        val createResult = recipeDao.createRecipe(sampleRecipeEgg)
        val newIngredients = listOf(
            "Eggs", "White Sugar", "Brown Sugar",
            "Butter", "Flour", "Chocolate Chips"
        )

        val updated = sampleRecipeEgg.copy(ingredients = newIngredients)
        val patchResult = recipeDao.patchRecipe(createResult.id, updated)
        val getResult = recipeDao.getRecipe(createResult.id)

        assertThat(getResult)
            .contains(patchResult)
        assertThat(patchResult.ingredients)
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
