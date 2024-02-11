package restassured.test.methods.pet;

import org.testng.annotations.Test;
import pl.bamnwa.objects.pet.Category;
import pl.bamnwa.objects.pet.Pet;
import pl.bamnwa.objects.pet.Tag;
import restassured.test.TestBase;

import java.util.Arrays;
import java.util.Collections;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;

public class CreateMultiplePetsTest extends TestBase {
    @Test
    public void createMultiplePetsTest(){

        Pet kitty = createKitty(123L, "mruczek", "sold");
        given()
                .body(kitty)
                .when().post("pet");

        Pet kitty2 = createKitty(321L, "toffi", "sold");

        given()
                .body(kitty2)
                .when().post("pet");

        Pet[] pets = given()
                .queryParam("status", "sold")
                .when().get("pet/findByStatus")
                .then().extract().as(Pet[].class);

        assertTrue(Arrays.asList(pets).size() > 0, "Pets with sold status not in petstore");
    }

    public Pet createKitty(Long id, String name, String status) {
        Category category = new Category();
        category.setId(123L);
        category.setName("Mruczek");

        Tag tag =new Tag();
        tag.setId(1L);
        tag.setName("cat-category");

        Pet kitty = new Pet();
        kitty.setId(id);
        kitty.setCategory(category);
        kitty.setName(name);
        kitty.setStatus(status);

        kitty.setPhotoUrls(Collections.singletonList("URL"));
        kitty.setTags(Collections.singletonList(tag));
        return kitty;
    }
}