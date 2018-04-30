package test.base;

import org.junit.Before;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseSauce extends Base {

    @Before
    public void setup() throws MalformedURLException {
        String username = System.getenv("SAUCE_USERNAME");
        String accessKey = System.getenv("SAUCE_ACCESS_KEY");

        String sauceUrl = "https://"+username+":"+accessKey+"@ondemand.saucelabs.com/wd/hub";
        URL url = new URL(sauceUrl);

        DesiredCapabilities caps = DesiredCapabilities.chrome();

        MutableCapabilities sauceCaps = new MutableCapabilities();
        sauceCaps.setCapability("platform", "Windows 10");
        sauceCaps.setCapability("version", "55.0");
        sauceCaps.setCapability("seleniumVersion", "3.11.0");

        caps.setCapability("sauce:options", sauceCaps);

        driver = new RemoteWebDriver(url, caps);
    }
}
