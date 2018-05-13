package com.github.ptrteixeira.cookbook.jwt.authenticator

import io.dropwizard.auth.Authenticator
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import java.security.Key
import java.security.Principal
import java.security.SignatureException
import java.util.Optional

abstract class JwtAuthenticator<P : Principal>(private val key: Key)
    : Authenticator<String?, P> {
    override fun authenticate(credentials: String?): Optional<P> {
        if (credentials == null) {
            return Optional.empty()
        }

        return try {
            val claims = Jwts
                    .parser()
                    .setSigningKey(key)
                    .parseClaimsJws(credentials)
                    .body

            authenticate(claims)
        } catch (exn: SignatureException) {
            Optional.empty()
        }
    }

    abstract fun authenticate(credentials: Claims?): Optional<P>
}