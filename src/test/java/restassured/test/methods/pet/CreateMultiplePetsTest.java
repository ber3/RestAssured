package restassured.test.methods.pet;

import org.testng.annotations.Test;
import pl.bamnwa.objects.pet.Pet;
import pl.bamnwa.test.data.PetTestDataGenerator;
import restassured.test.TestBase;

import java.util.Arrays;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;

public class CreateMultiplePetsTest extends TestBase {
    @Test
    public void createMultiplePetsTest(){

        PetTestDataGenerator petTestDataGenerator = new PetTestDataGenerator();
        Pet kitty = petTestDataGenerator.generatePet();

        given()
                .body(kitty)
                .when().post("pet");

        Pet kitty2 = petTestDataGenerator.generatePet();

        given()
                .body(kitty2)
                .when().post("pet");

        Pet[] pets = given()
                .queryParam("status", "sold")
                .when().get("pet/findByStatus")
                .then().extract().as(Pet[].class);

        assertTrue(Arrays.asList(pets).size() > 0, "Pets with sold status not in petstore");
    }
}