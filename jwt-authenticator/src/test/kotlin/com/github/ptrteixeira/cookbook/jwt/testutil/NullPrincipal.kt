package com.github.ptrteixeira.cookbook.jwt.testutil

import java.security.Principal

class NullPrincipal : Principal {
    override fun getName(): String {
        return ""
    }
}