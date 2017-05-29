package com.github.ptrteixeira.cookbook.integration

import com.github.ptrteixeira.cookbook.model.Recipe
import com.github.ptrteixeira.cookbook.model.RecipeEgg
import dagger.Module
import dagger.Provides
import org.elasticsearch.client.transport.TransportClient
import org.elasticsearch.common.settings.Settings
import org.elasticsearch.transport.client.PreBuiltTransportClient
import java.util.Arrays
import java.util.Optional

@Module
internal class MockDataModule {

    @Provides
    fun elasticSearchClient(): TransportClient {
        return PreBuiltTransportClient(Settings.EMPTY)
    }

    @Provides
    fun providesGetRecipes(): Function0<List<Recipe>> {
        return { listOf(MOCK_RECIPE) }
    }

    @Provides
    fun providesGetRecipe(): Function1<String, Optional<Recipe>> {
        return { id ->
            when (id) {
                "00000" -> Optional.of(MOCK_RECIPE)
                else -> Optional.empty()
            }
        }
    }

    @Provides
    fun providesCreateRecipe(): Function1<Recipe, String> {
        return { "00000" }
    }

    @Provides
    fun providesDeleteRecipe(): Function1<String, Boolean> {
        return { id ->
            when (id) {
                "00000" -> true
                else -> false
            }
        }
    }

    @Provides
    fun providesPatchRecipe(): Function2<String, RecipeEgg, Recipe> {
        return { _, egg -> egg.merge(MOCK_RECIPE) }
    }

    companion object {
        private val MOCK_RECIPE = Recipe(
                "Chocolate Chip Cookies",
                Arrays.asList("Chocolate", "Chips", "Cookies"),
                "mix",
                emptySet<String>(),
                "Who doesn't like chocolate chip cookies?",
                "They were invented right here in Massachusetts, you know."
        )
    }
}
