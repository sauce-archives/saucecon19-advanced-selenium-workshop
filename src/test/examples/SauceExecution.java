package test.examples;

import org.junit.Test;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SauceExecution {

    @Test
    public void sauceExecution() throws MalformedURLException {
        MutableCapabilities sauceOptions = new MutableCapabilities();

        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserVersion", "76.0");
        options.setCapability("platformName", "Windows 10");
        options.setCapability("sauce:options", sauceOptions);

        String user = System.getenv("SAUCE_USERNAME");
        String key = System.getenv("SAUCE_ACCESS_KEY");

        URL url = new URL("https://" + user + ":" + key + "@ondemand.saucelabs.com:443/wd/hub");

        WebDriver driver = new RemoteWebDriver(url, options);
        driver.quit();
    }
}
