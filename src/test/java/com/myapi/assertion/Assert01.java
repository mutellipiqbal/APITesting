package com.myapi.assertion;

import io.restassured.RestAssured;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class Assert01 {
    String APIKEY="75e3u4sgb2khg673cbv2gjup";

    @BeforeClass
    public static void init(){
        RestAssured.baseURI="http://api.walmartlabs.com";
        RestAssured.basePath="/v1";

    }
    @Test
    public void jUnitAssert(){
       int itmeNum= given()
                .queryParam("query", "ipod")
                .queryParam("apikey",APIKEY)
                .queryParam("format","json")
                .when()
                .get("/search")
                .then()
                .extract()
                .path("numItems");
        Assert.assertEquals(10, itmeNum);

    }

    @Test
    public void hamcrestAssert01(){
        given()
                .queryParam("query", "ipod")
                .queryParam("apikey",APIKEY)
                .queryParam("format","json")
                .when()
                .get("/search")
                .then()
                .body("numItems", equalTo(10));

    }

    @Test
    public void hamcrestAssert02(){
        given()
                .queryParam("query", "ipod")
                .queryParam("apikey",APIKEY)
                .queryParam("format","json")
                .when()
                .get("/search")
                .then()
                .body("query", equalTo("ipod"));

    }
    @Test
    public void hamcrestHasItem(){
        given()
                .queryParam("query", "ipod")
                .queryParam("apikey",APIKEY)
                .queryParam("format","json")
                .when()
                .get("/search")
                .then()
                .body("items.name", hasItem("Apple iPod touch 7th Generation 32GB - Space Gray (New Model)"));

    }

    @Test
    public void hamcrestHasItems(){
        given()
                .queryParam("query", "ipod")
                .queryParam("apikey",APIKEY)
                .queryParam("format","json")
                .when()
                .get("/search")
                .then()
                .body("items.name", hasItems("Apple iPod touch 7th Generation 32GB - Space Gray (New Model)", "Refurbished Apple iPod Touch 6th Generation 16GB"));
        //hasitem checks a single value. Hasitems check multiple value.

    }



}
