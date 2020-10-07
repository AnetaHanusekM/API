package api;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class CreateNewOrder {

    @Before
    public void SetUp() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }
    @Test
    public void CreateNewOrder() {
        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("id", 1005);
        jsonAsMap.put("petId", 48);
        jsonAsMap.put("quantity", 1);
        jsonAsMap.put("shipDate", "2020-10-04T07:16:06.278Z");
        jsonAsMap.put("status", "placed");
        jsonAsMap.put("complete", true);
        given()
                .when()
                .contentType("application/json")
                .body(jsonAsMap)
                .post("/store/order")
                .then()
                .statusCode(200);
    }

    @Test
    public void FindPlacedOrder() {

        given()
                .when()
                .get("/store/order/1005")
                .then()
                .statusCode(404);
    }

    @Test
    public void DeletePlacedOrder() {

        given()
                .when()
                .delete("/store/order/1005")
                .then()
                .statusCode(200);
    }

    @Test
    public void DeleteNonexistentOrder() {

        given()
                .when()
                .delete("/store/order/1005")
                .then()
                .statusCode(404);
    }

    @Test
    public void CreateOrderWhitInvalidInput() {

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("id", 1005);
        jsonAsMap.put("petId", 48);
        jsonAsMap.put("quantity", 1);
        jsonAsMap.put("shipDate", "2020-10-03T07:16:06.278Z");
        jsonAsMap.put("status", "placed");
        jsonAsMap.put("complete", true);
        given()
                .when()
                .contentType("application/json")
                .body("string")
                .post("/store/order")
                .then()
                .statusCode(400);
    }

    }

