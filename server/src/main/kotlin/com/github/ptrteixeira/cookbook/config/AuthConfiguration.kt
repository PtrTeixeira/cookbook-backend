package com.github.ptrteixeira.cookbook.config

import java.util.Optional

data class AuthConfiguration(
    val type: AuthType,
    val clientId: Optional<String>
)
