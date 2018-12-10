package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.data.*;

public class SignInPage {
    private WebDriver driver;

    private By userField = By.cssSelector("input[data-test='username']");
    private By passwordField = By.cssSelector("input[data-test='password']");
    private By loginButton = By.className("login-button");
    private By error = By.className("fa-times-circle");

    public static SignInPage visit(WebDriver driver) {
        SignInPage page = new SignInPage(driver);
        driver.get("https://www.saucedemo.com");
        return page;
    }

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void signIn(User data) { fillForm(data); }

    public void signInUnsuccessfully(User data) {
        fillForm(data);
    }

    public Boolean hasErrorMessage() {
        return driver.findElements(error).size() > 0;
    }

    private void fillForm(User data) {
        driver.findElement(userField).sendKeys(data.getUsername());
        driver.findElement(passwordField).sendKeys(data.getPassword());
        driver.findElement(loginButton).click();

    }
}
