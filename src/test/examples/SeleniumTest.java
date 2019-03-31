package test.examples;

import org.junit.Test;
import org.openqa.selenium.By;
import test.base.Base;

public class SeleniumTest extends Base {

    @Test
    public void firstTest() {
        driver.get("https://www.saucedemo.com/");

        String email = "standard_user";
        String password = "secret_sauce";

        driver.findElement(By.id("user-name")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.className("btn_action")).click();
    }
}
