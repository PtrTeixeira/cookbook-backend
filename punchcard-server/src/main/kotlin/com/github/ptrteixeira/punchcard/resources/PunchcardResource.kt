package com.github.ptrteixeira.punchcard.resources

import com.github.ptrteixeira.strava.api.IStravaService
import com.github.ptrteixeira.strava.api.models.AthleteActivitiesResponse
import com.google.common.base.Stopwatch
import com.google.common.collect.HashBasedTable
import com.tylerkindy.dropwizard.dagger.Resource
import io.micrometer.core.instrument.MeterRegistry
import io.micrometer.core.instrument.Timer
import kotlinx.coroutines.experimental.reactive.openSubscription
import kotlinx.coroutines.experimental.runBlocking
import java.time.Clock
import java.time.DayOfWeek
import java.time.Duration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject
import javax.ws.rs.Consumes
import javax.ws.rs.CookieParam
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.WebApplicationException
import javax.ws.rs.container.AsyncResponse
import javax.ws.rs.container.Suspended
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/punchcard")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class PunchcardResource @Inject constructor(
    private val strava: IStravaService,
    private val clock: Clock,
    registry: MeterRegistry
) : Resource {
    private val getActivitiesDuration = Timer.builder("http.requests")
            .tag("uri", "/punchcard")
            .tag("method", "GET")
            .sla(Duration.ofMillis(500))
            .publishPercentileHistogram()
            .register(registry)

    @GET
    fun getActivities(
        @CookieParam(ResourcesModule.AUTH_TOKEN_NAME) authToken: String?,
        @Suspended asyncResponse: AsyncResponse
    ) {
        val timer = Stopwatch.createStarted()
        runBlocking {
            try {
                val activitiesMap = getActivitiesTable(authToken)
                asyncResponse.resume(activitiesMap)
            } catch (exn: Exception) {
                asyncResponse.resume(exn)
            }
        }
        getActivitiesDuration.record(timer.elapsed())
    }

    data class DayAndHourRollup(
        val day: DayOfWeek,
        val hour: Int
    )

    private fun rollupByTime(activity: AthleteActivitiesResponse): DayAndHourRollup {
        val startTimeAsString = activity.startDateLocal
        val startTime = LocalDateTime.parse(startTimeAsString, DateTimeFormatter.ISO_OFFSET_DATE_TIME)

        return DayAndHourRollup(startTime.dayOfWeek, startTime.hour)
    }

    private suspend fun getActivitiesTable(authToken: String?): Map<DayOfWeek, Map<Int, Long>> {
        if (authToken == null) {
            throw WebApplicationException(Response.Status.FORBIDDEN)
        }

        val activities = strava
                .getAthleteActivities(authToken, LocalDateTime.now(clock).minusMonths(6))
                .openSubscription()

        val activitiesTable = HashBasedTable.create<DayOfWeek, Int, Long>()

        for (activity in activities) {
            val (day, hour) = rollupByTime(activity)

            val currentCount = activitiesTable[day, hour] ?: 0
            activitiesTable.put(day, hour, currentCount + 1)
        }

        return activitiesTable.rowMap()
    }
}