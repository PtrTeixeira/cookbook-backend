package com.github.ptrteixeira.cookbook.auth

import com.github.ptrteixeira.cookbook.model.User
import dagger.Component
import io.dropwizard.auth.Authenticator
import io.dropwizard.auth.basic.BasicCredentials

@Component(modules = arrayOf(AuthModule::class))
interface AuthComponent {
    fun auth(): Authenticator<BasicCredentials, User>
}
