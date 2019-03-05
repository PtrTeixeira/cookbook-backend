package com.github.ptrteixeira.cookbook.auth

import com.github.ptrteixeira.cookbook.core.User
import dagger.Binds
import dagger.Module
import io.dropwizard.auth.Authenticator

@Module
internal interface AuthModule {
    @Binds
    fun bindsAuthenticator(auth: TrivialAuth): Authenticator<String, User>
}
