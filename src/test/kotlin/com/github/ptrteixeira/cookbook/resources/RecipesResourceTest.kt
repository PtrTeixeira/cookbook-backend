package com.github.ptrteixeira.cookbook.resources

import com.github.ptrteixeira.cookbook.base.objectMapper
import com.github.ptrteixeira.cookbook.data.RecipeData
import com.github.ptrteixeira.cookbook.mock
import com.github.ptrteixeira.cookbook.model.Recipe
import com.github.ptrteixeira.cookbook.model.RecipeEgg
import io.dropwizard.testing.junit.ResourceTestRule
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.ClassRule
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mockito
import org.mockito.Mockito.verify
import javax.ws.rs.client.Entity
import javax.ws.rs.core.MediaType

class RecipesResourceTest {
    private val sampleRecipeEgg = RecipeEgg(
        name="Chocolate Chip Cookies",
        ingredients = listOf("Chocolate", "Chips", "Cookies"),
        instructions = "Mix",
        summary = "They were invented right here in Massachusetts, you know",
        description = "They're chocolate chip cookies. Waddya want?"
    )
    private val sampleRecipe = sampleRecipeEgg
        .toRecipe(1)

    @Before
    fun setUp() {
        Mockito.reset(dao)
    }

    @Test
    fun whenDatabaseIsEmptyResultIsEmpty() {
        resource.target("/recipes")
            .request()
            .get()

        verify(dao)
            .getRecipes()
    }

    @Test
    fun whenGetWithIdItPassesIdToDao() {
        resource.target("/recipes/12345")
            .request()
            .get()

        verify(dao)
            .getRecipe(12345)
    }

    @Test
    fun whenDeleteItPassesIdToDao() {
        resource.target("/recipes/12345")
            .request()
            .delete()

        verify(dao)
            .deleteRecipe(12345)
    }

    @Test
    fun whenCreateItReturnsRecipeWithId() {
        given(dao.createRecipe(sampleRecipeEgg))
            .willReturn(sampleRecipe)

        val response = resource.target("/recipes")
            .request()
            .post(Entity.entity(sampleRecipeEgg, MediaType.APPLICATION_JSON), Recipe::class.java)

        assertThat(response)
            .isEqualTo(sampleRecipe)
    }

    @Test
    fun whenUpdateItModifiesTheCorrectRecipe() {
        resource.target("/recipes/12345")
            .request()
            .put(Entity.entity(sampleRecipeEgg, MediaType.APPLICATION_JSON), Recipe::class.java)

        verify(dao).patchRecipe(12345, sampleRecipeEgg)
    }

    companion object {
        val dao: RecipeData = mock()

        @JvmStatic
        @get:ClassRule
        val resource: ResourceTestRule = ResourceTestRule.builder()
            .addResource(RecipesResource(dao))
            .setMapper(objectMapper())
            .build()
    }
}
