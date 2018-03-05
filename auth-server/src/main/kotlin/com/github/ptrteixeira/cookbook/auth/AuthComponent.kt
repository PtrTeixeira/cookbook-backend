package com.github.ptrteixeira.cookbook.auth

import com.github.ptrteixeira.cookbook.auth.resources.LoginResource
import dagger.Component

@Component(modules = arrayOf(AuthModule::class))
interface AuthComponent {
    fun getLoginResource(): LoginResource
}