package com.github.ptrteixeira.strava.api

import com.github.ptrteixeira.strava.api.models.AthleteActivitiesResponse
import com.github.ptrteixeira.strava.api.models.TokenResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface StravaApi {
    @GET("athlete/activities")
    fun getAthleteActivities(
        @Header("authorization") authHeader: String,
        @Query("before") before: Long,
        @Query("after") after: Long,
        @Query("page") page: Int = 1,
        @Query("per_page") itemsPerPage: Int = 30
    ): Single<List<AthleteActivitiesResponse>>

    @GET("athlete/activities")
    fun getAthleteActivities(
        @Header("authorization") authHeader: String,
        @Query("page") page: Int = 1,
        @Query("per_page") itemsPerPage: Int = 30
    ): Single<List<AthleteActivitiesResponse>>

    @GET("athlete/activities")
    fun getAthleteActivities(
        @Header("authorization") authHeader: String,
        @Query("after") after: Long,
        @Query("page") page: Int = 1,
        @Query("per_page") itemsPerPage: Int = 30
    ): Single<List<AthleteActivitiesResponse>>

    @POST("https://www.strava.com/oauth/token")
    fun getAuthToken(
        @Query("client_id") clientId: String,
        @Query("client_secret") clientSecret: String,
        @Query("code") code: String
    ): Single<TokenResponse>
}