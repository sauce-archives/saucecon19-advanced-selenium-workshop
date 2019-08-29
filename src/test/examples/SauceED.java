package test.examples;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SauceED {
    private WebDriver driver;

    @Rule
    public TestRule watcher = new TestWatcher() {
        @Override
        protected void succeeded(Description description) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("sauce:job-result=passed");
            driver.quit();
        }

        @Override
        protected void failed(Throwable e, Description description) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("sauce:job-result=failed");
            driver.quit();
        }
    };

    @Rule
    public TestName name = new TestName();

    private String gitlabBuildName() {
        return System.getenv("CI_JOB_NAME") + " - " + System.getenv("CI_JOB_ID");
    }

    @Before
    public void extraSauce() throws MalformedURLException {
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("name", name.getMethodName());
        sauceOptions.setCapability("build", gitlabBuildName());
        sauceOptions.setCapability("extendedDebugging", "true");
        sauceOptions.setCapability("capturePerformance", "true");

        MutableCapabilities options = new MutableCapabilities();
        options.setCapability("browserName", "chrome");
        options.setCapability("browserVersion", "latest");
        options.setCapability("platformName", "Windows 10");
        options.setCapability("sauce:options", sauceOptions);

        String user = System.getenv("SAUCE_USERNAME");
        String key = System.getenv("SAUCE_ACCESS_KEY");
        URL url = new URL("https://" + user + ":" + key + "@ondemand.saucelabs.com:443/wd/hub");

        driver = new RemoteWebDriver(url, options);
    }

    @Test
    public void extendedDebugging() {
        driver.get("https://www.saucedemo.com/");

        String email = "standard_user";
        String password = "secret_sauce";

        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("user-name")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.className("btn_action")).click();
    }
}
