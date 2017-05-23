package com.github.ptrteixeira.cookbook

import com.github.ptrteixeira.cookbook.resources.ResourcesModule
import dagger.Module
import dagger.Provides
import io.vertx.core.Vertx
import io.vertx.ext.web.Router
import javax.inject.Named

@Module(includes = arrayOf( ResourcesModule::class ))
internal class ApplicationModule {
    @Provides
    @Named(ResourcesModule.PARENT_ROUTER)
    fun parentRouter(@Named(ResourcesModule.API_ROUTER) apiRouter: Router,
                     vertx: Vertx): Router {
        return Router.router(vertx)
            .mountSubRouter("/api/v1", apiRouter)
    }

    @Provides
    fun server(vertx: Vertx) = vertx.createHttpServer()
}
