package test.examples;

import test.base.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumScript extends Base {

    @Test
    public void signInLink() {
        // Set ChromeDriver
        System.setProperty("webdriver.chrome.driver", "lib/drivers/chromedriver");

        // Start session (opens browser)
        WebDriver driver = new ChromeDriver();

        // Navigate
        driver.get("https://www.saucedemo.com");

        // Identify location of element
        By signInLocator = By.id("login_button_container");

        // Ensure browser in correct state before acting
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement signIn =  wait.until(
                ExpectedConditions.presenceOfElementLocated(signInLocator));

        // Take action on element
        signIn.click();

        // Record result
        Boolean result = ("Swag Labs").equals(driver.getTitle());
        String status = result ? "passed" : "failed";
        System.out.println(status);

        driver.quit();
    }

}