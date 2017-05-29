package com.github.ptrteixeira.cookbook.base

import com.fasterxml.jackson.databind.ObjectMapper
import dagger.Component
import io.vertx.core.Vertx

@Component(modules = arrayOf(BaseModule::class))
interface BaseComponent {
    fun vertx(): Vertx
    fun objectMapper(): ObjectMapper
}
