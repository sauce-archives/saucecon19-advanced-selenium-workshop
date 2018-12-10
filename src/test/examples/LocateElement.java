package test.examples;

import test.base.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class LocateElement extends Base {

    @Test
    public void locateSignInLinkByFindElement() {
        driver.get("https://www.saucedemo.com");

        // ID
        driver.findElement(By.id("login_button_container"));

        // Class
        driver.findElement(By.className("login-button"));

        // CSS Selector
        driver.findElement(By.cssSelector("[value='LOGIN']"));

        /*// Link Text
        driver.findElement(By.linkText("LOGIN"));*/

        /*// Partial Link Text
        driver.findElement(By.partialLinkText("LOG"));*/

        // XPath
        driver.findElement(By.xpath("//input[@value='LOGIN']"));
    }

    @Test
    public void locateElementFromCollection() {
        driver.get("https://www.saucedemo.com");

        // Class Name
        driver.findElements(By.className("login-input")).get(0);

        // Tag Name
        driver.findElements(By.tagName("input")).get(1);
    }

}