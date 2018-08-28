package com.github.ptrteixeira.punchcard.resources

import com.github.ptrteixeira.strava.api.IStravaService
import com.github.ptrteixeira.strava.api.models.AthleteActivitiesResponse
import io.micrometer.core.instrument.simple.SimpleMeterRegistry
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.BDDMockito.given
import org.mockito.BDDMockito.then
import org.mockito.Mockito.mock
import reactor.core.publisher.Flux
import java.time.Clock
import java.time.DayOfWeek
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoField
import java.time.temporal.ChronoUnit
import java.util.concurrent.TimeoutException
import javax.ws.rs.container.AsyncResponse

class PunchcardResourceTest {
    private val testClock = Clock.fixed(Instant.EPOCH, ZoneOffset.UTC)
    private val queryStartDate = LocalDateTime.now(testClock).minus(6, ChronoUnit.MONTHS)

    lateinit var punchcardResource: PunchcardResource
    lateinit var stravaService: IStravaService
    lateinit var asyncResponse: AsyncResponse

    @Before
    fun setUp() {
        stravaService = mock(IStravaService::class.java)
        asyncResponse = mock(AsyncResponse::class.java)

        punchcardResource = PunchcardResource(stravaService, testClock, SimpleMeterRegistry())
    }

    @Test
    fun `when there are no activities it returns an empty map`() {
        given(stravaService.getAthleteActivities("", queryStartDate))
                .willReturn(Flux.empty())

        punchcardResource
                .getActivities("", asyncResponse)

        then(asyncResponse)
                .should()
                .resume(emptyMap<DayOfWeek, Map<Int, Long>>())
    }

    @Test
    fun `when it receives an http error it propagates that error`() {
        given(stravaService.getAthleteActivities("", queryStartDate))
                .willReturn(Flux.error(TimeoutException()))

        punchcardResource
                .getActivities("", asyncResponse)

        then(asyncResponse)
                .should()
                .resume(any<TimeoutException>())
    }

    @Test
    fun `when it finds activities it adds them to the returned map`() {
        given(stravaService.getAthleteActivities("", queryStartDate))
                .willReturn(Flux.just(
                        activityAtTime(DayOfWeek.MONDAY, 18),
                        activityAtTime(DayOfWeek.MONDAY, 18),
                        activityAtTime(DayOfWeek.SUNDAY, 9)
                ))

        punchcardResource
                .getActivities("", asyncResponse)

        val resultMap = mapOf(
                DayOfWeek.MONDAY to mapOf(18 to 2.toLong()),
                DayOfWeek.SUNDAY to mapOf(9 to 1.toLong())
        )
        then(asyncResponse)
                .should()
                .resume(resultMap)
    }

    private fun activityAtTime(day: DayOfWeek, hour: Int): AthleteActivitiesResponse {
        val activityStartTime = ZonedDateTime.now(testClock)
                .with(day)
                .with(ChronoField.HOUR_OF_DAY, hour.toLong())

        val timeAsString = activityStartTime
                .format(DateTimeFormatter.ISO_OFFSET_DATE_TIME)

        return AthleteActivitiesResponse(
                startDate = timeAsString,
                startDateLocal = timeAsString
        )
    }
}