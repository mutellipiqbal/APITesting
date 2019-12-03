package com.myapi.httpRequest;

import base.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetAll extends TestBase {

    //in order to avoid multi repeated method, we use TestBase class for set up environment.
    @Test
    public void getAllStudent() {
        Response response =  given()
                .when().
                        get("/list");
        response.body().prettyPeek();

    }
}
