package com.myapi.jsonPath;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Extract01 {
    //key: 75e3u4sgb2khg673cbv2gjup
    //http://api.walmartlabs.com/v1/search?query=ipod&format=json&apiKey=75e3u4sgb2khg673cbv2gjup
     String APIKEY="75e3u4sgb2khg673cbv2gjup";

    @BeforeClass
    public static void init(){
        RestAssured.baseURI="http://api.walmartlabs.com";
        RestAssured.basePath="/v1";

    }

    @Test
    public void getItems(){
        given()
                .queryParam("query", "ipod")
                .queryParam("apikey",APIKEY)
                .queryParam("format","json")
                .when()
                .get("/search")
                .then()
                .log()
                .body();

    }

    @Test
    public void getNumItems(){
        int numItems=given()
                .queryParam("query", "ipod")
                .queryParam("apikey",APIKEY)
                .queryParam("format","json")
                .when()
                .get("/search")
                .then()
                .extract()
                .path("numItems");

        System.out.println(numItems);

    }

    @Test
    public void getQueryItems(){
        String queryItems=given()
                .queryParam("query", "ipod")
                .queryParam("apikey",APIKEY)
                .queryParam("format","json")
                .when()
                .get("/search")
                .then()
                .extract()
                .path("query");

        System.out.println(queryItems);

    }

    @Test
    public void getInArrayItems(){
        String arrayItems=given()
                .queryParam("query", "ipod")
                .queryParam("apikey",APIKEY)
                .queryParam("format","json")
                .when()
                .get("/search")
                .then()
                .extract()
                .path("items[1].name");

        System.out.println(arrayItems);

    }

    @Test
    public void getInArrayItems02() {
        HashMap<String, String> giftOptions = given()
                .queryParam("query", "ipod")
                .queryParam("apikey", APIKEY)
                .queryParam("format", "json")
                .when()
                .get("/search")
                .then()
                .extract()
                .path("items[0].giftOptions");

        System.out.println(giftOptions);
    }

    @Test
    public void getArraySize() {
        int arraySize = given()
                .queryParam("query", "ipod")
                .queryParam("apikey", APIKEY)
                .queryParam("format", "json")
                .when()
                .get("/search")
                .then()
                .extract()
                .path("items.size()");

        System.out.println(arraySize);
    }

    @Test
    public void getItemList() {
        List<String> ls = given()
                .queryParam("query", "ipod")
                .queryParam("apikey", APIKEY)
                .queryParam("format", "json")
                .when()
                .get("/search")
                .then()
                .extract()
                .path("items.name");

        System.out.println(ls);
    }



}
