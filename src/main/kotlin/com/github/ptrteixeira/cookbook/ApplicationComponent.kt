package com.github.ptrteixeira.cookbook

import com.github.ptrteixeira.cookbook.base.BaseComponent
import com.github.ptrteixeira.cookbook.resources.ResourcesComponent
import com.github.ptrteixeira.cookbook.resources.ResourcesModule
import dagger.Component
import io.vertx.core.http.HttpServer
import io.vertx.ext.web.Router
import javax.inject.Named

@Component(
        modules = arrayOf(ApplicationModule::class),
        dependencies = arrayOf(BaseComponent::class, ResourcesComponent::class)
)
interface ApplicationComponent {
    @Named(ResourcesModule.PARENT_ROUTER)
    fun parentRouter(): Router

    fun server(): HttpServer
}
