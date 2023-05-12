package com.jcurotto.AutomationDemo_test.restAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import com.jcurotto.AutomationDemo_test.general.CONSTANTS;
import dataProvider.restDataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class basicRestAssuredTests {
    @Test
    public void testGetUsers(){

        String body= given()
                        .log()
                        .all()
                        .when()
                        .get(CONSTANTS.API_ENDPOINT_USERS)
                        .then()
                        .statusCode(200)
                        .extract()
                        .body()
                        .asString();
        System.out.println(body);
    }

    @Test
    public void verifyIfUserExists(){

        String body= given()
                .when()
                .get(CONSTANTS.API_ENDPOINT_USERS)
                .then()
                .statusCode(200)
                .body("data[1].first_name", equalTo("Janet"))
                .extract()
                .asString();
    }

    @Test(dataProvider="DataProvider", dataProviderClass = restDataProvider.class)
    public void createUser(String pName, String pJob){

        Map<String, Object> mapa = new HashMap<String,Object>();
        mapa.put("name",pName);
        mapa.put("job",pJob);
        given().log().all()
                .body(mapa.toString())
                .when()
                .post(CONSTANTS.API_ENDPOINT_USERS)
                .then()
                .log().all()
                .statusCode(201);
    }



}
