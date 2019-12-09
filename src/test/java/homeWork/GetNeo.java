package homeWork;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class GetNeo {

    @BeforeClass
    public static void init(){
        baseURI="http://www.neowsapp.com/";
        basePath="/rest/v1/neo";

    }

    @Test
    public void getAll(){
        Response response=given()
                .when()
                .get("/browse");
        response.prettyPrint();
    }
    @Test
    public void getNeoList(){
       List<String> list= given()
                .when()
                .get("/browse")
                .then()
                .extract()
                .path("near_earth_objects");

       System.out.println(list);
    }


    @Test
    public void getNeoLinks(){
        List<Integer> list= given()
                .when()
                .param("orbit", "earth")
                .param("limit", 3)
                .get("/browse")
                .then()
                .extract()
                .path("near_earth_objects");

        System.out.println(list);
    }

    @Test
    public void getNeoListSize(){
        int size= given()
                .when()
                .get("/browse")
                .then()
                .extract()
                .path("near_earth_objects.size()");

        System.out.println(size);
    }

    @Test
    public void getNeoListUsingMap01(){
        Map<String, Object> orbitalData= given()
                .when()
                .get("/browse")
                .then()
                .extract()
                .path("near_earth_objects[0].orbital_data.orbit_class");

        System.out.println(orbitalData);
    }

    @Test
    public void getNeoListUsingMap02(){
        Map<String, Object> orbitalData= given()
                .when()
                .get("/browse")
                .then()
                .extract()
                .path("near_earth_objects[0].orbital_data");

        System.out.println(orbitalData);
    }




}
