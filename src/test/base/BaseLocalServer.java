package test.base;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseLocalServer {
    protected WebDriver driver;
    @BeforeEach
    public void setup() throws MalformedURLException {
        // Note: Chromedriver must be on PATH, or set when Server is started

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-infobars");

        URL url = new URL("http://localhost:4444/wd/hub");

        driver = new RemoteWebDriver(url, chromeOptions);
    }

}
