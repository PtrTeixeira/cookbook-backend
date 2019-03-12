package com.github.ptrteixeira.punchcard.resources

import com.codahale.metrics.MetricRegistry
import com.github.ptrteixeira.strava.api.IStravaService
import com.github.ptrteixeira.strava.api.models.AthleteActivitiesResponse
import com.google.common.collect.HashBasedTable
import reactor.core.publisher.Mono
import java.time.Clock
import java.time.DayOfWeek
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
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
class PunchcardResource(
    private val strava: IStravaService,
    private val clock: Clock,
    registry: MetricRegistry
) {
    private val getActivitiesDuration = registry.timer("punchcard.getActivities.duration")

    @GET
    fun getActivities(
        @CookieParam("StravaAuthToken") authToken: String?,
        @Suspended asyncResponse: AsyncResponse
    ) {
        val callDuration = getActivitiesDuration.time()
        getActivitiesTable(authToken)
            .subscribe({
                asyncResponse.resume(it)
                callDuration.stop()
            }, {
                asyncResponse.resume(it)
                callDuration.stop()
            })
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

    private fun getActivitiesTable(authToken: String?): Mono<Map<DayOfWeek, Map<Int, Long>>> {
        if (authToken == null) {
            throw WebApplicationException(Response.Status.FORBIDDEN)
        }

        return strava
                .getAthleteActivities(authToken, LocalDateTime.now(clock).minusMonths(6))
                .reduce(HashBasedTable.create<DayOfWeek, Int, Long>()) { table, activity ->
                    val (day, hour) = rollupByTime(activity)
                    val currentCount = table[day, hour] ?: 0

                    table.put(day, hour, currentCount + 1)
                    table
                }.map {
                    it.rowMap()
                }
    }
}