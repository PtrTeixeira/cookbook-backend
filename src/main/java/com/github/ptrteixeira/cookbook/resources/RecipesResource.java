package com.github.ptrteixeira.cookbook.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.ptrteixeira.cookbook.model.PublicError;
import com.github.ptrteixeira.cookbook.model.Recipe;
import com.github.ptrteixeira.cookbook.model.RecipeEgg;
import io.vertx.ext.web.RoutingContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class RecipesResource {
  private final ObjectMapper mapper;
  private final Function0<List<Recipe>> getRecipes;
  private final Function1<String, Optional<Recipe>> getRecipe;
  private final Function1<Recipe, String> createRecipe;
  private final Function2<String, RecipeEgg, Recipe> modifyRecipe;
  private final Function1<String, Boolean> deleteRecipe;

  @Inject
  RecipesResource(ObjectMapper mapper, Function0<List<Recipe>> getRecipes, Function1<String, Optional<Recipe>> getRecipe, Function1<Recipe, String> createRecipe, Function2<String, RecipeEgg, Recipe> modifyRecipe, Function1<String, Boolean> deleteRecipe) {
    this.mapper = mapper;
    this.getRecipes = getRecipes;
    this.getRecipe = getRecipe;
    this.createRecipe = createRecipe;
    this.modifyRecipe = modifyRecipe;
    this.deleteRecipe = deleteRecipe;
  }

  public void getRecipesResource(RoutingContext context) throws IOException {
    context.response()
           .putHeader("content-type", "application/json")
           .end(mapper.writeValueAsString(getRecipes.invoke()));
  }

  public void getRecipeResource(RoutingContext context) throws IOException {
    String id = context.request().getParam("id");
    Optional<Recipe> maybeRecipe = getRecipe.invoke(id);

    if (maybeRecipe.isPresent()) {
      context.response()
             .putHeader("content-type", "application/json")
             .end(mapper.writeValueAsString(maybeRecipe.get()));
    } else {
      context.response()
             .setStatusCode(404)
             .end(mapper.writeValueAsString(notFound(id)));
    }
  }

  public void createRecipeResource(RoutingContext context) throws IOException {
    Recipe body = mapper.readValue(context.getBodyAsString(), Recipe.class);
    String savedId = createRecipe.invoke(body);

    context.response()
           .setStatusCode(201)
           .end(savedId);
  }

  public void patchRecipeResource(RoutingContext context) throws IOException {
    RecipeEgg body = mapper.readValue(context.getBodyAsString(), RecipeEgg.class);
    String id = context.request().getParam("id");
    Recipe built = modifyRecipe.invoke(id, body);

    context.response()
           .setStatusCode(200)
           .putHeader("content-type", "application/json")
           .end(mapper.writeValueAsString(built));
  }

  public void deleteRecipeResource(RoutingContext context) throws Exception {
    String id = context.request().getParam("id");
    if (deleteRecipe.invoke(id)) {
      context.response()
             .setStatusCode(204)
             .end();
    } else {
      context.response()
             .setStatusCode(404)
             .end(mapper.writeValueAsString(notFound(id)));
    }
  }

  private PublicError notFound(String id) {
    return new PublicError(
        "RecipeNotFound",
        String.format("Could not locate recipe with ID %s", id),
        "...");
  }
}
