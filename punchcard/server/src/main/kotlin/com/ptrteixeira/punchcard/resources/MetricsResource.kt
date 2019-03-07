package com.github.ptrteixeira.punchcard.resources

import com.codahale.metrics.MetricRegistry
import javax.ws.rs.GET
import javax.ws.rs.Path

@Path("/metrics")
internal class MetricsResource(private val registry: MetricRegistry) {

    @GET
    fun reportMetrics() = registry
}