package com.myapi.grouping;

import base.TestBase;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static io.restassured.RestAssured.given;

public class Tagging extends TestBase {
    //in JUnit we do not have tags for grouping, instead we have category annotation.
    //first we need to create interface as tag name. For example, if we need to create tag name as smoke test, we need to create interface of that name.
    //we use category annotation, inside it we put interface name just like below.
    // then find maven sure fire configuration part inside the pom file, and open a tag like <groups>${group}<groups>
    //then inside the property part of the pom file, we need to open a tag like <groups>com.myapi.grouping.SmokeTest<groups>

    //if we need to run our framework by command line, we dont nee to put property block
    //then run the framework with th code below
    //mvn clean test -Dgroup=com.myapi.grouping.SmokeTest

    //if we want to run the test with two or more tags, we use following command line
    //@Category({SmokeTest.class, ResgressionTest.class})
    //mvn clean test -Dgroup="com.myapi.grouping.SmokeTest, com.myapi.grouping.RegressionTest"

    @Category(SmokeTest.class)
    @Test
    public void getAllStudent() {
        Response response =  given()
                .when().
                        get("/list");
        response.body().prettyPeek();

    }

}
