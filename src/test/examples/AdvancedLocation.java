package test.examples;

import org.junit.Test;
import org.openqa.selenium.By;
import test.base.Base;
import test.data.User;
import test.pages.HomePage;
import test.pages.InventoryPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AdvancedLocation extends Base {

    @Test
    public void cssHierarchy() {
        driver.get("https://www.saucedemo.com/");

        // descendant --> text field
        driver.findElement(By.cssSelector((".login_wrapper .form_input")));

        // direct descendant --> text field
        driver.findElement(By.cssSelector(("form > .form_input")));

        // first child --> text field
        driver.findElement(By.cssSelector(("input:first-child")));

        // last child --> submit field
        driver.findElement(By.cssSelector(("input:last-child")));

        // third child --> submit button
        driver.findElement(By.cssSelector(("input:nth-child(3)")));

        // third child from end --> text field
        driver.findElement(By.cssSelector(("input:nth-last-child(3)")));
    }

    @Test
    public void cssAttributeSubString() {
        driver.get("https://www.saucedemo.com/");

        // starts with --> text field
        driver.findElement(By.cssSelector(("[data-test^=user]")));

        // ends with --> password field
        driver.findElement(By.cssSelector(("[data-test$=word]")));

        // contains --> submit button
        driver.findElement(By.cssSelector(("[type*=ubm]")));
    }

    @Test
    public void cssSiblings() {
        driver.get("https://www.saucedemo.com/");

        // next sibling --> text field
        driver.findElement(By.cssSelector(("[type=text] + [type=password]")));

        // subsequent sibling --> password field
        driver.findElement(By.cssSelector(("[type=text] ~ [type=submit]")));
    }
}
