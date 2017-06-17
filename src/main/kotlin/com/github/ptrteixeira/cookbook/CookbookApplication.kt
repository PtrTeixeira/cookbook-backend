package com.github.ptrteixeira.cookbook

import com.github.ptrteixeira.cookbook.base.DaggerBaseComponent
import com.github.ptrteixeira.cookbook.data.DaggerDataComponent
import com.github.ptrteixeira.cookbook.data.DataModule
import com.github.ptrteixeira.cookbook.resources.DaggerResourcesComponent
import io.dropwizard.Application
import io.dropwizard.setup.Environment

class CookbookApplication: Application<CookbookConfiguration>() {
    override fun run(configuration: CookbookConfiguration, environment: Environment) {
        val baseComponent = DaggerBaseComponent.create()
        val dataComponent = DaggerDataComponent.builder()
            .baseComponent(baseComponent)
            .dataModule(DataModule(configuration))
            .build()
        val resourcesComponent = DaggerResourcesComponent.builder()
            .dataComponent(dataComponent)
            .build()

        environment
            .jersey()
            .register(resourcesComponent.recipesResource())

        environment
            .lifecycle()
            .manage(dataComponent.managedTransportClient())
    }

    override fun getName(): String {
        return "cookbook"
    }
}

fun main(args: Array<String>) {
    CookbookApplication()
        .run(*args)
}
