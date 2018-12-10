package test.exercises;

import test.base.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static junit.framework.TestCase.assertEquals;

public class Location extends Base {

    //
    // Exercise:
    // Fill in the Strings and Update the Indexes to get the tests to pass
    //

    @Before
    public void navigate() {
        driver.get("https://www.saucedemo.com");
    }

    @Test
    public void locateUsernameField() {

        // Update the class Name field:
        String className = "login-input";

        // There is more than one Tag name that matches the "login-input" field, so you
        // need to specify which number it is in the tagIndex value
        String tagName = "input";
        String cssLocator = "[data-test='username']";
        Integer tagIndex = 0;



        // IGNORE THE DETAILS OF THE ASSERTIONS BELOW
        // ALL YOU NEED TO KNOW IS THAT IF YOU RUN THIS TEST
        // WITH THE RIGHT VALUES ABOVE IT WILL PASS

        // Obfuscated way of getting the Username Field
        WebElement userField = driver.findElements(By.xpath("//*")).get(9);

        // Assert correct element has been found withe the updated strings
        //assertEquals(userField, driver.findElement(By.id(id)));
        assertEquals(userField, driver.findElement(By.cssSelector(cssLocator)));
        assertEquals(userField, driver.findElement(By.className(className)));
        assertEquals(userField, driver.findElements(By.tagName(tagName)).get(tagIndex));
    }

    @Test
    public void locatePasswordField() {

        // Update the class Name field:
        String className = "login-input";

        // There is more than one Tag name that matches the "login-input" field, so you
        // need to specify which number it is in the tagIndex value
        String tagName = "input";
        String cssLocator = "[data-test='password']";
        Integer tagIndex = 1;



        // IGNORE THE DETAILS OF THE ASSERTIONS BELOW
        // ALL YOU NEED TO KNOW IS THAT IF YOU RUN THIS TEST
        // WITH THE RIGHT VALUES ABOVE IT WILL PASS

        // Obfuscated way of getting the Login Box Field
        WebElement passwordField = driver.findElements(By.xpath("//*")).get(10);

        // Assert correct element has been found withe the updated strings
        assertEquals(passwordField, driver.findElement(By.cssSelector(cssLocator)));
        assertEquals(passwordField, driver.findElement(By.className(className)));
        assertEquals(passwordField, driver.findElements(By.tagName(tagName)).get(tagIndex));
    }

    @Test
    public void locateLogInButton() {

        // Update these fields:

        //String name = "LOGIN";
        String className = "login-button";

        // There is more than one Tag name that matches the Sign In Button, so you
        // need to specify which number it is in the tagIndex value
        String tagName = "input";
        String cssLocator = "[value='LOGIN']";
        Integer tagIndex = 2;



        // IGNORE THE DETAILS OF THE ASSERTIONS BELOW
        // ALL YOU NEED TO KNOW IS THAT IF YOU RUN THIS TEST
        // WITH THE RIGHT VALUES ABOVE IT WILL PASS

        // Obfuscated way of getting the Sign in Button
        WebElement signInButton = driver.findElements(By.xpath("//*")).get(11);

        assertEquals(signInButton, driver.findElement(By.cssSelector(cssLocator)));
        assertEquals(signInButton, driver.findElement(By.className(className)));
        assertEquals(signInButton, driver.findElements(By.tagName(tagName)).get(tagIndex));
    }


}