package test.authentication;

import test.base.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class LogInTest extends Base {

    @Test
    public void signInSuccessfully() {
        driver.get("http://a.testaddressbook.com");
        driver.findElement(By.id("sign-in")).click();

        String email = "user@example.com";
        String password = "password";

        Wait fluentWait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);

        WebElement emailElement = (WebElement) fluentWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("session_email"));
            }
        });

        emailElement.sendKeys(email);
        driver.findElement(By.id("session_password")).sendKeys(password);
        driver.findElement(By.tagName("form")).submit();
    }
}
