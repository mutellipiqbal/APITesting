package com.myapi.paramitezation;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class ParameterizedPath {

    @BeforeClass
    public static void init(){

        //http://restcountries.eu/rest/v1/name/Finland
        RestAssured.baseURI="http://restcountries.eu";
        RestAssured.basePath="/rest/v1";
    }

    @Test
    public void pathParam(){
        given()
                .pathParam("country", "Finland")
                .contentType("json")
                .when()
                .get("/name/{country}")
                .then()
                .statusCode(200);

        // we can do multiple parameterization like below code
        /*
        given().pathParams("owner", "eugenp", "repo", "tutorials")
        .when().get("/repos/{owner}/{repo}")
        .then().statusCode(200);

        given().pathParams("owner", "eugenp")
        .when().get("/repos/{owner}/{repo}","tutorials")
        .then().statusCode(200);
         */

        //note: we can also do parameterization queryParam and param.


    }
}
