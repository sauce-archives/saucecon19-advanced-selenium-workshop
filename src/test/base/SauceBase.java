package test.base;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SauceBase {
    protected WebDriver driver;

    @Rule
    public TestName name = new TestName();

    @Before
    public void setup() throws MalformedURLException {
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("name", name.getMethodName());
        sauceOptions.setCapability("seleniumVersion", "3.141.59");
        sauceOptions.setCapability("username", System.getenv("SAUCE_USERNAME"));
        sauceOptions.setCapability("accessKey", System.getenv("SAUCE_ACCESS_KEY"));

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("w3c", true);
        chromeOptions.setCapability("browserVersion", "70.0");
        chromeOptions.setCapability("platformName", "windows 10");
        chromeOptions.setCapability("sauce:options", sauceOptions);

        URL url = new URL("https://ondemand.saucelabs.com:443/wd/hub");

        driver = new RemoteWebDriver(url, chromeOptions);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
