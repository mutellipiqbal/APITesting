package com.myapi.rootPath;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class RootPath {
    String APIKEY="75e3u4sgb2khg673cbv2gjup";

    @BeforeClass
    public static void init(){
        RestAssured.baseURI="http://api.walmartlabs.com";
        RestAssured.basePath="/v1";

    }

    @Test
    public void rootPath() {

        // root path mean is find common path value and separate it from body and put inside root method.

        // we can also sperate the root path from method, put it inside the set up method with BaseURI and BasePath
        // just like : RestAssured.rootPath="***";

        given()
                .queryParam("query", "ipod")
                .queryParam("apikey", APIKEY)
                .queryParam("format", "json")
                .when()
                .get("/search")
                .then()
//                .body("items.size()",greaterThan(5))
//                .body("items.size()",lessThan(11))
//                .body("items.size()",greaterThanOrEqualTo(10))
//                .body("items.size()",lessThanOrEqualTo(10));
                .rootPath("items")
                .body("size()",greaterThan(5))
               .body("size()",lessThan(11))
               .body("size()",greaterThanOrEqualTo(10))
               .body("size()",lessThanOrEqualTo(10));
    }
}
