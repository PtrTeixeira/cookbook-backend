package com.github.ptrteixeira.punchcard.resources

import com.codahale.metrics.MetricRegistry
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/metrics")
@Produces(MediaType.APPLICATION_JSON)
internal class MetricsResource(private val registry: MetricRegistry) {

    @GET
    fun reportMetrics() = registry
}