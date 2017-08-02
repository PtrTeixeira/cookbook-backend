package com.github.ptrteixeira.cookbook

import io.dropwizard.Configuration
import io.dropwizard.db.DataSourceFactory


class CookbookConfiguration: Configuration() {
    var database: DataSourceFactory = DataSourceFactory()
}
