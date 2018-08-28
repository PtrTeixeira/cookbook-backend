package com.github.ptrteixeira.punchcard.resources

import com.github.ptrteixeira.punchcard.StravaPunchcardModule
import com.github.ptrteixeira.strava.api.StravaApi
import io.micrometer.core.instrument.MeterRegistry
import org.slf4j.LoggerFactory
import java.net.URI
import java.util.Random
import java.util.concurrent.TimeUnit
import javax.ws.rs.Consumes
import javax.ws.rs.CookieParam
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
    baseUrl: String,
    private val dashboardUiUrl: String,
    private val clientId: String,
    private val clientSecret: String,
    private val apiClient: StravaApi,
    registry: MeterRegistry
) {
    private val random = Random()
    private val redirectUri = URI("$baseUrl/strava/callback")
    private val successfulLoginAttempts = registry.counter("http.requests.login.success")
    private val failedLoginAttempts = registry.counter("http.requests.login.failed")

    @GET
    @Path("/login")
    fun authRedirect(): Response {
        val nonce = random.nextLong().toString(16)

        val stravaAuthorizePath = UriBuilder
                .fromPath(STRAVA_AUTHORIZE_URI)
                .queryParam("client_id", clientId)
                .queryParam("response_type", STRAVA_RESPONSE_TYPE)
                .queryParam("redirect_uri", redirectUri)
                .queryParam("state", nonce)
                .build()

        return Response
                .seeOther(stravaAuthorizePath)
                .cookie(buildVerificationCookie(nonce))
                .build()
    }

    @GET
    @Path("/callback")
    fun authCallback(
        @CookieParam(AUTH_NONCE_NAME) authNonce: String?,
        @QueryParam("code") code: String?,
        @QueryParam("error") error: String?,
        @QueryParam("state") state: String?
    ): Response {
        if (error != null || code == null || authNonce == null || state == null) {
            failedLoginAttempts.increment()
            return Response
                    .status(Response.Status.FORBIDDEN)
                    .build()
        }

        if (state != authNonce) {
            LOG.warn("Login callback FAILED due to invalid auth nonce {}", authNonce)
            failedLoginAttempts.increment()
            return Response
                    .status(Response.Status.FORBIDDEN)
                    .build()
        }

        val cookie = apiClient
                .getAuthToken(clientId, clientSecret, code)
                .map { it.accessToken }
                .map { buildAuthCookie(it) }
                .block()

        successfulLoginAttempts.increment()
        return Response.seeOther(URI(dashboardUiUrl))
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

    private fun buildVerificationCookie(nonce: String) = NewCookie(AUTH_NONCE_NAME, nonce)

    companion object {
        private const val STRAVA_AUTHORIZE_URI = "https://www.strava.com/oauth/authorize"
        private const val STRAVA_RESPONSE_TYPE = "code"
        private const val AUTH_NONCE_NAME = "AuthNonce"
        private val MAX_AGE = TimeUnit.DAYS.toSeconds(1).toInt()

        private val LOG = LoggerFactory.getLogger(AuthResource::class.java)
    }
}