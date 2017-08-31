package com.github.ptrteixeira.cookbook.data

import com.github.ptrteixeira.cookbook.jdbi
import com.github.ptrteixeira.cookbook.model.RecipeEgg
import com.github.ptrteixeira.cookbook.model.User
import org.assertj.core.api.Assertions.assertThat
import org.jdbi.v3.sqlobject.kotlin.onDemand
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory

class RecipeDataTest {
    private val ID = 0
    private val USER = User("test-user")

    @Test
    fun itReturnsMissingRecipesAsAbsent() {
        val result = recipeDao.getRecipe(USER, ID)
        assertThat(result)
            .isEmpty()
    }

    @Test
    fun whenNoRecipesItReturnsEmptyList() {
        val result = recipeDao.getRecipes(USER)

        assertThat(result)
            .isEmpty()
    }

    @Test
    fun itAllowsRecipesToBeCreated() {
        val id = recipeDao.createRecipeKeys(USER, sampleRecipeEgg)
        val recipe = recipeDao.getRecipe(USER, id)
            .get()

        assertThat(recipe)
            .isEqualTo(sampleRecipeEgg.toRecipe(id, USER))
    }

    @Test
    fun whenRecipesAddedReturnedListContainsRecipes() {
        recipeDao.createRecipeKeys(USER, sampleRecipeEgg)
        val allRecipes = recipeDao.getRecipes(USER)

        assertThat(allRecipes)
            .hasSize(1)
            .extracting<String> { it.name }
            .containsExactly(sampleRecipeEgg.name)
    }

    @Test
    fun itAllowsRecipesToBeDeleted() {
        val id = recipeDao.createRecipeKeys(USER, sampleRecipeEgg)

        recipeDao.deleteRecipe(USER, id)

        val getResult = recipeDao.getRecipe(USER, id)
        assertThat(getResult)
            .isEmpty()
    }

    @Test
    fun itAllowsRecipesToBeUpdated() {
        val id = recipeDao.createRecipeKeys(USER, sampleRecipeEgg)
        val newIngredients = listOf(
            "Eggs", "White Sugar", "Brown Sugar",
            "Butter", "Flour", "Chocolate Chips"
        )

        val updated = sampleRecipeEgg.copy(ingredients = newIngredients)
        recipeDao.patchRecipeKeys(USER, id, updated)
        val getResult = recipeDao.getRecipe(USER, id)

        assertThat(getResult)
            .contains(updated.toRecipe(id, USER))
        assertThat(getResult.get().ingredients)
            .containsExactlyInAnyOrder(*newIngredients.toTypedArray())
    }

    @Test
    fun itOnlyListsRecipesForTheGivenUser() {
        recipeDao.createRecipeKeys(User("user-1"), sampleRecipeEgg)

        assertThat(recipeDao.getRecipes(User("user-2")))
            .isEmpty()
        assertThat(recipeDao.getRecipes(User("user-1")))
            .isNotEmpty()
    }

    @Test
    fun itForbidsAccessToAnotherUsersRecipes() {
        val id = recipeDao.createRecipeKeys(User("user-1"), sampleRecipeEgg)

        assertThat(recipeDao.getRecipe(User("user-2"), id))
            .isEmpty()
        assertThat(recipeDao.getRecipe(User("user-1"), id))
            .isNotEmpty()
    }

    @Test
    fun itForbidsUpdatesToAnotherUsersRecipes() {
        val id = recipeDao.createRecipeKeys(User("user-1"), sampleRecipeEgg)

        recipeDao.deleteRecipe(User("user-2"), id)

        assertThat(recipeDao.getRecipe(User("user-1"), id))
            .isNotEmpty()
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
