package com.github.ptrteixeira.strava.api

import com.github.ptrteixeira.strava.api.models.AthleteActivitiesResponse
import com.github.ptrteixeira.strava.api.models.TokenResponse
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.LocalDateTime
import java.time.ZoneOffset

open class StravaService(private val strava: StravaApi) {
    fun getAthleteActivities(
        authToken: String,
        after: LocalDateTime
    ): Flux<AthleteActivitiesResponse> {
        return getAthleteActivities(authToken, 1, after)
    }

    fun getAuthToken(clientId: String, clientSecret: String, code: String): Mono<TokenResponse> {
        return strava.getAuthToken(clientId, clientSecret, code)
    }

    private fun getAthleteActivities(
        authToken: String,
        page: Int,
        after: LocalDateTime
    ): Flux<AthleteActivitiesResponse> {
        val header = buildAuthHeader(authToken)
        val afterUtcSeconds: Long = after.toEpochSecond(ZoneOffset.UTC)
        val response = strava
                .getAthleteActivities(header, afterUtcSeconds, page = page)

        return response
                .flatMapMany {
                    if (it.isEmpty()) {
                        Flux.fromIterable(it)
                    } else {
                        Flux
                                .fromIterable(it)
                                .concatWith(getAthleteActivities(authToken, page + 1, after))
                    }
                }
    }

    private fun buildAuthHeader(token: String): String = "Bearer $token"
}