package com.myapi.RequestAndResponseSpecification;

import io.restassured.RestAssured;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class RequestSpecific01 {

    static String APIKEY="75e3u4sgb2khg673cbv2gjup";
    static RequestSpecBuilder requestSpecBuilder;
    static RequestSpecification requestSpecification;

    @BeforeClass
    public static void init(){
        RestAssured.baseURI="http://api.walmartlabs.com";
        RestAssured.basePath="/v1";

        requestSpecBuilder= new RequestSpecBuilder();

       requestSpecBuilder.addQueryParam("query", "ipod");
        requestSpecBuilder.addQueryParam("apiKey", APIKEY);
        requestSpecBuilder.addQueryParam("format", "json");
        requestSpecBuilder.addQueryParam("facet", "on");
        requestSpecBuilder.addHeader("Accept", "*/*");

        requestSpecification= requestSpecBuilder.build();

    }
    @Test
    public void requestSpec(){
        given()
                // instead of using queryParam inside the every method, we use RequestSpecBuilder class in the Rest Assured Library.
                // put query, query param , header, cockies etc inside the set up method.
                .spec(requestSpecification)

                .when()
                .get("/search")
                .then()
                .log()
                .all();
    }
}
