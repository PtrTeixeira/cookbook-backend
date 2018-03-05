package com.github.ptrteixeira.cookbook.auth.managers

import com.github.ptrteixeira.cookbook.auth.data.UserDao
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier
import javax.inject.Inject

class AuthManager
@Inject internal constructor(private val tokenVerifier: GoogleIdTokenVerifier,
                             private val userDao: UserDao) {

}