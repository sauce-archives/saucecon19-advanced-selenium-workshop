package test.examples;

import test.base.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ElementActionsClass extends Base{

    @Test
    public void clickAction() {
        driver.get("http://a.testaddressbook.com");

        // Actions Class
        Actions action = new Actions(driver);

        WebElement element = driver.findElement(By.id("sign-in"));

        action.click(element).build().perform();
    }

}