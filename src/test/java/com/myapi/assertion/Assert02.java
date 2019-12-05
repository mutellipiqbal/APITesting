package com.myapi.assertion;

import io.restassured.RestAssured;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Assert02 {

    String APIKEY="75e3u4sgb2khg673cbv2gjup";

    @BeforeClass
    public static void init(){
        RestAssured.baseURI="http://api.walmartlabs.com";
        RestAssured.basePath="/v1";

    }
    @Test
    public void hasKeyInMap(){
        given()
                .queryParam("query", "ipod")
                .queryParam("apikey",APIKEY)
                .queryParam("format","json")
                .when()
                .get("/search")
                .then()
                .body("items[0].imageEntities[0]",hasKey("entityType"));
    }
    @Test
    public void keyValueEntry() {
        given()
                .queryParam("query", "ipod")
                .queryParam("apikey", APIKEY)
                .queryParam("format", "json")
                .when()
                .get("/search")
                .then()
                .body("items.findAll{it.name=='Apple iPod Touch 6th Generation 16GB Refurbished'}",hasItems(hasEntry("name","Apple iPod Touch 6th Generation 16GB Refurbished")));
    }

    @Test
    public void multipleAssertion() {
        given()
                .queryParam("query", "ipod")
                .queryParam("apikey", APIKEY)
                .queryParam("format", "json")
                .when()
                .get("/search")
                .then()
                .body("items[0].imageEntities[0]",hasKey("entityType"))
                .body("numItems", equalTo(10))
                .statusCode(200);
    }

    @Test
    public void logicalAssertion() {
        given()
                .queryParam("query", "ipod")
                .queryParam("apikey", APIKEY)
                .queryParam("format", "json")
                .when()
                .get("/search")
                .then()
                .body("items.size()",greaterThan(5))
                .body("items.size()",lessThan(11))
                .body("items.size()",greaterThanOrEqualTo(10))
                .body("items.size()",lessThanOrEqualTo(10));
    }


}
