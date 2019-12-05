package com.myapi.jsonPath;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Extract02 {

        String APIKEY="75e3u4sgb2khg673cbv2gjup";

    @BeforeClass
    public static void init(){
        RestAssured.baseURI="http://api.walmartlabs.com";
        RestAssured.basePath="/v1";

    }

    @Test
    public void findSomeItems() {
        List<HashMap<String, Object>> ls = given()
                .queryParam("query", "ipod")
                .queryParam("apikey", APIKEY)
                .queryParam("format", "json")
                .when()
                .get("/search")
                .then()
                .extract()
                .path("items.findAll{it.name=='Apple iPod Touch 6th Generation 16GB Refurbished'}");

        System.out.println(ls);
    }

    @Test
    public void sellPrice() {
        List<Float> ls = given()
                .queryParam("query", "ipod")
                .queryParam("apikey", APIKEY)
                .queryParam("format", "json")
                .when()
                .get("/search")
                .then()
                .extract()
                .path("items.findAll{it.name=='Apple iPod Touch 6th Generation 16GB Refurbished'}.salePrice");

        System.out.println(ls);
    }

    @Test
    public void sellPriceList() {
        List<String> ls = given()
                .queryParam("query", "ipod")
                .queryParam("apikey", APIKEY)
                .queryParam("format", "json")
                .when()
                .get("/search")
                .then()
                .extract()
                .path("items.findAll{it.salePrice>150}.name");

        System.out.println(ls);
    }

    @Test
    public void startWithFinding() {
        List<String> ls = given()
                .queryParam("query", "ipod")
                .queryParam("apikey", APIKEY)
                .queryParam("format", "json")
                .when()
                .get("/search")
                .then()
                .extract()
                .path("items.findAll{it.name==~/Ref.*/}.msrp");

        System.out.println(ls);
    }
    @Test
    public void endsWithFinding() {
        List<String> ls = given()
                .queryParam("query", "ipod")
                .queryParam("apikey", APIKEY)
                .queryParam("format", "json")
                .when()
                .get("/search")
                .then()
                .extract()
                .path("items.findAll{it.name==~/.*ed/}.salePrice");

        System.out.println(ls);
    }
}
