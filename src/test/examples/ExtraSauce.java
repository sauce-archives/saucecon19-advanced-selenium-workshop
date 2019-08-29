package test.examples;

import org.junit.Test;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ExtraSauce {
    protected WebDriver driver;

    @Test
    public void extraSauce() throws MalformedURLException {

        // https://wiki.saucelabs.com/display/DOCS/Test+Configuration+Options
        MutableCapabilities sauceOptions = new MutableCapabilities();

        // Test Details
        ArrayList <String> tags = new ArrayList<>();
        tags.add("Tag 1");
        tags.add("Tag 2");

        sauceOptions.setCapability("name", "Example Test Name B");
        sauceOptions.setCapability("build", "Example Build - 2");
        sauceOptions.setCapability("tags", tags);

        // System Preferences
        sauceOptions.setCapability("screenResolution", "1280x1024");
        sauceOptions.setCapability("timeZone", "Alaska");

        // Special Features
        sauceOptions.setCapability("extendedDebugging", "true");
        sauceOptions.setCapability("capturePerformance", "true");

        // Artifact Toggles
        sauceOptions.setCapability("recordVideo", "false");
        sauceOptions.setCapability("videoUploadOnPass", "false");
        sauceOptions.setCapability("recordScreenshots", "false");
        sauceOptions.setCapability("recordLogs", "false");

        // Timeout Values
        sauceOptions.setCapability("maxDuration", "1800");
        sauceOptions.setCapability("commandTimeout", "300");
        sauceOptions.setCapability("idleTimeout", "90");

        // User Information
        sauceOptions.setCapability("username", System.getenv("SAUCE_USERNAME"));
        sauceOptions.setCapability("accessKey", System.getenv("SAUCE_ACCESS_KEY"));

        URL url = new URL("https://ondemand.saucelabs.com:443/wd/hub");


        MutableCapabilities options = new MutableCapabilities();
        options.setCapability("browserName", "chrome");
        options.setCapability("browserVersion", "latest");
        options.setCapability("platformName", "Windows 10");
        options.setCapability("sauce:options", sauceOptions);

        String user = System.getenv("SAUCE_USERNAME");
        String key = System.getenv("SAUCE_ACCESS_KEY");

        WebDriver driver = new RemoteWebDriver(url, options);
        driver.quit();
    }
}
