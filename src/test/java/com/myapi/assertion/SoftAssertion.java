package com.myapi.assertion;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class SoftAssertion {
    String APIKEY="75e3u4sgb2khg673cbv2gjup";

    @BeforeClass
    public static void init(){
        RestAssured.baseURI="http://api.walmartlabs.com";
        RestAssured.basePath="/v1";

    }
    @Test
    public void softAssertion() {
        given()
                .queryParam("query", "ipod")
                .queryParam("apikey", APIKEY)
                .queryParam("format", "json")
                .when()
                .get("/search")
                .then()
                .body("items.size()", greaterThan(5),
                        "items.size()", equalTo(10));
        //soft assert is instead of providing multiple body statement, we provide a single body statement
    }

}
