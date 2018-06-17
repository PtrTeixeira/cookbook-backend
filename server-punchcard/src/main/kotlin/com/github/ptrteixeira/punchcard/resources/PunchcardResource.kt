package com.github.ptrteixeira.punchcard.resources

import com.github.ptrteixeira.punchcard.StravaPunchcardModule
import com.github.ptrteixeira.strava.api.StravaApi
import com.github.ptrteixeira.strava.api.models.AthleteActivitiesResponse
import io.reactivex.Observable
import io.reactivex.observables.GroupedObservable
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
class PunchcardResource(private val apiClient: StravaApi) {

    @GET
    fun getActivities(@CookieParam(StravaPunchcardModule.AUTH_TOKEN_NAME) authToken: String?,
                      @Suspended asyncResponse: AsyncResponse) {
        if (authToken == null) {
            asyncResponse
                    .resume(WebApplicationException(Response.Status.FORBIDDEN))
        }

        apiClient
                .getAthleteActivities("Bearer $authToken")
                .flatMapObservable { Observable.fromIterable(it) }
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

                    map
                }.subscribe(
                        { asyncResponse.resume(it) },
                        { asyncResponse.resume(it) }
                )
    }

    data class DayAndHourRollup(
            val day: DayOfWeek,
            val hour: Int
    )

    private fun rollupByTime(activity: AthleteActivitiesResponse): DayAndHourRollup {
        val startTimeAsString = activity.startDate
        val startTime = LocalDateTime.parse(startTimeAsString, DateTimeFormatter.ISO_OFFSET_DATE_TIME)

        return DayAndHourRollup(startTime.dayOfWeek, startTime.hour)
    }

    private fun <K, T> countItems(itemStream: GroupedObservable<K, T>): Observable<Pair<K?, Long>> {
        return itemStream
                .count()
                .toObservable()
                .map { count -> itemStream.key to count }
    }

    private fun mapCollector(): MutableMap<DayOfWeek, MutableMap<Int, Long>> {
        return mutableMapOf()
    }
}