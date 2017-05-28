package com.github.ptrteixeira.cookbook.resources

import com.github.ptrteixeira.cookbook.base.BaseComponent
import com.github.ptrteixeira.cookbook.data.DataComponent
import dagger.Component
import io.vertx.ext.web.Router
import javax.inject.Named

@Component(
        modules = arrayOf(ResourcesModule::class),
        dependencies = arrayOf(
                DataComponent::class,
                BaseComponent::class
        )
)
internal interface ResourcesComponent {
    @Named(ResourcesModule.API_ROUTER)
    fun apiRouter(): Router
}
