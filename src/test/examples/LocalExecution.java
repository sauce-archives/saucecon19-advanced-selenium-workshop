package test.examples;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocalExecution {

    @Test
    public void localExecution() {
        // Set location of chromedriver
        System.setProperty("webdriver.chrome.driver", "lib/drivers/chromedriver");

        // Start session (opens browser)
        WebDriver driver = new ChromeDriver();

        // Quit session (closes browser)
        driver.quit();
    }
}
