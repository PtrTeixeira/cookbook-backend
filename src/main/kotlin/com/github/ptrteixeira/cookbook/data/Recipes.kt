package com.github.ptrteixeira.cookbook.data

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.github.ptrteixeira.cookbook.model.Recipe
import com.github.ptrteixeira.cookbook.model.RecipeEgg
import org.elasticsearch.action.DocWriteResponse
import org.elasticsearch.client.transport.TransportClient
import java.util.*

internal fun getRecipes(client: TransportClient, objectMapper: ObjectMapper): () -> List<Recipe> = { ->
    client.prepareSearch("cookbook")
        .setTypes("recipe")
        .get()
        .hits
        .hits
        .map { objectMapper.readValue<Recipe>(it.sourceAsString) }
}

internal fun getRecipe(client: TransportClient, objectMapper: ObjectMapper) = { id : String ->
    val response = client.prepareGet()
        .setId(id)
        .setIndex("cookbook")
        .setType("recipe")
        .get()
    when (response.isExists) {
        true -> Optional.of(objectMapper.readValue<Recipe>(response.sourceAsString))
        else -> Optional.empty()
    }
}

internal fun createRecipe(client: TransportClient, objectMapper: ObjectMapper) = { recipe: Recipe ->
    val mapType = object : TypeReference<Map<String, Any?>>() {}
    val toAdd: Map<String, Any> = objectMapper.convertValue(recipe, mapType)
    val id = client.prepareIndex("cookbook", "recipe")
        .setSource(toAdd)
        .get()
        .id

    "/recipes/$id"
}

internal fun deleteRecipe(client: TransportClient) = { id: String ->
        val response = client.prepareDelete()
            .setId(id)
            .setIndex("cookbook")
            .setType("recipe")
            .get()
            .result
    response  == DocWriteResponse.Result.DELETED
}

internal fun patchRecipe(client: TransportClient, objectMapper: ObjectMapper) = { id: String, recipe: RecipeEgg ->
    client.prepareUpdate()
        .setId(id)
        .setIndex("cookbook")
        .setType("recipe")
        .setDoc(recipe)
        .get()
        .getResult
        .sourceAsString()
        .let { objectMapper.readValue<Recipe>(it) }
}
