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
        driver.get("http://a.testaddressbook.com/sign_in");
    }

    @Test
    public void locateEmailField() {

        // Update these fields:

        String id = "session_email";
        String name = "session[email]";
        String className = "form-control";

        // There is more than one Tag name that matches the Email Field, so you
        // need to specify which number it is in the tagIndex value
        String tagName = "input";
        Integer tagIndex = 2;



        // IGNORE THE DETAILS OF THE ASSERTIONS BELOW
        // ALL YOU NEED TO KNOW IS THAT IF YOU RUN THIS TEST
        // WITH THE RIGHT VALUES ABOVE IT WILL PASS

        // Obfuscated way of getting the Email Field
        WebElement emailField = driver.findElements(By.xpath("//*")).get(30);

        // Assert correct element has been found withe the updated strings
        assertEquals(emailField, driver.findElement(By.id(id)));
        assertEquals(emailField, driver.findElement(By.name(name)));
        assertEquals(emailField, driver.findElement(By.className(className)));
        assertEquals(emailField, driver.findElements(By.tagName(tagName)).get(tagIndex));
    }

    @Test
    public void locateSignInButton() {

        // Update these fields:

        String name = "commit";
        String className = "btn";

        // There is more than one Tag name that matches the Sign In Button, so you
        // need to specify which number it is in the tagIndex value
        String tagName = "input";
        Integer tagIndex = 4;



        // IGNORE THE DETAILS OF THE ASSERTIONS BELOW
        // ALL YOU NEED TO KNOW IS THAT IF YOU RUN THIS TEST
        // WITH THE RIGHT VALUES ABOVE IT WILL PASS

        // Obfuscated way of getting the Sign in Button
        WebElement signInButton = driver.findElements(By.xpath("//*")).get(34);

        assertEquals(signInButton, driver.findElement(By.name(name)));
        assertEquals(signInButton, driver.findElement(By.className(className)));
        assertEquals(signInButton, driver.findElements(By.tagName(tagName)).get(tagIndex));
    }

    @Test
    public void locateSignUpLink() {

        // Update these fields:

        String linkText = "Sign up";
        String partialLinkText = "up";

        // There is more than one Tag name that matches the Sign Up Link, so you
        // need to specify which number it is in the tagIndex value
        String tagName = "a";
        Integer tagIndex = 2;



        // IGNORE THE DETAILS OF THE ASSERTIONS BELOW
        // ALL YOU NEED TO KNOW IS THAT IF YOU RUN THIS TEST
        // WITH THE RIGHT VALUES ABOVE IT WILL PASS

        // Obfuscated way of getting the Sign Up Link
        WebElement signUpLink = driver.findElements(By.xpath("//*")).get(36);

        assertEquals(signUpLink, driver.findElement(By.linkText(linkText)));
        assertEquals(signUpLink, driver.findElement(By.partialLinkText(partialLinkText)));
        assertEquals(signUpLink, driver.findElements(By.tagName(tagName)).get(tagIndex));

    }

}