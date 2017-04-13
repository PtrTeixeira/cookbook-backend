package com.github.ptrteixeira.cookbook.integration

import com.atlassian.oai.validator.restassured.SwaggerValidationFilter
import com.github.ptrteixeira.cookbook.getRouter
import io.restassured.RestAssured.given
import io.vertx.core.Vertx
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

@IntegrationTest
class ApiSpec {
    val SWAGGER_SPEC = SwaggerValidationFilter("api.yml")

    @Test
    fun itFollowsTheOpenApiSpec() {
        given()
            .filter(SWAGGER_SPEC)
            .`when`()
            .get("/api/v1/recipes")
            .then()
            .statusCode(200)
    }

    companion object {
        val vertx = Vertx.vertx()
        val server = vertx.createHttpServer()

        @BeforeAll
        @JvmStatic
        fun startServer() {
            val router = getRouter(vertx)

            server
                .requestHandler(router::accept)
                .listen(8080)
        }

        @AfterAll
        @JvmStatic
        fun shutDownServer() {
            server
                .close()
        }
    }
}
