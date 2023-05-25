package com.jcurotto.AutomationDemo_test.restAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;


import java.io.File;

public class restAssuredTests {
    @Test
    public void testPostAgregarMascota(){
        File agregarMascota = new File("src/test/java/dataProvider/agregarMascota.json");
        File agregarMascotaEsquema = new File("src/test/java/dataProvider/agregarMascotaEsquema.json");

        RestAssured
                .given()
                .baseUri("https://petstore.swagger.io/v2/pet")
                .contentType(ContentType.JSON)
                .body(agregarMascota)
                .when()
                .post()
                .then()
                .statusCode(200)
                .and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(agregarMascotaEsquema));
    }

    @Test
    public void testGetObtenerMascota(){
        File obtenerMascotaEsquema = new File("src/test/java/dataProvider/obtenerMascotaEsquema.json");

        RestAssured
                .given()
                .baseUri("https://petstore.swagger.io/v2/pet/1")
                .contentType("application/json")
                .when()
                .get()
                .then()
                .statusCode(200)
                .and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(obtenerMascotaEsquema));
    }

    @Test
    public void testPutActualizarMascota(){
        File actualizarMascota = new File("src/test/java/dataProvider/actualizarMascota.json");
        File actualizarMascotaEsquema = new File("src/test/java/dataProvider/actualizarMascotaEsquema.json");

        /* given */
        RestAssured
                .given()
                .baseUri("https://petstore.swagger.io/v2/pet")
                .contentType(ContentType.JSON)
                .body(actualizarMascota)
                .when()
                .put()
                .then()
                .statusCode(200)
                .and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(actualizarMascotaEsquema));
    }



    }





