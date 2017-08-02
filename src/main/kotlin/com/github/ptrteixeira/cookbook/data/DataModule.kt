package com.github.ptrteixeira.cookbook.data

import com.codahale.metrics.health.HealthCheck
import com.github.ptrteixeira.cookbook.CookbookConfiguration
import com.google.common.util.concurrent.MoreExecutors
import dagger.Module
import dagger.Provides
import io.dropwizard.setup.Environment
import io.dropwizard.util.Duration
import org.jdbi.v3.core.Jdbi
import java.util.concurrent.ExecutorService


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
    fun databaseHealthCheckExecutor(): ExecutorService
        = MoreExecutors.newDirectExecutorService()

    @Provides
    fun recipeData(jdbi: Jdbi): RecipeData
        = jdbi.onDemand(RecipeData::class.java)

    @Provides
    fun healthCheck(jdbi: Jdbi, executor: ExecutorService): HealthCheck {
        val duration = configuration.database.validationQueryTimeout
        val query = configuration.database.validationQuery

        return if (duration.isPresent) {
            Jdbi3HealthCheck(jdbi, query, executor, duration.get())
        } else {
            Jdbi3HealthCheck(jdbi, query, executor, Duration.seconds(0))
        }
    }
}
