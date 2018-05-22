package test.examples;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumScript {

    @Test
    public void signInLink() {
        // Set location of chromedriver
        System.setProperty("webdriver.chrome.driver", "lib/drivers/chromedriver");

        // Start session (opens browser)
        WebDriver driver = new ChromeDriver();

        // Navigate
        driver.get("http://a.testaddressbook.com");

        // Identify location of element
        By signInLocator = By.id("sign-in");

        // Ensure browser in correct state before acting
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement signIn =  wait.until(
                ExpectedConditions.presenceOfElementLocated(signInLocator));

        // Take action on element
        signIn.click();

        // Record result
        Boolean result = ("Address Book - Sign In").equals(driver.getTitle());
        String status = result ? "passed" : "failed";
        System.out.println(status);

        // Quit session (closes browser)
        driver.quit();
    }

}