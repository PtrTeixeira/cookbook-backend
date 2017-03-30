package com.github.ptrteixeira.cookbook.resources

import io.vertx.core.http.HttpMethod
import io.vertx.ext.web.Route
import io.vertx.ext.web.Router
import io.vertx.ext.web.RoutingContext


fun withRouter(router: Router): (String, HttpMethod, ((RoutingContext) -> Unit)) -> Route {
    return { path: String, method: HttpMethod, handler ->
        router
            .route(method, path)
            .handler(handler)
    }
}
