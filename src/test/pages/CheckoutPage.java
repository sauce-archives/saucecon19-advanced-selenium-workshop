package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.data.Person;


public class CheckoutPage {

    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By zipCode = By.id("postal-code");
    private By submit = By.className("cart_button");

    private WebDriver driver;

    public static CheckoutPage visit(WebDriver driver) {
        driver.get("https://www.saucedemo.com/checkout-step-one.html");
        return new CheckoutPage(driver);
    }

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterInformation() {
        Person person = new Person();

        driver.findElement(firstName).sendKeys(person.firstName);
        driver.findElement(lastName).sendKeys(person.lastName);
        driver.findElement(zipCode).sendKeys(person.zipCode);
        driver.findElement(submit).click();
    }
}
