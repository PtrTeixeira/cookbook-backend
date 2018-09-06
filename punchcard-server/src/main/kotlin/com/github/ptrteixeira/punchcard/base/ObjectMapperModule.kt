package com.github.ptrteixeira.punchcard.base

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import dagger.Module
import dagger.Provides

@Module
internal class ObjectMapperModule {
    @Provides
    fun providesObjectMapper(): ObjectMapper {
        return jacksonObjectMapper()
    }
}