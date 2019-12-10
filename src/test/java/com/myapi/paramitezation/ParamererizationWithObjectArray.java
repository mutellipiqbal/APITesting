package com.myapi.paramitezation;


import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import static io.restassured.RestAssured.baseURI;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

@RunWith(DataProviderRunner.class)
public class ParamererizationWithObjectArray {

    @BeforeClass
    public static void init(){
        baseURI="http://api.zippopotam.us";
    }



    @DataProvider
    public static Object[][] data(){
        Object[][] objects= {{"us", "90210","Beverly Hills"}, {"us", "12345", "Schenectady"}, {"ca", "B2R", "Waverley"}};
        return objects;
    }

    @Test
    @UseDataProvider("data")
    public void test(String countryCode, String zipCode, String place){
        given()
                .pathParam("countryCode", countryCode)
                .pathParam("zipCode", zipCode)
                .when()
                .get("/{countryCode}/{zipCode}")
                .then()
                .assertThat()
                .body("places[0].'place name'", equalTo(place));
    }

}
