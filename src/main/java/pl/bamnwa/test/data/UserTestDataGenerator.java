package pl.bamnwa.test.data;

import pl.bamnwa.objects.user.User;

public class UserTestDataGenerator extends TestDataGenerator {
    public User generateUser() {
        User user = new User();
        user.setEmail(faker().internet().emailAddress());
        user.setPhone(faker().phoneNumber().phoneNumber());
        user.setId(113);
        user.setFirstName(faker().name().firstName());
        user.setPassword("test123test");
        user.setUsername(faker().name().username());
        user.setUserStatus(1);
        return user;
    }
}
