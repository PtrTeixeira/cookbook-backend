package com.github.ptrteixeira.cookbook.resources

import com.github.ptrteixeira.cookbook.auth.TrivialAuth
import com.github.ptrteixeira.cookbook.base.objectMapper
import com.github.ptrteixeira.cookbook.data.RecipeData
import com.github.ptrteixeira.cookbook.mock
import com.github.ptrteixeira.cookbook.model.Recipe
import com.github.ptrteixeira.cookbook.model.RecipeEgg
import com.github.ptrteixeira.cookbook.model.User
import io.dropwizard.auth.AuthDynamicFeature
import io.dropwizard.auth.AuthValueFactoryProvider
import io.dropwizard.auth.basic.BasicCredentialAuthFilter
import io.dropwizard.testing.junit.ResourceTestRule
import org.assertj.core.api.Assertions.assertThat
import org.glassfish.jersey.test.grizzly.GrizzlyWebTestContainerFactory
import org.junit.Before
import org.junit.ClassRule
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mockito
import org.mockito.Mockito.verify
import java.util.Base64
import javax.ws.rs.client.Entity
import javax.ws.rs.core.MediaType

class RecipesResourceTest {
    private val encoder = Base64.getEncoder()
    private val sampleRecipeEgg = RecipeEgg(
        name="Chocolate Chip Cookies",
        ingredients = listOf("Chocolate", "Chips", "Cookies"),
        instructions = "Mix",
        summary = "They were invented right here in Massachusetts, you know",
        description = "They're chocolate chip cookies. Waddya want?"
    )
    private val id = 12345
    private val user = User("test")
    private val userKey = String(encoder.encode("${user.id}:password".toByteArray()))
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
            .header("Authorization", "Basic $userKey")
            .get()

        verify(dao)
            .getRecipes(user)
    }

    @Test
    fun whenGetWithIdItPassesIdToDao() {
        resource.target("/recipes/12345")
            .request()
            .header("Authorization", "Basic $userKey")
            .get()

        verify(dao)
            .getRecipe(user, id)
    }

    @Test
    fun whenDeleteItPassesIdToDao() {
        resource.target("/recipes/12345")
            .request()
            .header("Authorization", "Basic $userKey")
            .delete()

        verify(dao)
            .deleteRecipe(user, id)
    }

    @Test
    fun whenCreateItReturnsRecipeWithId() {
        given(dao.createRecipeKeys(User("test"), sampleRecipeEgg))
            .willReturn(id)

        val response = resource.target("/recipes")
            .request()
            .header("Authorization", "Basic $userKey")
            .post(Entity.entity(sampleRecipeEgg, MediaType.APPLICATION_JSON), Recipe::class.java)

        assertThat(response)
            .isEqualTo(sampleRecipe)
    }

    @Test
    fun whenUpdateItModifiesTheCorrectRecipe() {
        resource.target("/recipes/12345")
            .request()
            .header("Authorization", "Basic $userKey")
            .put(Entity.entity(sampleRecipeEgg, MediaType.APPLICATION_JSON), Recipe::class.java)

        verify(dao)
            .patchRecipeKeys(user, id, sampleRecipeEgg)
    }

    companion object {
        val dao: RecipeData = mock()

        @JvmStatic
        @get:ClassRule
        val resource: ResourceTestRule = ResourceTestRule.builder()
            .setTestContainerFactory(GrizzlyWebTestContainerFactory())
            .addProvider(AuthDynamicFeature(BasicCredentialAuthFilter.Builder<User>()
                .setAuthenticator(TrivialAuth())
                .buildAuthFilter()
            ))
            .addProvider(AuthValueFactoryProvider.Binder<User>(User::class.java))
            .addResource(RecipesResource(dao))
            .setMapper(objectMapper())
            .build()
    }
}
