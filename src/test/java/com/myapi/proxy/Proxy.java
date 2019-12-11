package com.myapi.proxy;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.ProxySpecification;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.proxy;

public class Proxy {
    @BeforeClass
    public  static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/student";

        // first way: using proxy
        proxy("localhost",555);
    }

    @Test
    public void sendProxy(){
        // second way is using proxy method inside the method
        Response response=given()
                .when().
                        proxy("localhost", 5555).
                        param("programme","Financial Analysis").
                        param("limit",3).
                        get("/list");
        response.body().prettyPrint();
    }

    @Test
    public void proxySpec(){
        //third way: using ProxySpecification class
        ProxySpecification rs= new ProxySpecification("localhost", 5555,"http");
        Response response=given()
                .when().
                        proxy(rs).
                        param("programme","Financial Analysis").
                        param("limit",3).
                        get("/list");
        response.body().prettyPrint();
    }
}
