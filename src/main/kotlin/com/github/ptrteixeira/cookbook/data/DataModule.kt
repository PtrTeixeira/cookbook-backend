package com.github.ptrteixeira.cookbook.data

import com.github.ptrteixeira.cookbook.CookbookConfiguration
import dagger.Module
import dagger.Provides
import io.dropwizard.setup.Environment
import org.jdbi.v3.core.Jdbi


@Module
internal class DataModule(
    private val configuration: CookbookConfiguration,
    private val environment: Environment
) {
    @Provides
    fun jdbi(): Jdbi {
        return Jdbi
            .create(configuration.database.build(environment.metrics(), "h2"))
            .installPlugins()
            .registerArrayType(String::class.java, "varchar")
    }

    @Provides
    fun recipeData(jdbi: Jdbi): RecipeData
        = jdbi.onDemand(RecipeData::class.java)
}
