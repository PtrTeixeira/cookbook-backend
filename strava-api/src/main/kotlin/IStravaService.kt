package com.github.ptrteixeira.strava.api

import com.github.ptrteixeira.strava.api.models.AthleteActivitiesResponse
import com.github.ptrteixeira.strava.api.models.TokenResponse
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.LocalDateTime

interface IStravaService {
    fun getAthleteActivities(
        authToken: String,
        after: LocalDateTime
    ): Flux<AthleteActivitiesResponse>

    fun getAuthToken(clientId: String, clientSecret: String, code: String): Mono<TokenResponse>
}