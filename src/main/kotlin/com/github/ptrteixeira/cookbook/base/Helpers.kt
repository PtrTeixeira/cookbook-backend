package com.github.ptrteixeira.cookbook.base

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

internal fun objectMapper(): ObjectMapper {
    val objectMapper = jacksonObjectMapper()
    objectMapper.registerModule(Jdk8Module())
    return objectMapper
}
