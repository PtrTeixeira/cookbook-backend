package com.github.ptrteixeira.punchcard.resources

import java.net.URI
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response
import javax.ws.rs.core.UriBuilder

@Path("/strava")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class AuthResource(
        baseUrl: String,
        private val clientId: String
) {
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
        if (error != null) {
            return Response
                    .status(Response.Status.FORBIDDEN)
                    .build()
        }

        return Response
                .status(Response.Status.ACCEPTED)
                .entity(code)
                .build()
    }

    companion object {
        private const val STRAVA_AUTHORIZE_URI = "https://www.strava.com/oauth/authorize"
        private const val STRAVA_RESPONSE_TYPE = "code"
    }
}