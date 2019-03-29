package com.github.ptrteixeira.cookbook

import com.github.ptrteixeira.cookbook.auth.TrivialAuth
import com.github.ptrteixeira.cookbook.config.CookbookConfiguration
import com.github.ptrteixeira.cookbook.core.User
import com.github.ptrteixeira.cookbook.data.RecipeData
import com.google.inject.AbstractModule
import com.google.inject.Provides
import com.google.inject.TypeLiteral
import io.dropwizard.auth.Authenticator
import io.dropwizard.jdbi3.JdbiFactory
import io.dropwizard.setup.Environment
import org.jdbi.v3.core.Jdbi

class ApplicationModule(private val config: CookbookConfiguration, private val environment: Environment) : AbstractModule() {
    override fun configure() {
        bind(object : TypeLiteral<Authenticator<String, User>>() {})
                .to(TrivialAuth::class.java);
    }

    @Provides fun jdbiFactory() : Jdbi {
        return JdbiFactory()
                .build(environment, config.database, "h2")
                .installPlugins()
                .registerArrayType(String::class.java, "varchar")
    }

    @Provides fun recipeData(database: Jdbi): RecipeData {
        return database.onDemand(RecipeData::class.java)
    }
}