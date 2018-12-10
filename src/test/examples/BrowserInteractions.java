package test.examples;

import test.base.*;

import org.junit.Test;

public class BrowserInteractions extends Base {

    @Test
    public void browserInformation() {
        driver.get("https://www.saucedemo.com");

        // "Address Book"
        driver.getTitle();

        // "https://saucedemo.com/"
        driver.getCurrentUrl();

        // "<html> ... </html>"
        driver.getPageSource();
    }

    @Test
    public void browserNavigation() {
        driver.get("https://www.saucedemo.com");

        driver.navigate().to("http://google.com");
        driver.navigate().refresh();
        driver.navigate().back();
        driver.navigate().forward();
    }
}
