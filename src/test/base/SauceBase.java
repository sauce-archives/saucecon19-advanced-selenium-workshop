package test.base;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
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
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        desiredCapabilities.setCapability("version", "70");
        desiredCapabilities.setCapability("platform", "Windows 10");
        desiredCapabilities.setCapability("name", name.getMethodName());
        desiredCapabilities.setCapability("seleniumVersion", "3.14.159");

        String username = System.getenv("SAUCE_USERNAME");
        String accessKey = System.getenv("SAUCE_ACCESS_KEY");

        URL url = new URL("https://"+username+":"+accessKey+"@ondemand.saucelabs.com:443/wd/hub");

        driver = new RemoteWebDriver(url, desiredCapabilities);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
