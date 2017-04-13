package com.github.ptrteixeira.cookbook.resources

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import io.vertx.ext.web.RoutingContext

class Serializer(val objectMapper: ObjectMapper) {
    inline fun <reified In : Any, reified Out : Any> withContext(context: RoutingContext, fn: (In) -> Out) {
        val body: In = objectMapper.readValue(context.bodyAsString)
        val response: Out = fn(body)
        val responseAsString = objectMapper.writeValueAsString(response)

        context.response()
            .putHeader("content-type", "application/json; charset=utf-8")
            .end(responseAsString)
    }

    inline fun <reified Out : Any> withContext(context: RoutingContext, fn: () -> Out) {
        val response: Out = fn()
        val responseAsString = objectMapper.writeValueAsString(response)

        context.response()
            .putHeader("content-type", "application/json; charset=utf-8")
            .end(responseAsString)
    }

    inline fun <reified In : Any> withContextIn(context: RoutingContext, status: Int, fn: (In) -> Unit) {
        val body: In = objectMapper.readValue(context.bodyAsString)
        fn(body)

        context.response()
            .setStatusCode(status)
            .putHeader("content-type", "application/json; charset=utf-8")
            .end()
    }

    inline fun <reified In: Any, reified Out: Any> withContext(context: RoutingContext,
                                                               fn: (In, RoutingContext) -> Out) {
        val body: In = objectMapper.readValue(context.bodyAsString)
        val response: Out = fn(body, context)
        val responseAsString = objectMapper.writeValueAsString(response)

        context.response()
            .putHeader("content-type", "application/json; charset=utf-8")
            .end(responseAsString)
    }

    inline fun <reified Out: Any> withContextOut(context: RoutingContext, fn: (RoutingContext) -> Out) {
        val response = fn(context)
        val responseAsString = objectMapper.writeValueAsString(response)

        context.response()
            .putHeader("content-type", "application/json; charset=utf-8")
            .end(responseAsString)
    }
}
