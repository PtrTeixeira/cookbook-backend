package com.github.ptrteixeira.cookbook.auth.resources

import com.github.ptrteixeira.cookbook.auth.managers.AuthManager
import com.github.ptrteixeira.cookbook.core.TokenBearer
import com.github.ptrteixeira.cookbook.support.response.Response
import java.time.Duration
import javax.inject.Inject
import javax.ws.rs.Consumes
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response as WsResponse


/*
 * TODO:
 * - Actually generate a JWT & cookie
 * - Add a user data table
 * - Add a password sign-in option
 * - Move this to a separate service
 * - Add a GitHub sign-in option?
 *
 */
@Path("/auth")
@Consumes(MediaType.APPLICATION_JSON)
class LoginResource
@Inject internal constructor(private val authManager: AuthManager) {

    @POST
    @Path("/google")
    fun googleSignIn(token: TokenBearer): WsResponse {
        val user = authManager.getUserForGoogleToken(token.data)

        return if (user == null) {
            // Indicates user sent invalid access token
            Response.status(WsResponse.Status.FORBIDDEN) { }
        } else {
            val jwt = authManager.buildJwtForUser(user)
            Response.ok {
                cookie("access_token", jwt) {
                    httpOnly = true
                    secure = true
                    maxAge = Duration.ofDays(1)
                }
            }
        }
    }
}