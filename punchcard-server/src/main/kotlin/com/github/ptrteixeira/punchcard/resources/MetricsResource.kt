package com.github.ptrteixeira.punchcard.resources

import io.micrometer.prometheus.PrometheusMeterRegistry
import javax.ws.rs.GET
import javax.ws.rs.Path

@Path("/metrics")
class MetricsResource(private val registry: PrometheusMeterRegistry) {
    @GET
    fun reportMetrics(): String {
        return registry.scrape()
    }
}