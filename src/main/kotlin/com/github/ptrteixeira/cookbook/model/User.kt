package com.github.ptrteixeira.cookbook.model

import java.security.Principal

data class User(val id: String): Principal {
    override fun getName(): String  = id
}
