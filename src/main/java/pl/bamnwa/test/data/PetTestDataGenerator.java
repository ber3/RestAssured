package pl.bamnwa.test.data;

import pl.bamnwa.objects.pet.Category;
import pl.bamnwa.objects.pet.Pet;
import pl.bamnwa.objects.pet.Tag;

import java.util.Collections;

public class PetTestDataGenerator extends TestDataGenerator {
    public Pet generatePet() {
        Category category = new Category();
        category.setId(123L);
        category.setName(faker().name().name());

        Tag tag =new Tag();
        tag.setId(1L);
        tag.setName("cat-category");

        Pet kitty = new Pet();
        kitty.setId(faker().random().nextLong());
        kitty.setCategory(category);
        kitty.setName(faker().name().firstName());
        kitty.setStatus("sold");

        kitty.setPhotoUrls(Collections.singletonList(faker().internet().url()));
        kitty.setTags(Collections.singletonList(tag));
        return kitty;
    }
}
