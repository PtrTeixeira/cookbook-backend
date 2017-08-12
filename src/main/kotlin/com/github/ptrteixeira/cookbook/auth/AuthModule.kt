package com.github.ptrteixeira.cookbook.auth

import com.github.ptrteixeira.cookbook.model.User
import dagger.Module
import dagger.Provides
import io.dropwizard.auth.Authenticator
import io.dropwizard.auth.basic.BasicCredentials

@Module
class AuthModule {
    @Provides
    fun rawAuthenticator(): Authenticator<BasicCredentials, User> {
        return TrivialAuth()
    }
}
