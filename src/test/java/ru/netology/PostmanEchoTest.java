package ru.netology;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemainClasspath;
import static org.haacrest.Matchers.equalTo;


class PostmanEchoTest {


    @Test
    void shouldSentRequest() {

        // Given - When - Then
        // предусловия
        given()
                .baseUri("https://postman-echo.com/%22)
                        .contentType("text/plain; charset=UTF-8")
                        .body("Ответ на запрос!") // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                        .when()
                        .post("/post")
                        // Проверки
                        .then()
                        .statusCode(200)
                        .body("data", equalTo("Ответ на запрос!"));
    }
}