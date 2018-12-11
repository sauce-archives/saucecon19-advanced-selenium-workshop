package test.base;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class BaseSauce extends Base {

    @Rule
    public TestName testName = new TestName()  {
        public String getMethodName() {
        return String.format("%s", super.getMethodName());
        }
    };

    @Before
    public void setup() throws MalformedURLException {
        String username = System.getenv("SAUCE_USERNAME");
        String accessKey = System.getenv("SAUCE_ACCESS_KEY");
        String methodName = testName.getMethodName();

        String sauceUrl = "https://"+username+":"+accessKey+"@ondemand.saucelabs.com/wd/hub";
        URL url = new URL(sauceUrl);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("w3c", true);

        MutableCapabilities sauceCaps = new MutableCapabilities();
        sauceCaps.setCapability("name", methodName);
        sauceCaps.setCapability("user", username);
        sauceCaps.setCapability("accessKey", accessKey);

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("sauce:options", sauceCaps);
        caps.setCapability("browserName", "googlechrome");
        caps.setCapability("browserVersion", "61.0");
        caps.setCapability("platformName", "windows 10");
        caps.setCapability("seleniumVersion", "3.11.0");
        caps.setCapability(ChromeOptions.CAPABILITY,  chromeOptions);

        driver = new RemoteWebDriver(url, caps);

        System.out.println(sauceCaps);
        System.out.println(caps);
    }
}
