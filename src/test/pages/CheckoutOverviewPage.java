package test.pages;

import org.openqa.selenium.WebDriver;
import test.data.Person;


public class CheckoutOverviewPage {

    private WebDriver driver;

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public Boolean onPage() {
        return driver.getCurrentUrl().equals("https://www.saucedemo.com/checkout-step-two.html");
    }
}
