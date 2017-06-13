package com.github.ptrteixeira.cookbook.data

import com.fasterxml.jackson.databind.ObjectMapper
import com.github.ptrteixeira.cookbook.model.Recipe
import com.github.ptrteixeira.cookbook.model.RecipeEgg
import dagger.Module
import dagger.Provides
import org.elasticsearch.client.transport.TransportClient
import org.elasticsearch.common.settings.Settings
import org.elasticsearch.common.transport.InetSocketTransportAddress
import org.elasticsearch.transport.client.PreBuiltTransportClient
import java.net.InetAddress
import java.util.*
import javax.inject.Named


@Module
internal class DataModule {

    @Provides
    @Named(ELASTIC_SEARCH_HOST)
    fun elasticSearchHost(): String {
        return System.getenv("ELASTIC_HOST") ?: "localhost"
    }

    @Provides
    @Named(ELASTIC_SEARCH_PORT)
    fun elasticSearchPort(): Int {
        try {
            return System.getenv("ELASTIC_PORT")?.toInt() ?: 9300
        } catch (exn: NumberFormatException) {
            return 9300
        }
    }

    @Provides
    fun elasticSearchClient(@Named(ELASTIC_SEARCH_HOST) host: String,
                            @Named(ELASTIC_SEARCH_PORT) port: Int): TransportClient {
        val address = InetAddress.getByName(host)
        return PreBuiltTransportClient(Settings.EMPTY)
            .addTransportAddress(InetSocketTransportAddress(address, port))
    }

    @Provides
    fun providesGetRecipes(client: TransportClient, objectMapper: ObjectMapper): () -> List<Recipe> {
        return getRecipes(client, objectMapper)
    }

    @Provides
    fun providesGetRecipe(client: TransportClient, objectMapper: ObjectMapper): (String) -> Optional<Recipe> {
        return getRecipe(client, objectMapper)
    }

    @Provides
    fun providesCreateRecipe(client: TransportClient, objectMapper: ObjectMapper): (Recipe) -> String {
        return createRecipe(client, objectMapper)
    }

    @Provides
    fun providesDeleteRecipe(client: TransportClient): (String) -> Boolean {
        return deleteRecipe(client)
    }

    @Provides
    fun providesPatchRecipe(client: TransportClient, objectMapper: ObjectMapper): (String, RecipeEgg) -> Recipe {
        return patchRecipe(client, objectMapper)
    }

    companion object {
        const val ELASTIC_SEARCH_HOST = "elastic.host"
        const val ELASTIC_SEARCH_PORT = "elastic.port"
    }
}
