package com.github.ptrteixeira.cookbook.resources

import com.github.ptrteixeira.cookbook.data.DataComponent
import dagger.Component

@Component(dependencies = arrayOf(DataComponent::class))
internal interface ResourcesComponent {
    fun recipesResource(): RecipesResource
}
