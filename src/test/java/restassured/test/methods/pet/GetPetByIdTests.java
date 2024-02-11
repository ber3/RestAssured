package restassured.test.methods.pet;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pl.bamnwa.objects.pet.Pet;
import restassured.test.TestBase;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class GetPetByIdTests extends TestBase {
    @Parameters("petId")
    @Test
    public void getPetById(@Optional("123") String petId){

        Pet pet = given()
                .when().get("pet/{petId}", petId)
                .then().extract().as(Pet.class);

        assertEquals(petId, pet.getId(), "Pet id is not correct");
    }
}
