package com.github.ptrteixeira.cookbook.support.response

import java.time.Duration
import javax.ws.rs.core.NewCookie
import javax.ws.rs.core.Response as WsResponse

object Response {
    fun ok(fn: ResponseDsl.() -> Unit): WsResponse {
        return ResponseDsl(WsResponse.ok())
                .also(fn)
                .build()
    }

    fun status(status: WsResponse.Status, fn: ResponseDsl.() -> Unit): WsResponse {
        return ResponseDsl(WsResponse.status(status))
                .also(fn)
                .build()
    }
}

class ResponseDsl(private val builder: javax.ws.rs.core.Response.ResponseBuilder) {
    // I live in hell
    fun cookie(name: String, value: String, fn: CookieDsl.() -> Unit) {
        builder
                .cookie(CookieDsl(name, value)
                .also(fn)
                .build())
    }

    fun build() = builder.build()
}

class CookieDsl(val name: String, val value: String) {
    var comment: String? = null
    var httpOnly: Boolean? = null
    var secure: Boolean? = null
    var maxAge: Duration? = null

    fun build(): NewCookie {
        val maxAgeSeconds = maxAge?.seconds?.toInt() ?: NewCookie.DEFAULT_MAX_AGE
        return NewCookie(
                NewCookie(name, value),
                comment,
                maxAgeSeconds,
                null,
                secure ?: false,
                httpOnly ?: false)
    }
}