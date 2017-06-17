package com.github.ptrteixeira.cookbook.data

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.github.ptrteixeira.cookbook.model.Recipe
import com.github.ptrteixeira.cookbook.model.RecipeEgg
import org.elasticsearch.action.DocWriteResponse
import org.elasticsearch.client.transport.TransportClient
import java.util.*
import javax.inject.Inject

internal class RecipeData @Inject
constructor(
    val client: TransportClient,
    val objectMapper: ObjectMapper
) {
    fun getRecipes(): List<Recipe> {
        return client.prepareSearch("cookbook")
            .setTypes("recipe")
            .get()
            .hits
            .hits
            .map { objectMapper.readValue<Recipe>(it.sourceAsString) }
    }

    fun getRecipe(id: String): Optional<Recipe> {
        val response = client.prepareGet()
            .setId(id)
            .setIndex("cookbook")
            .setType("recipe")
            .get()
        return when (response.isExists) {
            true -> Optional.of(objectMapper.readValue<Recipe>(response.sourceAsString))
            else -> Optional.empty()
        }
    }

    fun createRecipe(recipe: Recipe): String {
        val mapType = object : TypeReference<Map<String, Any?>>() {}
        val toAdd: Map<String, Any> = objectMapper.convertValue(recipe, mapType)
        val id = client.prepareIndex("cookbook", "recipe")
            .setSource(toAdd)
            .get()
            .id

        return "/recipes/$id"
    }

    fun deleteRecipe(id: String): Boolean {
        val response = client.prepareDelete()
            .setId(id)
            .setIndex("cookbook")
            .setType("recipe")
            .get()
            .result
        return response  == DocWriteResponse.Result.DELETED
    }

    fun patchRecipe(id: String, recipe: RecipeEgg): Recipe {
        return client.prepareUpdate()
            .setId(id)
            .setIndex("cookbook")
            .setType("recipe")
            .setDoc(recipe)
            .get()
            .getResult
            .sourceAsString()
            .let { objectMapper.readValue<Recipe>(it) }
    }
}

