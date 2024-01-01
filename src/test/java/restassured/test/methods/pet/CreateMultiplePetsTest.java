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
        Category category = new Category();
        category.setId(123L);
        category.setName("Mruczek");

        Tag tag =new Tag();
        tag.setId(1L);
        tag.setName("dogs-category");

        Pet kitty = new Pet();
        kitty.setCategory(category);
        kitty.setName("Malutki");
        kitty.setStatus("sold");

        kitty.setPhotoUrls(Collections.singletonList("URL"));
        kitty.setTags(Collections.singletonList(tag));

        given()
                .body(kitty).contentType("application/json")
                .when().post("pet")
                .then().statusCode(200);

        Category category2 = new Category();
        category.setId(777L);
        category.setName("Mruczek");

        Tag tag2 =new Tag();
        tag.setId(165L);
        tag.setName("dogs-category");

        Pet kitty2 = new Pet();
        kitty2.setCategory(category2);
        kitty2.setName("Malutki");
        kitty2.setStatus("wolny");

        kitty2.setPhotoUrls(Collections.singletonList("URL"));
        kitty2.setTags(Collections.singletonList(tag2));

        given()
                .body(kitty2).contentType("application/json")
                .when().post("pet")
                .then().statusCode(200);

        Pet[] pets = given()
                .contentType("application/json")
                .queryParam("status", "sold")
                .when().get("pet/findByStatus")
                .then().statusCode(200).extract().as(Pet[].class);

        assertTrue(Arrays.asList(pets).size() > 0, "Empty");
    }
}
