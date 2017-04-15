package com.github.ptrteixeira.cookbook.integration;

import com.atlassian.oai.validator.restassured.SwaggerValidationFilter;
import io.restassured.filter.Filter;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.github.ptrteixeira.cookbook.MainKt.getRouter;
import static io.restassured.RestAssured.given;

@IntegrationTest
final class ApiTest {
  private static final Vertx vertx = Vertx.vertx();
  private static final HttpServer server = vertx.createHttpServer();
  private static final Filter filter = new SwaggerValidationFilter("api.yml");


  @BeforeAll
  static void startServer() {
    Router router = getRouter(vertx);

    server
        .requestHandler(router::accept)
        .listen(8080);
  }

  @AfterAll
  static void stopServer() {
    server.close();
  }

  @Test
  void itFollowsTheOpenApiSpec() {
    given()
        .filter(filter)
        .when()
        .get("/api/v1/recipes")
        .then()
        .statusCode(200);
  }
}
