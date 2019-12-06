package com.myapi.httpRequest;

import io.restassured.response.Response;
import model.Student;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class StudentPostTest {
    @BeforeClass
    public  static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/student";
    }

    @Test
    public void createNewStudent(){
        Student student= new Student();
        student.setFirstName("mutellip");
        student.setLastName("ikbal");
        student.setEmail("ikbal@gmail.com");
        student.setProgramme("IT science");

        ArrayList<String> courses= new ArrayList<String>();
        courses.add("Java");
        courses.add("Python");
        courses.add("c++");

        student.setCourses(courses);

       given()
                .contentType(ContentType.JSON)
                .when()
                .body(student)
                .post()
                .then()
                .statusCode(201);

    }
}
