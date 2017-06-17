package com.github.ptrteixeira.cookbook.data

import io.dropwizard.lifecycle.Managed
import org.elasticsearch.client.transport.TransportClient
import javax.inject.Inject

internal class ManagedTransportClient @Inject
constructor(private val client: TransportClient): Managed {
    override fun start() {}

    override fun stop() {
        client.close()
    }
}
