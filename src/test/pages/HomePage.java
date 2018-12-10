package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.base.Base;

public class HomePage extends Base {
    private WebDriver driver;

    private By menu = By.cssSelector("#menu_button_container");

    public HomePage(WebDriver driver) {this.driver = driver; }

    //public Boolean isSignedIn() { return driver.findElements(menu).size > 0; }
}
