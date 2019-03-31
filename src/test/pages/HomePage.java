package test.pages;

import test.data.User;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;

    public static HomePage visit(WebDriver driver) {
        driver.get("https://www.saucedemo.com/");
        return new HomePage(driver);
    }

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUsername() {
        return driver.findElement(By.id("user-name"));
    }

    public WebElement getPassword() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getSubmit() {
        return driver.findElement(By.className("btn_action"));
    }

    public void signIn(User user) {
        getUsername().sendKeys(user.getUsername());
        getPassword().sendKeys(user.getPassword());
        getSubmit().click();
    }
}
