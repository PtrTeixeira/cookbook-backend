package com.github.ptrteixeira.cookbook.resources

import com.github.ptrteixeira.cookbook.base.BaseModule
import com.github.ptrteixeira.cookbook.data.DataModule
import dagger.Module
import dagger.Provides
import io.vertx.core.Vertx
import io.vertx.core.http.HttpMethod
import io.vertx.ext.web.Router
import javax.inject.Inject
import javax.inject.Named

@Module(includes = arrayOf( BaseModule::class, DataModule::class ))
internal class ResourcesModule {
    @Inject lateinit var recipesResource: RecipesResource


    @Named(API_ROUTER)
    @Provides
    fun apiRouter(vertx: Vertx): Router {
        val router = Router.router(vertx)
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
