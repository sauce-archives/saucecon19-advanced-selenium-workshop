package test.examples;

import test.base.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementActions extends Base{

    @Test
    public void signIn() {
        driver.get("http://a.testaddressbook.com");
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Take actions on element
        driver.findElement(By.id("sign-in")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("session_email")));

        WebElement email = driver.findElement(By.id("session_email"));

        email.clear();
        email.sendKeys("user@example.com");

        driver.findElement(By.id("session_password")).sendKeys("password");

        driver.findElement(By.tagName("form")).submit();

    }

}