package test.examples;

import test.base.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LocateElementsAdvanced extends Base {

    @Before
    public void navigate() {
        driver.get("http://address-book-example.herokuapp.com/sign_in");
    }

    @Test
    public void locateElementsCSS() {
        // CSS for ID
        driver.findElement(By.cssSelector("#sign-in"));

        // CSS for Class Name
        driver.findElement(By.cssSelector(".nav-item"));

        // CSS for Multiple Classes
        driver.findElement(By.cssSelector(".nav-item.nav-link"));

        // CSS for Attribute
        driver.findElement(By.cssSelector("a[data-test=sign-in]"));

        // CSS for Multiple Attributes
        driver.findElement(By.cssSelector("a[data-test=sign-in][class='nav-item nav-link']"));
    }

    @Test
    public void locateElementCSSHierarchy() {
        // descendant
        driver.findElement(By.cssSelector(".navbar .nav-item"));

        // direct descendant (child)
        driver.findElement(By.cssSelector(".navbar-nav > .nav-item"));

        // first child
        driver.findElement(By.cssSelector(".nav-item:first-child"));

        // last child
        driver.findElement(By.cssSelector(".nav-item:last-child"));

        // second child
        driver.findElement(By.cssSelector(".nav-item:nth-child(2)"));

        // second child from the end
        driver.findElement(By.cssSelector(".nav-item:nth-last-child(2)"));
    }

    @Test
    public void locateElementCSSAttrSubString() {
        // attribute starts with Text
        driver.findElement(By.cssSelector("a[data-test^=sign]"));

        // attribute ends with Text
        driver.findElement(By.cssSelector("a[data-test$=in]"));

        // attribute contains Text
        driver.findElement(By.cssSelector("a[data-test*=gn-in]"));
    }

    @Test
    public void locateElementCSSSibling() {
        // immediate previous sibling
        driver.findElement(By.cssSelector("a + a"));

        // previous sibling
        driver.findElement(By.cssSelector("a ~ a"));
    }

}