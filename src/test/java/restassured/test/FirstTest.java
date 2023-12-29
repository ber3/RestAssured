package restassured.test;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class FirstTest {
    @Test
    public void givenNonExistingPetIdWhenGetPetThenPetNotFoundTest() {
        given().when().get("https://petstore.swagger.io/v2/pet/0").then().statusCode(404);
    }
}
