package com.github.ptrteixeira.cookbook

import io.dropwizard.Configuration

data class CookbookConfiguration(
    val elasticSearchHost: String = "localhost",
    val elasticSearchPort: Int = 9300
): Configuration()
