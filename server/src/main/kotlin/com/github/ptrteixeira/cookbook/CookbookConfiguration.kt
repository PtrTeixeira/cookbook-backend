package com.github.ptrteixeira.cookbook

import com.github.ptrteixeira.cookbook.config.OauthConfiguration
import io.dropwizard.Configuration
import io.dropwizard.db.DataSourceFactory

class CookbookConfiguration(
    val database: DataSourceFactory = DataSourceFactory(),
    val oauthConfig: OauthConfiguration,
    val autoRunMigration: Boolean = false,
    val baseUrl: String = "http://localhost:8080"
) : Configuration()
