package com.github.ptrteixeira.cookbook.base

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.vertx.core.Vertx

@Module
internal class BaseModule {
    @Provides
    fun vertx() = Vertx.vertx()

    @Provides
    @Reusable
    fun objectMapper(): ObjectMapper {
        val objectMapper = jacksonObjectMapper()
        objectMapper.registerModule(Jdk8Module())
        return objectMapper
    }
}
