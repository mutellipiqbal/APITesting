package com.myapi.authentication;

import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class TokenAuth {

    //7873677866f8cc4238a9c7094d2b39e87bcf434b
    String apiKey= "7873677866f8cc4238a9c7094d2b39e87bcf434b";
    //https://sandbox.zamzar.com/v1/jobs

    @Test
    public void upload(){

        File file= new File(System.getProperty("user.dir")+File.separator+"apple.gif");
        given()
                .auth()
                .basic(apiKey,"")
                .multiPart("source_file", file)
                .multiPart("target_format","png")
                .when()
                .post("https://sandbox.zamzar.com/v1/jobs")
                .then()
                .log()
                .all();
    }
}
