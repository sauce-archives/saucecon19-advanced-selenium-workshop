package test.base;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class SauceBase {
    protected WebDriver driver;
    private String defaultPlatform = "windows_7_firefox";

    private MutableCapabilities getCapabilities(MutableCapabilities sauceOptions) throws FileNotFoundException {
        Map<String, Object> platform = getPlatform();
        MutableCapabilities capabilities = getOptions((String) platform.remove("browser_name"));

        for (Map.Entry<String, Object> entry : ((Map<String, Object>) platform.remove("sauce")).entrySet()) {
            sauceOptions.setCapability(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, Object> data : platform.entrySet()) {
            capabilities.setCapability(data.getKey(), data.getValue());
        }

        capabilities.setCapability("sauce:options", sauceOptions);
        return capabilities;
    }

    public Map<String, Object> getPlatform() throws FileNotFoundException {
        Yaml yaml = new Yaml();

        InputStream file = new FileInputStream("src/test/config/platforms.yml");
        Object platformData = yaml.load(file);

        Map<String, Object> platforms = (Map<String, Object>) platformData;

        if (System.getenv("PLATFORM") == null) {
            return (Map<String, Object>) platforms.get(defaultPlatform);
        } else {
            return (Map<String, Object>) platforms.get(System.getenv(("PLATFORM")));
        }
    }

    public MutableCapabilities getOptions(String browserName) {
        switch (browserName) {
            case "firefox":
                return new FirefoxOptions();
            case "edge":
                return new EdgeOptions();
            case "safari":
                return new SafariOptions();
            case "chrome":
                return new ChromeOptions();
            default:
                return new InternetExplorerOptions();
        }
    }

    public String getBuild() {
        if (System.getenv("BUILD_TAG") != null) {
            return System.getenv("BUILD_TAG");
        } else {
            return "Local Build - " + System.currentTimeMillis();
        }
    }

    @Rule
    public TestName name = new TestName();

    @Before
    public void setup() throws MalformedURLException, FileNotFoundException {
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("name", name.getMethodName());
        sauceOptions.setCapability("build", getBuild());
        sauceOptions.setCapability("username", System.getenv("SAUCE_USERNAME"));
        sauceOptions.setCapability("accessKey", System.getenv("SAUCE_ACCESS_KEY"));

        MutableCapabilities capabilities = getCapabilities(sauceOptions);

        URL url = new URL("https://ondemand.saucelabs.com:443/wd/hub");

        driver = new RemoteWebDriver(url, capabilities);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
