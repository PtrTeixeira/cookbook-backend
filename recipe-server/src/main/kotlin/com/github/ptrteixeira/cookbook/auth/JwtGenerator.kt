package com.github.ptrteixeira.cookbook.auth

import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier
import org.slf4j.LoggerFactory
import javax.inject.Inject

class JwtGenerator
@Inject internal constructor(private val googleIdTokenVerifier: GoogleIdTokenVerifier) {
    private val logger = LoggerFactory.getLogger(JwtGenerator::class.java)

    fun fromGoogleAuth(credentials: String): String? {
//        val token = googleIdTokenVerifier
//                .verify(credentials)
        val token = ""
        logger.info("Received token {}", token)

        return if (token != null) {
            logger.info("Successfully signed in. Permitting sign-in")
            "fake-jwt-token"
        } else {
            null
        }
    }
}