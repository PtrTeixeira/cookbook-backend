package com.github.ptrteixeira.cookbook.auth

import com.github.ptrteixeira.cookbook.core.User
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier
import io.dropwizard.auth.Authenticator
import java.util.Optional
import javax.inject.Inject

class TokenAuth @Inject constructor(private val googleTokenVerifier: GoogleIdTokenVerifier)
    : Authenticator<String, User> {
    override fun authenticate(credentials: String?): Optional<User> {
        return when (credentials) {
            null -> Optional.empty()
            else -> verifyCredentials(credentials).map { User(it) }
        }
    }

    private fun verifyCredentials(credentials: String): Optional<String> {
        val token = googleTokenVerifier
            .verify(credentials)

        return when (token) {
            null -> Optional.empty()
            else -> Optional.of(token.payload.subject)
        }
    }
}
