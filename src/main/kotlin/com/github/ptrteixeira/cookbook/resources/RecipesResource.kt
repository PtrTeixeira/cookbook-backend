package com.github.ptrteixeira.cookbook.resources

import com.github.ptrteixeira.cookbook.data.RecipeData
import com.github.ptrteixeira.cookbook.model.Recipe
import com.github.ptrteixeira.cookbook.model.RecipeEgg
import com.github.ptrteixeira.cookbook.model.User
import java.util.Optional
import javax.inject.Inject
import javax.ws.rs.DELETE
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.PUT
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/recipes")
@Produces(MediaType.APPLICATION_JSON)
internal class RecipesResource @Inject constructor(
        private val recipeData: RecipeData
) {
    private val FAKE_USER = User("test")

    @GET
    fun getRecipes(): List<Recipe> {
        return recipeData.getRecipes(FAKE_USER.id)
    }

    @POST
    fun createRecipe(recipe: RecipeEgg): Recipe {
        val id = recipeData.createRecipeKeys(FAKE_USER.id, recipe)
        return recipe.toRecipe(id, FAKE_USER.id)
    }

    @GET
    @Path("/{id}")
    fun getRecipe(@PathParam("id") id: Int): Optional<Recipe> {
        return recipeData.getRecipe(FAKE_USER.id, id)
    }

    @PUT
    @Path("/{id}")
    fun updateRecipe(@PathParam("id") id: Int, update: RecipeEgg): Recipe {
        recipeData.patchRecipeKeys(FAKE_USER.id, id, update)
        return update.toRecipe(id, FAKE_USER.id)
    }

    @DELETE
    @Path("/{id}")
    fun deleteRecipe(@PathParam("id") id: Int) {
        recipeData.deleteRecipe(FAKE_USER.id, id)
    }
}
