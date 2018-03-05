package com.github.ptrteixeira.cookbook.core

import java.security.Principal

data class User(
        val id: String,
        val googleId: String? = null,
        val userName: String? = null
) : Principal {
    override fun getName(): String = id
}
