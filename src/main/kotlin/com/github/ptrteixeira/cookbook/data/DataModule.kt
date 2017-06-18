package com.github.ptrteixeira.cookbook.data

import com.github.ptrteixeira.cookbook.CookbookConfiguration
import dagger.Module
import dagger.Provides
import org.elasticsearch.client.transport.TransportClient
import org.elasticsearch.common.settings.Settings
import org.elasticsearch.common.transport.InetSocketTransportAddress
import org.elasticsearch.transport.client.PreBuiltTransportClient
import java.net.InetAddress
import javax.inject.Named


@Module
internal class DataModule(private val configuration: CookbookConfiguration) {


    @Provides
    @Named(ELASTIC_SEARCH_HOST)
    fun elasticSearchHost(): String {
        return configuration.elasticSearchHost
    }

    @Provides
    @Named(ELASTIC_SEARCH_PORT)
    fun elasticSearchPort(): Int {
        return configuration.elasticSearchPort
    }

    @Provides
    fun elasticSearchClient(@Named(ELASTIC_SEARCH_HOST) host: String,
                            @Named(ELASTIC_SEARCH_PORT) port: Int): TransportClient {
        val address = InetAddress.getByName(host)
        return PreBuiltTransportClient(Settings.EMPTY)
            .addTransportAddress(InetSocketTransportAddress(address, port))
    }

    @Provides
    fun recipeData(impl: RecipeDataImpl): RecipeData = impl

    companion object {
        const val ELASTIC_SEARCH_HOST = "elastic.host"
        const val ELASTIC_SEARCH_PORT = "elastic.port"
    }
}
