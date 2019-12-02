package com.myapi.logging;

import base.TestBase;
import io.restassured.http.ContentType;
import model.Student;
import org.junit.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class LoggingInfo extends TestBase {

    @Test
    public void logHeader(){
        given()
                .log()
                .headers()
                .when()
                .get("/1")
                .then()
                .statusCode(200);
    }
    @Test
    public void logParam(){
        given()

                .param("programme", "Computer Science")
                .param("limit", 3)
                .log()
                .parameters()
                .when()
                .get("/list")
                .then()
                .statusCode(200);
    }

    @Test
    public void logBody(){
        Student student= new Student();
        student.setFirstName("mutellip");
        student.setLastName("ikbal");
        student.setEmail("mutellipikbal@gmail.com");
        student.setProgramme("IT science");

        ArrayList<String> courses= new ArrayList<String>();
        courses.add("Java");
        courses.add("Python");
        courses.add("c++");
        courses.add("JavaScript");

        student.setCourses(courses);
        given()
                .contentType(ContentType.JSON)
                .log()
                .body()
                .when()
                .body(student)
                .post()
                .then();
    }

    @Test
    public void logAll(){
        Student student= new Student();
        student.setFirstName("mutellip");
        student.setLastName("ikbal");
        student.setEmail("mutellipikbal@gmail.com");
        student.setProgramme("IT science");

        ArrayList<String> courses= new ArrayList<String>();
        courses.add("Java");
        courses.add("Python");
        courses.add("c++");
        courses.add("JavaScript");

        student.setCourses(courses);
        given()
                .contentType(ContentType.JSON)
                .log()
                .all()
                .when()
                .body(student)
                .post()
                .then();
    }

    @Test
    public void logFailed(){
        Student student= new Student();
        student.setFirstName("mutellip");
        student.setLastName("ikbal");
        student.setEmail("mutellipikbal@gmail.com");
        student.setProgramme("IT science");

        ArrayList<String> courses= new ArrayList<String>();
        courses.add("Java");
        courses.add("Python");
        courses.add("c++");
        courses.add("JavaScript");

        student.setCourses(courses);
        given()
                .contentType(ContentType.JSON)
                .log()
                .ifValidationFails()
                .when()
                .body(student)
                .post()
                .then()
                .statusCode(201);

        //this code give us an error, because body is already exist.
    }

    @Test
    public void logFailed01(){
        Student student= new Student();
        student.setFirstName("mutellip");
        student.setLastName("ikbal");
        student.setEmail("mutellipi@gmail.com");
        student.setProgramme("IT science");

        ArrayList<String> courses= new ArrayList<String>();
        courses.add("Java");
        courses.add("Python");
        courses.add("c+");
        courses.add("JavaScript");

        student.setCourses(courses);
        given()
                .contentType(ContentType.JSON)
                .log()
                .ifValidationFails()
                .when()
                .body(student)
                .post()
                .then()
                .statusCode(201);

        //this code will pass because we changed some part of body.
    }



}
