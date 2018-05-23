package test.examples;

import test.base.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class ElementInformation extends Base{

    @Test
    public void signInLink() {
        driver.get("http://a.testaddressbook.com");

        // "Sign In"
        driver.findElement(By.id("sign-in")).getText();

        // "a"
        driver.findElement(By.id("sign-in")).getTagName();

        // "sign-in"
        driver.findElement(By.id("sign-in")).getAttribute("data-test");

        // true
        driver.findElement(By.id("sign-in")).isDisplayed();

        // true
        driver.findElement(By.id("sign-in")).isEnabled();
    }

}