package test.examples;

import test.base.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JSExecutor extends Base {

    @Test
    public void jsExecute() {
        driver.get("https://www.saucedemo.com");

        WebElement element = driver.findElement(By.className("login-button"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        js.executeScript("window.scrollBy(0,50)");
    }

}

