package test.base;

import org.junit.After;
import org.junit.Before;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
    protected WebDriver driver;

    @Before
    public void setup() {
        // This automatically uses 2.38 and is windows/mac agnostic
        System.setProperty("wdm.chromeDriverVersion", "2.38");
        System.setProperty("wdm.targetPath", "lib/drivers/auto/");
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
