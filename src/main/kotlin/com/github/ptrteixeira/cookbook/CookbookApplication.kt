package com.github.ptrteixeira.cookbook

import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.github.ptrteixeira.cookbook.base.DaggerBaseComponent
import com.github.ptrteixeira.cookbook.data.DaggerDataComponent
import com.github.ptrteixeira.cookbook.data.DataModule
import com.github.ptrteixeira.cookbook.resources.DaggerResourcesComponent
import io.dropwizard.Application
import io.dropwizard.db.DataSourceFactory
import io.dropwizard.migrations.MigrationsBundle
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment

class CookbookApplication: Application<CookbookConfiguration>() {
    override fun initialize(bootstrap: Bootstrap<CookbookConfiguration>?) {
        bootstrap?.addBundle(object: MigrationsBundle<CookbookConfiguration>() {
            override fun getDataSourceFactory(configuration: CookbookConfiguration?): DataSourceFactory {
                val database = configuration
                    ?.database
                    ?: throw IllegalStateException("No configuration given!")
                return database
            }
        })

        bootstrap
            ?.objectMapper
            ?.registerKotlinModule()
    }

    override fun run(configuration: CookbookConfiguration, environment: Environment) {
        val baseComponent = DaggerBaseComponent.create()
        val dataComponent = DaggerDataComponent.builder()
            .baseComponent(baseComponent)
            .dataModule(DataModule(configuration, environment))
            .build()
        val resourcesComponent = DaggerResourcesComponent.builder()
            .dataComponent(dataComponent)
            .build()

        environment
            .jersey()
            .register(resourcesComponent.recipesResource())
    }

    override fun getName(): String {
        return "cookbook"
    }
}

fun main(args: Array<String>) {
    CookbookApplication()
        .run(*args)
}
