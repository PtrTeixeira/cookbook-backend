package com.github.ptrteixeira.cookbook

import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import kotlin.coroutines.experimental.suspendCoroutine

/**
 * Helper function for transforming Vert.x's callback base API into an async / await API.
 */
inline suspend fun <T> vx(crossinline callback: (Handler<AsyncResult<T>>) -> Unit) =
    suspendCoroutine<T> { continuation ->
        callback(Handler { result: AsyncResult<T> ->
            when {
                result.succeeded() -> continuation.resume(result.result())
                else -> continuation.resumeWithException(result.cause())
            }
        })
    }
