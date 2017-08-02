package com.github.ptrteixeira.cookbook.data

import com.codahale.metrics.health.HealthCheck
import com.google.common.util.concurrent.MoreExecutors
import io.dropwizard.db.TimeBoundHealthCheck
import io.dropwizard.util.Duration
import org.jdbi.v3.core.Jdbi
import java.util.concurrent.ExecutorService

class Jdbi3HealthCheck(
    private val jdbi: Jdbi,
    private val validationQuery: String,
    executorService: ExecutorService,
    duration: Duration
) : HealthCheck() {
    private val timeBound = TimeBoundHealthCheck(executorService, duration)

    constructor(jdbi: Jdbi, validationQuery: String) :
        this(jdbi, validationQuery, MoreExecutors.newDirectExecutorService(), Duration.seconds(0))

    public override fun check(): Result = timeBound.check {
        jdbi.withHandle<Result, Exception> {
            it.execute(validationQuery)
            return@withHandle Result.healthy()
        }
    }
}
