package com.github.ptrteixeira.cookbook.data

import com.github.ptrteixeira.cookbook.base.BaseComponent
import dagger.Component
import org.elasticsearch.client.transport.TransportClient

@Component(
        modules = arrayOf(DataModule::class),
        dependencies = arrayOf(BaseComponent::class))
internal interface DataComponent {
    fun elasticSearchClient(): TransportClient

    fun managedTransportClient(): ManagedTransportClient

    fun recipeData(): RecipeData
}
