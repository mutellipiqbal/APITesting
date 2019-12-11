package com.myapi.responseTime;

import io.restassured.RestAssured;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class ResponseTime {

    String APIKEY="75e3u4sgb2khg673cbv2gjup";

    @BeforeClass
    public static void init(){
        RestAssured.baseURI="http://api.walmartlabs.com";
        RestAssured.basePath="/v1";

    }
    @Test
    public void responseTime(){
        long responseTime= given()
                .queryParam("query", "ipod")
                .queryParam("apikey",APIKEY)
                .queryParam("format","json")
                .when()
                .get("/search")
                .timeIn(TimeUnit.SECONDS);

        System.out.println(responseTime);

    }

    @Test
    public void responseTimeAssert(){
        given()
                .queryParam("query", "ipod")
                .queryParam("apikey",APIKEY)
                .queryParam("format","json")
                .when()
                .get("/search")
                .then()
                .time(lessThan(5L),TimeUnit.SECONDS);

    }
}
