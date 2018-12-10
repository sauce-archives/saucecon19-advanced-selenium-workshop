package test.base;

import org.junit.After;
import org.junit.Before;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.MalformedURLException;

public abstract class Base {
    protected WebDriver driver;

    @Before
    public void setup() throws MalformedURLException {
        // This automatically uses 2.38 and is windows/mac agnostic
        System.setProperty("wdm.chromeDriverVersion", "2.38");
        System.setProperty("wdm.targetPath", "lib/drivers/auto/");
        ChromeDriverManager.getInstance().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-infobars");

        driver = new ChromeDriver(chromeOptions);
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
