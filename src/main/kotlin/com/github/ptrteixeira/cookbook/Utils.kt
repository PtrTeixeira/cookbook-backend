package com.github.ptrteixeira.cookbook

import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.http.HttpMethod
import io.vertx.ext.web.Route
import io.vertx.ext.web.Router
import io.vertx.ext.web.RoutingContext
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

fun withRouter(router: Router): (String, HttpMethod, ((RoutingContext) -> Unit)) -> Route  {
    return { path: String, method: HttpMethod, handler ->
        router
            .route(method, path)
            .handler(handler)
    }
}
