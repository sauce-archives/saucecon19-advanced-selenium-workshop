package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    private By sauceBot = By.className("peek");

    public HomePage(WebDriver driver) {this.driver = driver; }

    public Boolean isSignedIn() {
        return driver.findElements(sauceBot).size() > 0; }
}
