package com.github.ptrteixeira.cookbook.data

import com.codahale.metrics.health.HealthCheck.Result
import io.dropwizard.util.Duration
import org.assertj.core.api.Assertions.assertThat
import org.jdbi.v3.core.Handle
import org.jdbi.v3.core.HandleCallback
import org.jdbi.v3.core.Jdbi
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.BDDMockito.given
import org.mockito.Mockito.mock
import org.mockito.Mockito.reset
import java.sql.SQLException
import java.util.concurrent.Executors.newSingleThreadExecutor
import java.util.concurrent.TimeUnit

internal class Jdbi3HealthCheckTest {
    private val validationQuery = "select 1"
    private val jdbi: Jdbi = mock(Jdbi::class.java)
    private val handle: Handle = mock(Handle::class.java)

    @BeforeEach
    fun resetMock() {
        reset(jdbi, handle)

        given(jdbi.withHandle<Result, Exception>(any()))
            .will { invocation ->
                invocation
                    .getArgument<HandleCallback<Result, Exception>>(0)
                    .withHandle(handle)
            }
    }

    @Test
    fun itTimesOutProperly() {
        given(handle.execute(validationQuery))
            .will {
                TimeUnit.SECONDS.sleep(10)
                null
            }

        val executor = newSingleThreadExecutor()
        val healthCheck = Jdbi3HealthCheck(jdbi, validationQuery, executor, Duration.milliseconds(5))

        val result = healthCheck.check()
        executor.shutdown()

        assertThat(result.isHealthy)
            .isFalse()
    }

    @Test
    fun itMarksExceptionsAsFailures() {
        given(handle.execute(validationQuery))
            .will { throw SQLException() }

        val executor = newSingleThreadExecutor()
        val healthCheck = Jdbi3HealthCheck(jdbi, validationQuery, executor, Duration.milliseconds(5))

        val result = healthCheck.check()
        executor.shutdown()

        assertThat(result.isHealthy)
            .isFalse()
    }
}
