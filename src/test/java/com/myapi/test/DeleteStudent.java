package com.myapi.test;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeleteStudent {
    @BeforeClass
    public  static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/student";
    }

    @Test
    public void deleteStudent(){


        given()
                .when()
                .delete("/99")
                .then()
                .statusCode(204);

    }
}
