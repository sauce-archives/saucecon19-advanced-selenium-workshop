package test.base;


import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.BeforeEach;


public class BaseAutoDriver {
    protected WebDriver driver;
    @BeforeEach
    public void setup() {
        System.setProperty("wdm.targetPath", "lib/drivers/auto/");
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
    }
}
