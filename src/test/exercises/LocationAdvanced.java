package test.exercises;

import test.base.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

//
// Exercise:
// Fill in the Strings to Define the Specified Locators to get the tests to pass
//


public class LocationAdvanced extends Base {

    @Before
    public void navigate() {
        driver.get("http://a.testaddressbook.com/sign_in");
    }


    @Test
    public void locateEmailField() {

        // Define Locators

        String cssId = "";
        String cssClassName = "";
        String cssAttribute = "";
        String cssMultAttribute = "";
        String cssDescendant = "";
        String cssChild = "";



        // IGNORE THE DETAILS OF THE ASSERTIONS BELOW
        // ALL YOU NEED TO KNOW IS THAT IF YOU RUN THIS TEST
        // WITH THE RIGHT VALUES ABOVE IT WILL PASS

        WebElement emailField = driver.findElement(By.id("session_email"));

        assertEquals(emailField, driver.findElement(By.cssSelector(cssId)));
        assertEquals(emailField, driver.findElement(By.cssSelector(cssClassName)));
        assertEquals(emailField, driver.findElement(By.cssSelector(cssAttribute)));
        assertEquals(emailField, driver.findElement(By.cssSelector(cssMultAttribute)));
        assertEquals(emailField, driver.findElement(By.cssSelector(cssDescendant)));
        assertEquals(emailField, driver.findElement(By.cssSelector(cssChild)));

        assertTrue(cssId.contains("#"));
        assertTrue(cssClassName.contains("."));
        assertTrue(cssAttribute.contains("="));
        assertTrue(cssMultAttribute.contains("]["));
        assertTrue(cssDescendant.contains(" "));
        assertTrue(cssChild.contains(" > "));
    }

    @Test
    public void locateHomeLink() {

        // Define Locators

        String cssMultClass = "";
        String cssFirstChild = "";
        String cssSecondChildFromEnd = "";



        // IGNORE THE DETAILS OF THE ASSERTIONS BELOW
        // ALL YOU NEED TO KNOW IS THAT IF YOU RUN THIS TEST
        // WITH THE RIGHT VALUES ABOVE IT WILL PASS

        WebElement homeLink = driver.findElement(By.tagName("a"));

        assertEquals(homeLink, driver.findElement(By.cssSelector(cssMultClass)));
        assertEquals(homeLink, driver.findElement(By.cssSelector(cssFirstChild)));
        assertEquals(homeLink, driver.findElement(By.cssSelector(cssSecondChildFromEnd)));

        assertTrue(cssMultClass.contains("."));
        assertFalse(cssMultClass.contains(" "));
        assertTrue(cssFirstChild.contains(":first"));
        assertTrue(cssSecondChildFromEnd.contains("nth-last"));
    }

    @Test
    public void locateSignInLink() {

        // Define Locators

        String cssLastChild = "";
        String cssSecondChild = "";
        String cssAttributeStartsWith = "";
        String cssAttributeEndsWith = "";
        String cssAttributeContains = "";
        String cssPreviousSibling = "";



        // IGNORE THE DETAILS OF THE ASSERTIONS BELOW
        // ALL YOU NEED TO KNOW IS THAT IF YOU RUN THIS TEST
        // WITH THE RIGHT VALUES ABOVE IT WILL PASS

        WebElement signInLink = driver.findElement(By.id("sign-in"));

        assertEquals(signInLink, driver.findElement(By.cssSelector(cssLastChild)));
        assertEquals(signInLink, driver.findElement(By.cssSelector(cssSecondChild)));
        assertEquals(signInLink, driver.findElement(By.cssSelector(cssAttributeStartsWith)));
        assertEquals(signInLink, driver.findElement(By.cssSelector(cssAttributeEndsWith)));
        assertEquals(signInLink, driver.findElement(By.cssSelector(cssAttributeContains)));
        assertEquals(signInLink, driver.findElement(By.cssSelector(cssPreviousSibling)));

        assertTrue(cssLastChild.contains(":last"));
        assertTrue(cssSecondChild.contains("nth-c"));
        assertTrue(cssAttributeStartsWith.contains("^="));
        assertTrue(cssAttributeEndsWith.contains("$="));
        assertTrue(cssAttributeContains.contains("*="));
        assertTrue(cssPreviousSibling.contains(" ~ "));
    }

}