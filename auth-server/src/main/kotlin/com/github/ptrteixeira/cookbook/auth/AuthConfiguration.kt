package com.github.ptrteixeira.cookbook.auth

import io.dropwizard.Configuration
import io.dropwizard.db.DataSourceFactory


class AuthConfiguration(
        val database: DataSourceFactory = DataSourceFactory(),
        val googleAppToken: String,
        val autoRunMigration: Boolean = false,
        val signingKey: String = ""
) : Configuration()