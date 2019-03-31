package test.data;

import com.github.javafaker.Faker;

public class Person {

    public String firstName;
    public String lastName;
    public String zipCode;
    private static Faker faker = new Faker();

    public static Person random() {
        Person person = new Person();
        person.firstName = faker.name().firstName();
        person.lastName = faker.name().lastName();
        person.zipCode = faker.address().zipCode();

        return person;
    }
}
