package com.myapi.httpRequest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class GetAllStudent {

    @BeforeClass
    public  static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/student";
    }

    @Test
    public void getAllStudent() {
        Response response =  given()
                .when().
                 get("/list");
        System.out.println(response.body().toString());

    }

    @Test
    public void getAstudentInfo(){
        Response response=given()
                .when().
                        get("/4");
        response.body().prettyPeek();
    }

    @Test
    public void getAstudent(){
        Response response=given()
                .when().
                get("/1");
       response.body().prettyPrint();
    }

    @Test
    public void sendParam(){
        Response response=given()
                .when().
                        param("programme","Financial Analysis").
                        param("limit",3).
                        get("/list");
        response.body().prettyPrint();
    }

    @Test
    public void validateStatusCode(){
        given()
                .when().
                get("/list")
                .then()
                .statusCode(200);
    }

}
