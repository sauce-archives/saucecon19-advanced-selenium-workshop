# Exercise 5: Write Test Assertions
#### Part One: Run the Test Locally
1. Checkout branch `05_test_assertions`.
2. Navigate to **src > test > authentication > LogInTest**
3. In the `@Test` method **`signInSuccessfully()`**, create the following **`Boolean`**:
    ```
    Boolean result = explicitWait.until(ExpectedConditions.urlMatches("https://www.saucedemo.com/inventory.html"));
    ```
    
4. Using the `Assertions` annotation, create a test assertion that validates the above URL
    
    ```
    Assertions.assertTrue(result);
    ```
    
#### Part Two (Optional): Get the Test to Work on SauceLabs.com
5. In the IntelliJ toolbar navigate to **Run > Run Edit Configuration**.
6. In the configuration dialog box, locate **Environment Variables** and click the folder icon

    ![Actions Example](images/run-configuration.png)

7. In the new dialog box select the **+** symbol at the bottom to add the following Environment variables:
    >To find this information, login to [www.saucelabs.com](www.saucelabs.com) and select **User Settings**. Then copy and paste your username and access key to a text file/clipboard.
    ```
    SAUCE_USERNAME   | <your_username>
    SAUCE_ACCESS_KEY | <your_sauce_access_key>
    ``` 

8. Select **OK** in both the Environment Variables and Edit Configuration dialog boxes.
9. Create a new Base class for running tests on Sauce Labs.
    * Create a new Java class in the `base` package called **`BaseSauce.java`**
    * Add the following at the top of the file:
    ```
    package test.base;
    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.TestInfo;
    import org.openqa.selenium.MutableCapabilities;
    import org.openqa.selenium.chrome.ChromeOptions;
    import org.openqa.selenium.remote.DesiredCapabilities;
    import org.openqa.selenium.remote.RemoteWebDriver;
    import java.net.MalformedURLException;
    import java.net.URL;

    public class BaseSauce extends Base {
    
    ```
    * Create a `@BeforeEach` method with the following:
    ```
    public void setup(TestInfo testInfo) throws MalformedURLException {
        String username = System.getenv("SAUCE_USERNAME");
        String accessKey = System.getenv("SAUCE_ACCESS_KEY");
        String methodName = testName.getMethodName();

        String sauceUrl = "https://"+username+":"+accessKey+"@ondemand.saucelabs.com/wd/hub";
        URL url = new URL(sauceUrl);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("w3c", true);
    ```
    * Create your `MutableCapabilities` object with the following:
    ```
    MutableCapabilities sauceCaps = new MutableCapabilities();
        sauceCaps.setCapability("name", testInfo.getDisplayName());
        sauceCaps.setCapability("user", username);
        sauceCaps.setCapability("accessKey", accessKey);
    ```
    * Create your `DesiredCapabilities` object with the following:
    ```
    DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("sauce:options", sauceCaps);
        caps.setCapability("browserName", "googlechrome");
        caps.setCapability("browserVersion", "61.0");
        caps.setCapability("platformName", "windows 10");
        caps.setCapability("seleniumVersion", "3.11.0");
        caps.setCapability(ChromeOptions.CAPABILITY,  chromeOptions);
    ```
    * Pass the url, and caps objects into the remote web driver like so:
    ```
    driver = new RemoteWebDriver(url, caps);
    ```
    
10. Navigate back to `LogInTest` class, and edit the following:
    
    ```
    public class LogInTest extends Base {
    ```
    
    to:
    
    ```
    public class LogInTest extends BaseSauce {
    ```
    
11. Navigate to the "Automated Tests" section of the [www.saucelabs.com](www.saucelabs.com) dashboard. You should see something similar to the image below:
    
    ![sauce-complete-test](images/sauce-complete.png)
    
    Our test passed in IntelliJ, but the question mark symbol indicates that [www.saucelabs.com](www.saucelabs.com) didn't receive the test results.
 
12. Back in **`BaseSauce`**, create an **`@AfterEach`** method that uses the **`JavascriptExecutor`** like so:
    ```
    @AfterEach
    public void teardown() {
        ((JavascriptExecutor) driver).executeScript("sauce:job-result=" + (result ? "passed" : "failed"));
        driver.quit();
    }
    ```
    `result` most likely will represent the whether or not the assertion for a particular test case passed or not.
13. Save your changes and re-run **`LogInTest`**. In the [www.saucelabs.com](www.saucelabs.com) dashboard, the results should like similar to the image below:

    ![sauce-passed](images/sauce-passed.png)
    