package com.github.ptrteixeira.cookbook.resources

import com.github.ptrteixeira.cookbook.core.Recipe
import com.github.ptrteixeira.cookbook.core.RecipeEgg
import com.github.ptrteixeira.cookbook.core.User
import com.github.ptrteixeira.cookbook.data.RecipeData
import io.dropwizard.auth.Auth
import org.slf4j.LoggerFactory
import java.util.Optional
import javax.inject.Inject
import javax.ws.rs.Consumes
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
@Consumes(MediaType.APPLICATION_JSON)
internal class RecipesResource @Inject constructor(
        private val recipeData: RecipeData
) {
    @GET
    fun getRecipes(@Auth user: User): List<Recipe> {
        return recipeData.getRecipes(user)
    }

    @POST
    fun createRecipe(@Auth user: User, recipe: RecipeEgg): Recipe {
        val id = recipeData.createRecipeKeys(user, recipe)
        return recipe.toRecipe(id, user)
    }

    @GET
    @Path("/{id}")
    fun getRecipe(@Auth user: User, @PathParam("id") id: Int): Optional<Recipe> {
        return recipeData.getRecipe(user, id)
    }

    @PUT
    @Path("/{id}")
    fun updateRecipe(@Auth user: User, @PathParam("id") id: Int, update: RecipeEgg): Recipe {
        recipeData.patchRecipeKeys(user, id, update)
        return update.toRecipe(id, user)
    }

    @DELETE
    @Path("/{id}")
    fun deleteRecipe(@Auth user: User, @PathParam("id") id: Int) {
        recipeData.deleteRecipe(user, id)
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(RecipesResource::class.java)
    }
}
