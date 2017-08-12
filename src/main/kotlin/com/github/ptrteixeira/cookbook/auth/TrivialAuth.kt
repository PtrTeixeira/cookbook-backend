package com.github.ptrteixeira.cookbook.auth

import com.github.ptrteixeira.cookbook.model.User
import io.dropwizard.auth.Authenticator
import io.dropwizard.auth.basic.BasicCredentials
import java.util.Optional

class TrivialAuth : Authenticator<BasicCredentials, User> {
    override fun authenticate(credentials: BasicCredentials?): Optional<User> {
        return when (credentials) {
            null -> Optional.empty()
            else -> Optional.of(User(credentials.username))
        }
    }
}
