package test.examples;

import test.base.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JSExecutor extends Base {

    @Test
    public void jsExecute() {
        driver.get("http://a.testaddressbook.com");

        WebElement element = driver.findElement(By.id("sign-in"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        js.executeScript("window.scrollBy(0,50)");
    }

}

