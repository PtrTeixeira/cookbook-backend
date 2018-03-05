package com.github.ptrteixeira.cookbook.auth.resources

import com.github.ptrteixeira.cookbook.support.response.Response
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier
import javax.inject.Inject
import javax.ws.rs.Consumes
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response as WsResponse

@Path("/auth")
@Consumes(MediaType.APPLICATION_JSON)
class LoginResource
@Inject internal constructor(private val tokenVerifier: GoogleIdTokenVerifier) {
    @Path("/google")
    @POST
    fun googleSignIn(): WsResponse {
        return Response.ok {
            cookie("auth-token", "fake-jwt-token") { }
        }
    }
}