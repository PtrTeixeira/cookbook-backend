package com.github.ptrteixeira.cookbook.resources

import com.github.ptrteixeira.cookbook.data.RecipeData
import com.github.ptrteixeira.cookbook.model.Recipe
import com.github.ptrteixeira.cookbook.model.RecipeEgg
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

    @GET
    fun getRecipes(): List<Recipe> {
        return recipeData.getRecipes()
    }

    @POST
    fun createRecipe(recipe: Recipe): String {
        return recipeData.createRecipe(recipe)
    }

    @GET
    @Path("/{id}")
    fun getRecipe(@PathParam("id") id: String): Optional<Recipe> {
        return recipeData.getRecipe(id)
    }

    @PUT
    @Path("/{id}")
    fun updateRecipe(@PathParam("id") id: String, update: RecipeEgg): Recipe {
        return recipeData.patchRecipe(id, update)
    }

    @DELETE
    @Path("/{id}")
    fun deleteRecipe(@PathParam("id") id: String): Boolean {
        return recipeData.deleteRecipe(id)
    }
}
