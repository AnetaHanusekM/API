package api;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetSingleUser {

    @Before
    public void SetUp() {
        RestAssured.baseURI = "https://reqres.in";
    }

    @Test
    public void CheckIfUserExists(){
        given()
                .when()
                .get("/api/users/2")
                .then()
                .statusCode(200);
    }

}

