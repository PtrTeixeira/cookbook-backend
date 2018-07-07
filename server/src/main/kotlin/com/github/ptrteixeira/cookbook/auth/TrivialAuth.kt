package com.github.ptrteixeira.cookbook.auth

import com.github.ptrteixeira.cookbook.core.User
import io.dropwizard.auth.Authenticator
import java.util.Optional
import javax.inject.Inject

class TrivialAuth @Inject internal constructor() : Authenticator<String, User> {
    override fun authenticate(credentials: String?): Optional<User> {
        return when (credentials) {
            null -> Optional.empty()
            else -> Optional.of(User(credentials))
        }
    }
}
