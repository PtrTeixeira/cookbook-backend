package com.github.ptrteixeira.strava.api.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class Athlete(
        val id: Long,
        val username: String,
        val firstname: String?,
        val lastname: String?,
        val city: String?,
        val country: String?,
        val createdAt: String?,
        val email: String?,
        val badgeTypeId: Int?,
        val follower: String?,
        val friend: String?,
        val premium: Boolean,
        val profile: String?,
        val profileMedium: String?,
        val resourceState: Int,
        val sex: String?,
        val state: String?,
        val updatedAt: String
)