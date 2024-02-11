package pl.bamnwa.objects.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    public Integer id;
    public String username;
    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public String phone;
    public Integer userStatus;
}
