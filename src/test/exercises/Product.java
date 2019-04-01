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
    }

    public static Product fleeceJacket() {
        return new Product();
    }
}
