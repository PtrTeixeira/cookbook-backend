package com.github.ptrteixeira.cookbook.resources

import com.tylerkindy.dropwizard.dagger.Resource
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet

@Module
internal interface ResourcesModule {
    @Binds
    @IntoSet
    fun bindRecipesResource(recipesResource: RecipesResource): Resource
}
