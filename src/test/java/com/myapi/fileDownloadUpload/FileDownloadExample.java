package com.myapi.fileDownloadUpload;

import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
public class FileDownloadExample {

    //https://github.com/mozilla/geckodriver/releases/download/v0.26.0/geckodriver-v0.26.0-linux32.tar.gz
    @Test
    public  void downloadCompare(){
        File file= new File(System.getProperty("user.dir")+File.separator+"geckodriver-v0.26.0-linux32.tar.gz");
        long fileSize= file.length();
        System.out.println(fileSize);

        byte[] actualSize= given()
                .when()
                .get("https://github.com/mozilla/geckodriver/releases/download/v0.26.0/geckodriver-v0.26.0-linux32.tar.gz")
                .then()
                .extract()
                .asByteArray();
        long last= actualSize.length;

        assertThat(fileSize, equalTo(last));
    }
}
