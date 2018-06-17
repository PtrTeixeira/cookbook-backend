package com.github.ptrteixeira.punchcard.resources

import com.github.ptrteixeira.punchcard.StravaPunchcardModule
import com.github.ptrteixeira.strava.api.StravaApi
import java.net.URI
import java.util.concurrent.TimeUnit
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.NewCookie
import javax.ws.rs.core.Response
import javax.ws.rs.core.UriBuilder

@Path("/strava")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class AuthResource(
        private val baseUrl: String,
        private val clientId: String,
        private val clientSecret: String,
        private val apiClient: StravaApi
) {
    // TODO(pteixeira) Rewrite this so that getting the cookie is
    // handled on the front-end. It's much easier to handle opening/closing
    // a pop-up from there instead of here

    private val redirectUri = URI("$baseUrl/strava/callback")

    @GET
    @Path("/login")
    fun authRedirect(): Response {
        val stravaAuthorizePath = UriBuilder
                .fromPath(STRAVA_AUTHORIZE_URI)
                .queryParam("client_id", clientId)
                .queryParam("response_type", STRAVA_RESPONSE_TYPE)
                .queryParam("redirect_uri", redirectUri)
                .build()

        return Response
                .seeOther(stravaAuthorizePath)
                .build()
    }

    @GET
    @Path("/callback")
    fun authCallback(@QueryParam("code") code: String?,
                     @QueryParam("error") error: String?): Response {
        if (error != null || code == null) {
            return Response
                    .status(Response.Status.FORBIDDEN)
                    .build()
        }

        val cookie = apiClient
                .getAuthToken(clientId, clientSecret, code)
                .map { it.accessToken }
                .map { buildAuthCookie(it) }
                .blockingGet()

        return Response
                .accepted()
                .cookie(cookie)
                .build()
    }

    private fun buildAuthCookie(value: String) = NewCookie(
            StravaPunchcardModule.AUTH_TOKEN_NAME,
            value,
            "/",
            "",
            "",
            MAX_AGE,
            false,
            true
    )

    companion object {
        private const val STRAVA_AUTHORIZE_URI = "https://www.strava.com/oauth/authorize"
        private const val STRAVA_RESPONSE_TYPE = "code"
        private val MAX_AGE = TimeUnit.DAYS.toSeconds(1).toInt()
    }
}