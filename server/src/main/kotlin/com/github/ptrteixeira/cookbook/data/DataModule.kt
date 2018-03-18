package com.github.ptrteixeira.cookbook.data

import com.google.common.util.concurrent.MoreExecutors
import dagger.Module
import dagger.Provides
import io.dropwizard.db.DataSourceFactory
import io.dropwizard.jdbi3.JdbiFactory
import io.dropwizard.setup.Environment
import org.jdbi.v3.core.Jdbi
import java.util.concurrent.ExecutorService

@Module
internal class DataModule {
    @Provides
    fun jdbi(environment: Environment, database: DataSourceFactory): Jdbi {
        val factory = JdbiFactory()
        return factory
                .build(environment, database, "h2")
                .installPlugins()
                .registerArrayType(String::class.java, "varchar")
    }

    @Provides
    fun databaseHealthCheckExecutor(): ExecutorService
        = MoreExecutors.newDirectExecutorService()

    @Provides
    fun recipeData(jdbi: Jdbi): RecipeData
        = jdbi.onDemand(RecipeData::class.java)
}
