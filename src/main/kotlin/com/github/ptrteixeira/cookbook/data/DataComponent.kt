package com.github.ptrteixeira.cookbook.data

import com.github.ptrteixeira.cookbook.base.BaseComponent
import com.github.ptrteixeira.cookbook.model.Recipe
import com.github.ptrteixeira.cookbook.model.RecipeEgg
import dagger.Component
import org.elasticsearch.client.transport.TransportClient
import java.util.Optional

@Component(
        modules = arrayOf(DataModule::class),
        dependencies = arrayOf(BaseComponent::class))
interface DataComponent {
    fun elasticSearchClient(): TransportClient
    fun getRecipes(): () -> List<Recipe>
    fun getRecipe(): (String) -> Optional<Recipe>
    fun createRecipe(): (Recipe) -> String
    fun deleteRecipe(): (String) -> Boolean
    fun updateRecipe(): (String, RecipeEgg) -> Recipe
}
