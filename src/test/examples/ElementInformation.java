package test.examples;

import test.base.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class ElementInformation extends Base{

    @Test
    public void signInLink() {
        driver.get("https://www.saucedemo.com");

        // Gather the Text of Element
        driver.findElement(By.id("login_button_container")).getText();

        // Gather the Tag Name
        driver.findElement(By.id("login_button_container")).getTagName();

        // Gather the Attribute Data
        driver.findElement(By.id("login_button_container")).getAttribute("data-test");

        // Determine if Element Rendered on Page
        driver.findElement(By.id("login_button_container")).isDisplayed();

        // Determine if Actions can be Performed on Element
        driver.findElement(By.id("login_button_container")).isEnabled();
    }

}