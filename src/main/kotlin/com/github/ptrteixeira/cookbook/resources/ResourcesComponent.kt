package com.github.ptrteixeira.cookbook.resources

import com.github.ptrteixeira.cookbook.auth.AuthComponent
import com.github.ptrteixeira.cookbook.base.BaseComponent
import com.github.ptrteixeira.cookbook.data.DataComponent
import dagger.Component

@Component(dependencies = arrayOf(DataComponent::class, AuthComponent::class, BaseComponent::class))
internal interface ResourcesComponent {
    fun recipesResource(): RecipesResource
}
