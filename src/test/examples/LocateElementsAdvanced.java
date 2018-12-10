package test.examples;

import test.base.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LocateElementsAdvanced extends Base {

    @Before
    public void navigate() {
        driver.get("https://www.saucedemo.com");
    }

    @Test
    public void locateElementsCSS() {
        // CSS for ID
        driver.findElement(By.cssSelector("#login_button_container"));

        // CSS for Class Name
        driver.findElement(By.cssSelector(".login-input"));

       /* // CSS for Element with Multiple Classes
        driver.findElement(By.cssSelector(".login-input.login-button"));*/

        // CSS for Attribute
        driver.findElement(By.cssSelector("input[value='LOGIN']"));

        // CSS for Multiple Attributes
        driver.findElement(By.cssSelector("input[type='submit'][class='login-button']"));
    }

    @Test
    public void locateElementCSSHierarchy() {
        // descendant
        driver.findElement(By.cssSelector(".login-box form"));

        // direct descendant (child)
        driver.findElement(By.cssSelector(".login-box > form > .login-input"));

        // first child
        driver.findElement(By.cssSelector(".login-box:first-child"));

        // last child
        driver.findElement(By.cssSelector(".login-box:last-child"));

        // second child
        driver.findElement(By.cssSelector(".login-box:nth-child(1)"));

        // second child from the end
        driver.findElement(By.cssSelector(".login-box:nth-last-child(1)"));
    }

    @Test
    public void locateElementCSSAttrSubString() {
        // attribute starts with Text
        driver.findElement(By.cssSelector("input[data-test^=user]"));

        // attribute ends with Text
        driver.findElement(By.cssSelector("input[data-test$=name]"));

        // attribute contains Text
        driver.findElement(By.cssSelector("input[data-test*=me]"));
    }

    @Test
    public void locateElementCSSSibling() {
        // immediate previous sibling
        driver.findElement(By.cssSelector("input + input"));

        // previous sibling
        driver.findElement(By.cssSelector("input ~ input"));
    }

}