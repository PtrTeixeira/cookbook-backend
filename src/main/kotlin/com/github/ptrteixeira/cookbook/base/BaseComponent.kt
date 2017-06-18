package com.github.ptrteixeira.cookbook.base

import com.fasterxml.jackson.databind.ObjectMapper
import dagger.Component

@Component(modules = arrayOf(BaseModule::class))
interface BaseComponent {
    fun objectMapper(): ObjectMapper
}
