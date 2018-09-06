package com.github.ptrteixeira.punchcard.resources

import com.tylerkindy.dropwizard.dagger.Resource
import io.micrometer.prometheus.PrometheusMeterRegistry
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path

@Path("/metrics")
internal class MetricsResource @Inject constructor(
    private val registry: PrometheusMeterRegistry
) : Resource {
    @GET
    fun reportMetrics(): String {
        return registry.scrape()
    }
}