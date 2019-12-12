package com.myapi.jsonToJava;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class JsonConverteing {

    public static void main(String[] args) {
        Model model=getModel();
        System.out.println(model);
    }

    public static Model getModel(){
        String res="{\"firstName\":\"Orson\",\"lastName\":\"Armando\",\"email\":\"nascetur@conguea.com\",\"programme\":\"Computer Science\",\"courses\":[\"Calculus,Algorithms,Software Development,Ethics\"]}";

        Gson gson= new Gson();
        Model model= gson.fromJson(res, Model.class);
        return model;
    }




}
