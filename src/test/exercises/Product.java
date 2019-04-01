package test.exercises;

//
// Exercise:
// implement this Data class with
// 1. intelligent default
// 2. fleece Jacket information
//

public class Product {
    public String name;
    public String price;

    public Product() {
        this.name = "Sauce Labs Backpack";
        this.price = "29.99";
    }

    public static Product fleeceJacket() {
        Product product = new Product();
        product.name = "Sauce Labs Fleece Jacket";
        product.price = "49.99";

        return product;
    }
}
