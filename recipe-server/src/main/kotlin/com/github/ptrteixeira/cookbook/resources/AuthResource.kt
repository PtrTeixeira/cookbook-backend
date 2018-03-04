package com.github.ptrteixeira.cookbook.resources

import com.github.ptrteixeira.cookbook.auth.JwtGenerator
import com.github.ptrteixeira.cookbook.core.TokenBearer
import com.github.ptrteixeira.cookbook.support.response.Response
import org.slf4j.LoggerFactory
import java.time.Duration
import javax.inject.Inject
import javax.ws.rs.Consumes
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
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
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class AuthResource
@Inject internal constructor(private val jwtGenerator: JwtGenerator) {
    private val logger = LoggerFactory.getLogger(AuthResource::class.java)

    @POST
    @Path("/google")
    fun googleSignIn(credentials: TokenBearer): WsResponse {
        logger.info("User not logged in. Generating login token")
        return Response.ok {
            cookie("cookbook-auth-token", "fake-jwt") {
                httpOnly = true
                secure = true
                maxAge = Duration.ofDays(1)
            }
        }
    }
}