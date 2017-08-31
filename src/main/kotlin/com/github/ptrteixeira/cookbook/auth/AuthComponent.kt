package com.github.ptrteixeira.cookbook.auth

import com.github.ptrteixeira.cookbook.base.BaseComponent
import com.github.ptrteixeira.cookbook.model.User
import dagger.Component
import io.dropwizard.auth.Authenticator
import javax.inject.Named

@Component(modules = arrayOf(AuthModule::class), dependencies = arrayOf(BaseComponent::class))
interface AuthComponent {
    @Named(TOKEN_AUTH)
    fun tokenAuth(): Authenticator<String, User>

    companion object {
        const val TOKEN_AUTH = "com.github.ptrteixeira.cookbook.auth.tokenAuth"
    }
}