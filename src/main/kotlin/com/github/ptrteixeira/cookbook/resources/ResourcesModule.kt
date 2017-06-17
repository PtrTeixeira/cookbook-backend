package com.github.ptrteixeira.cookbook.resources

import dagger.Module
import dagger.Provides
import io.vertx.core.Vertx
import io.vertx.core.http.HttpMethod
import io.vertx.ext.web.Router
import io.vertx.ext.web.handler.BodyHandler
import javax.inject.Named

@Module
internal class ResourcesModule {
    @Named(ResourcesModule.API_ROUTER)
    @Provides
    fun apiRouter(vertx: Vertx, recipesResource: RecipesResource): Router {
        val router = Router.router(vertx)
        router.route().handler(BodyHandler.create())
        val addRoute = withRouter(router)

        addRoute("/recipes", HttpMethod.GET, recipesResource::getRecipesResource)
        addRoute("/recipes", HttpMethod.POST, recipesResource::createRecipeResource)
        addRoute("/recipes/:id", HttpMethod.GET, recipesResource::getRecipeResource)
        addRoute("/recipes/:id", HttpMethod.PATCH, recipesResource::patchRecipeResource)
        addRoute("/recipes/:id", HttpMethod.DELETE, recipesResource::deleteRecipeResource)

        return router
    }

    companion object {
        const val PARENT_ROUTER = "router.parent"
        const val API_ROUTER = "router.api"
    }
}
