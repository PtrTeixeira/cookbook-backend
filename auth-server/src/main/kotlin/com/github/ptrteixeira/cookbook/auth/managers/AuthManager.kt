package com.github.ptrteixeira.cookbook.auth.managers

import com.github.ptrteixeira.cookbook.auth.data.UserDao
import com.github.ptrteixeira.cookbook.core.User
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import java.security.Key
import javax.inject.Inject

class AuthManager
@Inject internal constructor(private val tokenVerifier: GoogleIdTokenVerifier,
                             private val signatureAlgorithm: SignatureAlgorithm,
                             private val signingKey: Key,
                             private val userDao: UserDao) {

    fun getUserForGoogleToken(googleCredential: String): User? {
        val result = tokenVerifier.verify(googleCredential)

        return result?.let {
            val googleId = it.payload.subject
            val email = it.payload.email

            getOrCreateUserByGoogleId(googleId, email)
        }
    }

    private fun getOrCreateUserByGoogleId(googleId: String, email: String): User {
        val user = userDao.getByGoogleId(googleId)

        return when (user) {
            null -> createUser(googleId, email)
            else -> user
        }
    }

    fun buildJwtForUser(user: User): String {
        return Jwts.builder()
                .setSubject(user.id)
                .claim("userName", user.userName)
                .signWith(signatureAlgorithm, signingKey)
                .compact()
    }

    private fun createUser(googleId: String, email: String): User {
        val key = userDao.createFromGoogleToken(googleId, email)
        return User(key.toString(), googleId, email)
    }
}