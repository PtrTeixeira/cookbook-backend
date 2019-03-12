package com.github.ptrteixeira.cookbook.config

import io.dropwizard.Configuration
import io.dropwizard.db.DataSourceFactory

class CookbookConfiguration(
    val database: DataSourceFactory = DataSourceFactory(),
    val auth: AuthConfiguration,
    val autoRunMigration: Boolean = false,
    val baseUrl: String = "http://localhost:8080"
) : Configuration()
