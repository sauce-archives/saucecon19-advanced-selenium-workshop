package test.examples;

import test.base.*;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;

import java.util.Set;

public class Windows extends Base {

    @Test
    public void windowSwitching() {
        driver.get("https://google.com");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('https://www.example.com');");

        String origWindow = driver.getWindowHandle();
        Set handles = driver.getWindowHandles();
        handles.remove(origWindow);

        String nextWindow = String.valueOf(handles.iterator().next());

        // "Example Domain"
        driver.switchTo().window(nextWindow);

        driver.close();

        // "Google"
        driver.switchTo().window(origWindow);
    }

}

