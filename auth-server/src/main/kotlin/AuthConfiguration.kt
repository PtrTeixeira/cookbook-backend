package com.github.ptrteixeira.cookbook.auth

import io.dropwizard.Configuration


class AuthConfiguration(
        val googleAppToken: String,
        val autoRunMigration: Boolean = false
) : Configuration()