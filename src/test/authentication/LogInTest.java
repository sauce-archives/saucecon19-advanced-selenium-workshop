package test.authentication;

import test.base.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class LogInTest extends Base {

    @Test
    public void signInSuccessfully() {
        driver.get("http://a.testaddressbook.com");
        driver.findElement(By.id("sign-in")).click();

        String email = "user@example.com";
        String password = "password";

        driver.findElement(By.id("session_email")).sendKeys(email);
        driver.findElement(By.id("session_password")).sendKeys(password);
        driver.findElement(By.tagName("form")).submit();
    }
}
