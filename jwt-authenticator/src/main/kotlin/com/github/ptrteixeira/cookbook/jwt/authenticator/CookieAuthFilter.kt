package com.github.ptrteixeira.cookbook.jwt.authenticator

import io.dropwizard.auth.AuthFilter
import io.dropwizard.auth.Authenticator
import io.dropwizard.auth.Authorizer
import io.dropwizard.auth.PermitAllAuthorizer
import java.security.Principal
import java.util.Optional
import javax.ws.rs.WebApplicationException
import javax.ws.rs.container.ContainerRequestContext
import javax.ws.rs.core.SecurityContext

class CookieAuthFilter<P : Principal> private constructor(private val cookieName: String,
                                                          private val authorizer: Authorizer<P>,
                                                          private val authenticator: Authenticator<String?, P>)
    : AuthFilter<String?, P>() {
    override fun filter(requestContext: ContainerRequestContext?) {
        if (requestContext == null) {
            throw NullPointerException("Request context must be provided")
        }

        val credentials: String? = requestContext
                .cookies[cookieName]
                ?.value

        if (!authenticate(requestContext, credentials, SecurityContext.BASIC_AUTH)) {
            throw WebApplicationException(unauthorizedHandler.buildResponse(prefix, realm))
        }
    }

    class Builder<P : Principal> internal constructor() {
        var authorizer: Authorizer<P> = PermitAllAuthorizer()
        var authenticator: Authenticator<String?, P> = Authenticator { Optional.empty<P>() }
        var cookieName = "X-Auth"

        internal fun build(): CookieAuthFilter<P> {
            return CookieAuthFilter(cookieName, authorizer, authenticator)
        }
    }

    companion object {
        fun <P : Principal> cookieAuthFilter(fn: Builder<P>.() -> Unit): CookieAuthFilter<P> {
            return Builder<P>()
                    .also(fn)
                    .build()
        }
    }
}