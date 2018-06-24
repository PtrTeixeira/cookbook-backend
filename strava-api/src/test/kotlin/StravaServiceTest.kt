
import com.github.ptrteixeira.strava.api.StravaApi
import com.github.ptrteixeira.strava.api.StravaService
import com.github.ptrteixeira.strava.api.models.AthleteActivitiesResponse
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.mockito.Mockito.mock
import org.mockito.Mockito.reset
import java.time.LocalDateTime
import java.time.ZoneOffset

internal class StravaServiceTest {
    // Mocks
    private val strava: StravaApi = mock(StravaApi::class.java)

    // SUT
    private val stravaService = StravaService(strava)

    @BeforeEach
    fun resetMocks() {
        reset(strava)
    }

    @Test
    fun itReturnsAnEmptyObservableIfThereAreNoActivities() {
        val after = LocalDateTime.now().minusMonths(2)
        val afterUtcSeconds = after.toEpochSecond(ZoneOffset.UTC)

        given(strava.getAthleteActivities("Bearer token", after = afterUtcSeconds, page = 1))
                .willReturn(Single.just(listOf()))

        val testSubscriber = TestObserver<AthleteActivitiesResponse>()
        stravaService
                .getAthleteActivities("token", after)
                .subscribe(testSubscriber)

        testSubscriber
                .assertTerminated()
                .assertNoValues()
                .assertNoErrors()
    }

    @Test
    fun itPaginatesThroughResponsesUntilItReceivesAnEmptyPage() {
        val after = LocalDateTime.now().minusMonths(2)
        val afterUtcSeconds = after.toEpochSecond(ZoneOffset.UTC)

        given(strava.getAthleteActivities("Bearer token", after = afterUtcSeconds, page = 1))
                .willReturn(Single.just(listOf(AthleteActivitiesResponse(id = 1))))
        given(strava.getAthleteActivities("Bearer token", after = afterUtcSeconds, page = 2))
                .willReturn(Single.just(listOf(AthleteActivitiesResponse(id = 2))))
        given(strava.getAthleteActivities("Bearer token", after = afterUtcSeconds, page = 3))
                .willReturn(Single.just(listOf()))

        val testSubscriber = TestObserver<AthleteActivitiesResponse>()
        stravaService
                .getAthleteActivities("token", after)
                .subscribe(testSubscriber)

        testSubscriber
                .assertTerminated()
                .assertNoErrors()
                .assertValues(AthleteActivitiesResponse(id = 1), AthleteActivitiesResponse(id = 2))
    }
}