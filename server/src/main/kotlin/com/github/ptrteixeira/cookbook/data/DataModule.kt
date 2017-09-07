package com.github.ptrteixeira.cookbook.data

import com.codahale.metrics.MetricRegistry
import com.codahale.metrics.health.HealthCheck
import com.github.ptrteixeira.cookbook.base.Raw
import com.google.common.util.concurrent.MoreExecutors
import dagger.Module
import dagger.Provides
import io.dropwizard.db.DataSourceFactory
import io.dropwizard.util.Duration
import org.jdbi.v3.core.Jdbi
import java.util.concurrent.ExecutorService

@Module
internal class DataModule {
    @Provides
    @Raw
    fun jdbi(database: DataSourceFactory, metrics: MetricRegistry): Jdbi {
        return Jdbi
            .create(database.build(metrics, "h2"))
    }

    @Provides
    fun configuredJdbi(@Raw jdbi: Jdbi): Jdbi {
        return jdbi
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
    fun healthCheck(jdbi: Jdbi, executor: ExecutorService, database: DataSourceFactory): HealthCheck {
        val duration = database.validationQueryTimeout
        val query = database.validationQuery

        return if (duration.isPresent) {
            Jdbi3HealthCheck(jdbi, query, executor, duration.get())
        } else {
            Jdbi3HealthCheck(jdbi, query, executor, Duration.seconds(0))
        }
    }
}
