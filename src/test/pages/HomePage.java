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

    public void signIn(User user) {
        driver.findElement(username).sendKeys(user.getUsername());
        driver.findElement(password).sendKeys(user.getPassword());
        driver.findElement(submit).click();
    }


    // These are here for previous exercises
    public WebElement getUsername() {
        return driver.findElement(By.id("user-name"));
    }
    public WebElement getPassword() {
        return driver.findElement(By.id("password"));
    }
    public WebElement getSubmit() {
        return driver.findElement(By.className("btn_action"));
    }
}
