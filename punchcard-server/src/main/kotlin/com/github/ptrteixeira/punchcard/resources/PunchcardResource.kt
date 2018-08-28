package com.github.ptrteixeira.punchcard.resources

import com.github.ptrteixeira.punchcard.StravaPunchcardModule
import com.github.ptrteixeira.strava.api.IStravaService
import com.github.ptrteixeira.strava.api.models.AthleteActivitiesResponse
import com.google.common.base.Stopwatch
import io.micrometer.core.instrument.MeterRegistry
import io.micrometer.core.instrument.Timer
import reactor.core.publisher.Flux
import reactor.core.publisher.GroupedFlux
import reactor.core.publisher.toFlux
import java.time.Clock
import java.time.DayOfWeek
import java.time.Duration
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
    registry: MeterRegistry
) {
    private val getActivitiesDuration = Timer.builder("http.requests")
            .tag("uri", "/punchcard")
            .sla(Duration.ofMillis(500))
            .publishPercentileHistogram()
            .register(registry)

    @GET
    fun getActivities(
        @CookieParam(StravaPunchcardModule.AUTH_TOKEN_NAME) authToken: String?,
        @Suspended asyncResponse: AsyncResponse
    ) {
        val timer = Stopwatch.createStarted()
        if (authToken == null) {
            asyncResponse
                    .resume(WebApplicationException(Response.Status.FORBIDDEN))
            getActivitiesDuration.record(timer.elapsed())
        } else {

            strava
                    .getAthleteActivities(authToken, LocalDateTime.now(clock).minusMonths(6))
                    .groupBy { rollupByTime(it) }
                    .flatMap { countItems(it) }
                    .reduce(mapCollector()) { map, countByDayAndHour ->
                        val (rollup, count) = countByDayAndHour
                        rollup?.let {
                            val (weekDay, hour) = it

                            val weekDayKey = map
                                    .getOrDefault(weekDay, mutableMapOf())
                            weekDayKey[hour] = count
                            map[weekDay] = weekDayKey
                        }

                        return@reduce map
                    }.subscribe(
                            {
                                asyncResponse.resume(it)
                                getActivitiesDuration
                                        .record(timer.elapsed())
                            },
                            {
                                asyncResponse.resume(it)
                                getActivitiesDuration.record(timer.elapsed())
                            }
                    )
        }
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

    private fun <K, T> countItems(itemStream: GroupedFlux<K, T>): Flux<Pair<K, Long>> {
        return itemStream
                .count()
                .toFlux()
                .map { count -> itemStream.key() to count }
    }

    private fun mapCollector(): MutableMap<DayOfWeek, MutableMap<Int, Long>> {
        return mutableMapOf()
    }
}