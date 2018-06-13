package com.github.ptrteixeira.strava.api.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class AthleteActivitiesResponse(
    val id: Long = 0,
    val elapsedTime: Int = 0,
    val movingTime: Int = 0,
    val name: String? = null,
    val startDate: String? = null,
    val kudosCount: Int = 0,
    val calories: Int = 0,
    val distance: Int = 0
)
