package test.data;

public class Product {
    private static String name;

    public static Product valid() {
        name = "Sauce Labs Bike Light";
        return new Product();
    }

    public String getName() {
        return name;
    }
}
