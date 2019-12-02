package base;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.BeforeClass;

import static io.restassured.RestAssured.given;
public class TestBase {
    @BeforeClass
    public  static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/student";
    }
}
