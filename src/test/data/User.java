package test.data;

public class User {
    private static String username;
    private static String password;

    public static User valid() {
        username = "standard_user";
        password = "secret_sauce";
        return new User();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
