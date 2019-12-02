package com.myapi.logging;

import base.TestBase;
import io.restassured.http.ContentType;
import model.Student;
import org.junit.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class LoggingResponse extends TestBase {


    @Test
    public void logResponseHeader(){
        given()

                .param("programme", "Computer Science")
                .param("limit", 3)
                .log()
                .parameters()
                .when()
                .get("/list")
                .then()
                .log()
                .headers()
                .statusCode(200);
    }

    @Test
    public void responseStatusLine(){
        given()

                .param("programme", "Computer Science")
                .param("limit", 3)
                .log()
                .parameters()
                .when()
                .get("/list")
                .then()
                .log()
                .status()
                .statusCode(200);
    }

    @Test
    public void responseBody(){
        given()

                .param("programme", "Computer Science")
                .param("limit", 3)
                .log()
                .parameters()
                .when()
                .get("/list")
                .then()
                .log()
                .body()
                .statusCode(200);
    }

    @Test
    public void responseError(){
        given()

                .param("programme", "Computer Science")
                .param("limit", -3)
                .log()
                .parameters()
                .when()
                .get("/list")
                .then()
                .log()
                .ifError();
    }


}
