package com.github.ptrteixeira.cookbook.integration;

import com.atlassian.oai.validator.restassured.SwaggerValidationFilter;
import com.github.ptrteixeira.cookbook.ApplicationComponent;
import com.github.ptrteixeira.cookbook.DaggerApplicationComponent;
import com.github.ptrteixeira.cookbook.base.BaseComponent;
import com.github.ptrteixeira.cookbook.base.DaggerBaseComponent;
import com.github.ptrteixeira.cookbook.data.DataComponent;
import com.github.ptrteixeira.cookbook.resources.DaggerResourcesComponent;
import com.github.ptrteixeira.cookbook.resources.ResourcesComponent;
import io.restassured.filter.Filter;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;
import org.elasticsearch.client.transport.TransportClient;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@IntegrationTest
final class ApiTest {
  private static final Filter filter = new SwaggerValidationFilter("api.yml");
  private static TransportClient transportClient;
  private static HttpServer server;


  @BeforeAll
  static void startServer() {
    BaseComponent baseComponent = DaggerBaseComponent.create();
    DataComponent dataComponent = DaggerMockDataComponent.create();
    ResourcesComponent resourcesComponent = DaggerResourcesComponent
        .builder()
        .baseComponent(baseComponent)
        .dataComponent(dataComponent)
        .build();
    ApplicationComponent applicationComponent = DaggerApplicationComponent
        .builder()
        .baseComponent(baseComponent)
        .resourcesComponent(resourcesComponent)
        .build();

    transportClient = dataComponent.elasticSearchClient();
    server = applicationComponent.server();
    Router router = applicationComponent.parentRouter();

    applicationComponent
        .server()
        .requestHandler(router::accept)
        .listen(8080);
  }

  @AfterAll
  static void stopServer() {
    server.close();
    transportClient.close();
  }

  @Test
  void itSendsAListOfAllRecipes() {
    given()
        .filter(filter)
        .when()
        .get("/api/v1/recipes")
        .then()
        .statusCode(200);
  }

  @Test
  void whenRecipeIsPresentItSendsASingleRecipe() {
    given()
        .filter(filter)
        .when()
        .get("/api/v1/recipes/0000")
        .then()
        .statusCode(200);
  }

  @Test
  void whenRecipeIsMissingItSends404ResponseToGet() {
    given()
        .filter(filter)
        .when()
        .get("/api/v1/recipes/12345")
        .then()
        .statusCode(404);
  }

  @Test
  void whenRecipeIsPresentItAllowsRecipesToBeDeleted() {
    given()
        .filter(filter)
        .when()
        .delete("/api/v1/recipes/0000")
        .then()
        .statusCode(204);
  }

  @Test
  void whenRecipeIsMissingItSends404ResponseToDelete() {
    given()
        .filter(filter)
        .when()
        .delete("/api/v1/recipes/12345")
        .then()
        .statusCode(404);
  }
}
