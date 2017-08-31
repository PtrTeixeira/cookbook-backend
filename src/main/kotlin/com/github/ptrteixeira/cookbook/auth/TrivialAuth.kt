package com.github.ptrteixeira.cookbook.auth

import com.github.ptrteixeira.cookbook.model.User
import io.dropwizard.auth.Authenticator
import java.util.Optional

class TrivialAuth : Authenticator<String, User> {
    override fun authenticate(credentials: String?): Optional<User> {
        return when (credentials) {
            null -> Optional.empty()
            else -> Optional.of(User(credentials))
        }
    }
}
