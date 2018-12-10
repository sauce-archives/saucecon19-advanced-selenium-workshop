package test.authentication;

import junit.framework.TestCase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.base.BaseSauce;
import test.data.User;

import java.util.HashMap;
import java.util.Map;

public class LogInTest extends BaseSauce {

    @Test
    public void signInSuccessfully() {
        driver.get("https://www.saucedemo.com");

        String username = "standard_user";
        String password = "secret_sauce";

        WebDriverWait explicitWait = new WebDriverWait(driver, 10);

        WebElement usernameElement = explicitWait.until(
                ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-test='username']")));

        usernameElement.sendKeys(username);
        driver.findElement(By.cssSelector("[data-test='password']")).sendKeys(password);
        driver.findElement(By.className("login-button")).submit();

        Boolean result = explicitWait.until(ExpectedConditions.urlMatches("https://www.saucedemo.com/inventory.html"));

        TestCase.assertTrue(result);

        if (result){
           JavascriptExecutor js = (JavascriptExecutor)driver;
           js.executeScript("sauce:job-result=" + (result));
       }
    }

    @Test
    public void signInUnsuccessfully() {
        driver.get("https://www.saucedemo.com");

        Map<String, String> blankPassword = new HashMap<String, String>();
        blankPassword.put("password", "");

        User user = new User(blankPassword);
        String username = user.getUsername();
        String password = user.getPassword();

        WebDriverWait explicitWait = new WebDriverWait(driver, 10);

        WebElement usernameElement = explicitWait.until(
                ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-test='username']")));

        usernameElement.sendKeys(username);
        driver.findElement(By.cssSelector("[data-test='password']")).sendKeys(password);
        driver.findElement(By.className("login-button")).submit();

        WebElement error = explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.className("fa-times-circle")));
        String cssAttributeStartsWith = "svg[data-icon^=times]";

        Boolean result = driver.findElements(By.cssSelector(cssAttributeStartsWith)).size() > 0;

        TestCase.assertEquals(error, driver.findElement(By.cssSelector(cssAttributeStartsWith)));
        TestCase.assertTrue(result);

        if (result){
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("sauce:job-result=" + (result));
        }
    }

    @Test
    public void signInBlankPassword() {
        driver.get("https://www.saucedemo.com");

        Map<String, String> blankPassword = new HashMap<String, String>();
        blankPassword.put("password", "");

        User user = User.blankPassword();
        String username = user.getUsername();
        String password = user.getPassword();


        WebDriverWait explicitWait = new WebDriverWait(driver, 10);

        WebElement usernameElement = explicitWait.until(
                ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-test='username']")));

        usernameElement.sendKeys(username);
        driver.findElement(By.cssSelector("[data-test='password']")).sendKeys(password);
        driver.findElement(By.className("login-button")).submit();

        WebElement error = explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.className("fa-times-circle")));
        String cssAttributeStartsWith = "svg[data-icon^=times]";

        Boolean result = driver.findElements(By.cssSelector(cssAttributeStartsWith)).size() > 0;

        TestCase.assertEquals(error, driver.findElement(By.cssSelector(cssAttributeStartsWith)));
        TestCase.assertTrue(result);

        if (result){
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("sauce:job-result=" + (result));
        }
    }
}
