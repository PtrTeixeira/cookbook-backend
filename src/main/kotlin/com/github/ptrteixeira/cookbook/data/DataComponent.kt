package com.github.ptrteixeira.cookbook.data

import com.codahale.metrics.health.HealthCheck
import com.github.ptrteixeira.cookbook.base.BaseComponent
import dagger.Component

@Component(
        modules = arrayOf(DataModule::class),
        dependencies = arrayOf(BaseComponent::class))
internal interface DataComponent {
    fun recipeData(): RecipeData
    fun healthCheck(): HealthCheck
}
