package com.myapi.RequestAndResponseSpecification;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class ResponseSpec01 {

    static String APIKEY="75e3u4sgb2khg673cbv2gjup";
    static RequestSpecBuilder requestSpecBuilder;
    static RequestSpecification requestSpecification;
    static ResponseSpecBuilder responseSpecBuilder;
    static ResponseSpecification responseSpecification;

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

        responseSpecBuilder= new ResponseSpecBuilder();
        responseSpecBuilder.expectHeader("Content-Type","application/json; charset=utf-8");
        responseSpecBuilder.expectStatusCode(200);
        responseSpecBuilder.expectBody("query",equalTo("ipod"));
        responseSpecBuilder.expectBody("numItems",equalTo(10));
        responseSpecBuilder.expectBody("items.name",hasItem("Refurbished Apple iPod Touch 5th gen 16GB WiFi MP3 MP4 Digital Music Video Player MGG82LL/A"));

        responseSpecification= responseSpecBuilder.build();

    }
    @Test
    public void requestSpec(){
        given()
                .spec(requestSpecification)
                .when()
                .get("/search")
                .then()
                .spec(responseSpecification);
    }
}
