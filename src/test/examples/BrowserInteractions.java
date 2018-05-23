package test.examples;

import test.base.*;

import org.junit.Test;

public class BrowserInteractions extends Base {

    @Test
    public void browserInformation() {
        driver.get("http://a.testaddressbook.com");

        // "Address Book"
        driver.getTitle();

        // "http://a.testaddressbook.com/"
        driver.getCurrentUrl();

        // "<html> ... </html>"
        driver.getPageSource();
    }
}
