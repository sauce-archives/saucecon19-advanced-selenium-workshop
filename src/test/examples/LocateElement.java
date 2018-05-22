package test.examples;

import test.base.*;

import org.junit.Test;
import org.openqa.selenium.By;

public class LocateElement extends Base {

    @Test
    public void locateSignInLinkByFindElement() {
        driver.get("http://a.testaddressbook.com");

        // ID
        driver.findElement(By.id("sign-in"));

        // CSS Selector
        driver.findElement(By.cssSelector("a[data-test=sign-in]"));

        // Link Text
        driver.findElement(By.linkText("Sign in"));

        // Partial Link Text
        driver.findElement(By.partialLinkText("Sign"));

        // XPath
        driver.findElement(By.xpath("//a[@data-test='sign-in']"));
    }

    @Test
    public void locateElementFromCollection() {
        driver.get("http://a.testaddressbook.com");

        // Class Name
        driver.findElements(By.className("nav-item")).get(1);

        // Tag Name
        driver.findElements(By.tagName("a")).get(1);
    }

}