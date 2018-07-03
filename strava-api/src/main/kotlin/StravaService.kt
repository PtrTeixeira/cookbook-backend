package com.github.ptrteixeira.strava.api

import com.github.ptrteixeira.strava.api.models.AthleteActivitiesResponse
import com.github.ptrteixeira.strava.api.models.TokenResponse
import io.reactivex.Observable
import io.reactivex.Single
import java.time.LocalDateTime
import java.time.ZoneOffset

open class StravaService(private val strava: StravaApi) {
    fun getAthleteActivities(authToken: String,
                             after: LocalDateTime): Observable<AthleteActivitiesResponse> {
        return getAthleteActivities(authToken, 1, after)
    }

    fun getAuthToken(clientId: String, clientSecret: String, code: String): Single<TokenResponse> {
        return strava.getAuthToken(clientId, clientSecret, code)
    }

    private fun getAthleteActivities(authToken: String,
                                     page: Int,
                                     after: LocalDateTime): Observable<AthleteActivitiesResponse> {
        val header = buildAuthHeader(authToken)
        val afterUtcSeconds: Long = after.toEpochSecond(ZoneOffset.UTC)
        val response = strava
                .getAthleteActivities(header, afterUtcSeconds, page = page)

        return response
                .flatMapObservable {
                    if (it.isEmpty()) {
                        Observable.fromIterable(it)
                    } else {
                        Observable
                                .fromIterable(it)
                                .concatWith(getAthleteActivities(authToken, page + 1, after))
                    }
                }
    }

    private fun buildAuthHeader(token: String): String = "Bearer $token"
}