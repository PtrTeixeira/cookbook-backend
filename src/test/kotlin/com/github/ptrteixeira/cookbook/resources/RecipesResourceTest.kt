package com.github.ptrteixeira.cookbook.resources

import com.github.ptrteixeira.cookbook.base.objectMapper
import com.github.ptrteixeira.cookbook.data.RecipeData
import com.github.ptrteixeira.cookbook.mock
import com.github.ptrteixeira.cookbook.model.Recipe
import com.github.ptrteixeira.cookbook.model.RecipeEgg
import com.github.ptrteixeira.cookbook.model.User
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
    private val id = 12345
    private val user = User("test")
    private val sampleRecipe = sampleRecipeEgg
        .toRecipe(id = id, user = user)

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
            .getRecipes(User("test"))
    }

    @Test
    fun whenGetWithIdItPassesIdToDao() {
        resource.target("/recipes/12345")
            .request()
            .get()

        verify(dao)
            .getRecipe(sameTypeAs(user), eq(id))
    }

    @Test
    fun whenDeleteItPassesIdToDao() {
        resource.target("/recipes/12345")
            .request()
            .delete()

        verify(dao)
            .deleteRecipe(sameTypeAs(user), eq(id))
    }

    @Test
    fun whenCreateItReturnsRecipeWithId() {
        given(dao.createRecipeKeys(User("test"), sampleRecipeEgg))
            .willReturn(id)

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

        verify(dao)
            .patchRecipeKeys(sameTypeAs(user), eq(id), eq(sampleRecipeEgg))
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

inline fun <reified T: Any> sameTypeAs(instance: T): T {
    Mockito.any(T::class.java)
    return instance
}

fun <T> eq(actual: T): T {
    Mockito.eq(actual)
    return actual
}
