package test.data;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Map;

public class User {
    private String username;
    private String password;

    public static User validUser() {
        Map<String, String> data = new HashMap<String, String>();
        data.put("username", "standard_user");
        data.put("password", "secret_saucer");
        return new User(data);
    }

    public static User blankPassword() {
        Map<String, String> data = new HashMap<String, String>();
        data.put("password", "");
        return new User(data);
    }

    public static User invalidUser() {
        return new User();
    }

    public static User randomUser() {
        return new User();
    }

    public User() {
        Faker faker = new Faker();
        this.username = faker.internet().emailAddress();
        this.password = faker.internet().password();
    }

    public User(Map<String, String> data) {
        username = data.get("username");
        password = data.get("password");

        Faker faker = new Faker();
        this.username = (username != null) ? username : faker.internet().emailAddress();
        this.password = (password != null) ? password : faker.internet().password();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}


