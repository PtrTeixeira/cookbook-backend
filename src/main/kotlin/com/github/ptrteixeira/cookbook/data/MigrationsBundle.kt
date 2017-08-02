package com.github.ptrteixeira.cookbook.data

import com.github.ptrteixeira.cookbook.CookbookConfiguration
import io.dropwizard.db.DataSourceFactory
import io.dropwizard.migrations.MigrationsBundle



fun migrationsBundle(migrationFileName: String = "migrations.xml"): MigrationsBundle<CookbookConfiguration> {
    return object : MigrationsBundle<CookbookConfiguration>() {
        override fun getDataSourceFactory(configuration: CookbookConfiguration?): DataSourceFactory {
            val database = configuration
                ?.database
                ?: throw IllegalStateException("No configuration given!")
            return database
        }

        override fun getMigrationsFileName() = migrationFileName
    }
}
