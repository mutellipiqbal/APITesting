package com.myapi.reporting;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class SimpleAlluredReport {
    String APIKEY="75e3u4sgb2khg673cbv2gjup";

    @BeforeClass
    public static void init(){
        RestAssured.baseURI="http://api.walmartlabs.com";
        RestAssured.basePath="/v1";

    }
    @Test
    public void simpleReport(){
        given()
                .filter(new AllureRestAssured())
                .queryParam("query", "ipod")
                .queryParam("apikey",APIKEY)
                .queryParam("format","json")
                .when()
                .get("/search")
                .then()
                .statusCode(200);


    }
}
