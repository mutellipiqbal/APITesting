package com.myapi.addCookie;

import io.restassured.http.Cookie;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class AddingCookies {

    @Test
    public void whenUseCookie_thenOK() {

        given().cookie("session_id", "1234").when().get("/users/eugenp")
                .then().statusCode(200);
    }

    //We can also customize our cookie using cookie Builder:
    @Test
    public void whenUseCookieBuilder_thenOK() {
        Cookie myCookie = new Cookie.Builder("session_id", "1234")
                .setSecured(true)
                .setComment("session id cookie")
                .build();

        Cookie myCookie01 = new Cookie.Builder("session_id", "1234").build();


        given().cookie(myCookie)
                .when().get("/users/eugenp")
                .then().statusCode(200);
    }
}
