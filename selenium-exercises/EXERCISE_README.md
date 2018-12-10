# Java Selenium Exercises

This directory contains example **Java** scripts and dependencies for running automated **Selenium tests** both **locally** and on **Sauce Labs**. You can use these scripts to test your Sauce Labs authentication credentials, setup of your automated testing environment, and try out Sauce Labs features such as cross-browser testing. Feel free to copy these files or clone the entire directory to your local environment to experiment with creating your own automated Selenium tests! Below there are some guided exercsies to get you started.

#### For Demonstration Purposes Only

The code in these scripts is provided on an "AS-IS” basis without warranty of any kind, either express or implied, including without limitation any implied warranties of condition, uninterrupted use, merchantability, fitness for a particular purpose, or non-infringement. These scripts are provided for educational and demonstration purposes only, and should not be used in production. Issues regarding these scripts should be submitted through GitHub. These scripts are maintained by the Technical Services team at Sauce Labs.

<br />


## Prerequisites

See the parent `README.md` of this repository for instructions on how to complete the following:

* Install Git
* Install IntelliJ
* Install JDK
* Setup Project

## Exercise List
1. Locate Provided Elements
2. Implement Advanced Locators
3. Create Element Actions
4. Implement Full Journey
5. Write Assertions
6. Create an Invalid User
7. Refactor Tests as Declaritive
8. Create a "Sign In" Page Object
9. Run Tests on Sauce Labs

<br />

### Exercise 1: Locate Provided Elements

1. Checkout branch `065 `.
2. Navigate to **src > test > exercsies > Location**.
3. Visit [www.saucedemo.com](https://www.saucedemo.com) and use the developer tools to inspect the following elements:
    * Username Field
    * Password Field
    * Login Button
4. In the first `@Test` method called **`locateUsernameField()`**, paste the relevant values:
    ```
    String className = "";
    String tagName = "";
    Integer tagIndex = ;
    ```
5. Repeat the previous step for the following `@Test` methods:
    * `locatePasswordField()`
    * `locateLogInButton()`
6. Save your changes and run the **Location** class. You should see the following output:

    ![Location-Failed Example](images/locations-failed.png)
    
7. The test failed because there is more than one **`input`** tag with the class name **`"log-input"`**. In order to differentiate the two tags, checkout branch `066` and navigate to the **`locatePasswordField()`** class method. Enter a valid CSS selector in the following:
    ```
    String cssSelector = "";
    ```
    > Use a browser developer tool to grab the css selector, for example in Chrome go to **View > Developer > Developer Tools** and right-click the element, then choose **Copy > Copy selector**
    
8. Save your changes and run the **Location** class. You should see the following output:

    ![Location-Passed Example](images/locations.png)
    
    <br />

### Exercise 2: Implement Advanced Locators

1. Checkout branch `067 `.
2. Navigate to **src > test > exercises > LocationAdvanced**.
3. Visit [www.saucedemo.com](https://www.saucedemo.com) and use a browser developer tool to create, validate, and test CSS Selectors. For example in Google Chrome navigate to **View > Developer > Developer Tools** and use the console like so:
    
    > ##### xpath:
    ```
    $x(".//input")
    ```
    > ##### css:
    ```
    $$("input")
    ```
    > ##### example output:
    ```
    (3) [input.login-input, input.login-input, input.login-button]
    ```

4. In the first `@Test` method called **`locateUserField()`**, fill in the relevant values for the following css selectors:
    ```
    String cssClassName = "";
    String cssAttribute = "";
    String cssMultAttribute = "";
    String cssDescendant = "";
    String cssChild = "";
    ```
5. In the second `@Test` method called **`locatePasswordField()`**, fill in the releavnt values for the following css selectors:
    ```
    String cssDescendant = "";
    String css2ndChild = "";
    String cssSecondChildFromEnd = "";
    ```
6. Finally in the thrid `@Test` method called **`locateLogInButton()`**, fill in the relevant values for the following css selectors:
    ```
    String cssLastChild = "";
    String cssThirdChild = "";
    String cssAttributeStartsWith = "";
    String cssAttributeEndsWith = "";
    String cssAttributeContains = "";
    String cssPreviousSiblings = "";
    ```
7. Save your changes and run the **LocationAdvanced** class. You should see the following output in the console:

    ![LocationAdvanced-Passed Example](images/locationsAdvanced-passed.png)
    
Checkout branch `068` to see the answers.

<br />
    
### Exercise 3: Create Element Actions

1. Checkout branch `068 `.
2. Navigate to **src > test > exercsies > Actions**.
3. In the `@Test` method **`signUpExistingAccount()`**, make note of the following variables:
    ```
    String username = "standard_user";
    String password = "secret_sauce";
    String userField = "[data-test='username']";
    String passField = "[data-test='password']";
    String loginBtn = "[value='LOGIN']";
    ```
4. Under the comment ` // wait for username field`, create an explicit wait for the **`userField`** to render on the page
5. Under the comment ` // send username keystrokes`, create an element locator for **`userField`**, followed by a **`.sendKeys()`** action that uses ** `username`**.
6. Under the comment ` // send password keystrokes`, create an element locator for **`passField`**, followed by a **`.sendKeys()`** action that uses **`password`**.
7. Under the comment ` // click login button to submit keystrokes`, create an element locator for **`loginBtn`**, followed by a **`.click()`**.
8. Save your changes and run the **Actions** class, you should see the following output:
   ![Actions Example](images/actions-passed.png)
   
   Checkout branch `069` to see the answers.
   <br />

### Exercise 4: Implement Full Journey
1. Checkout branch `069 `.
2. Navigate to **src > test > exercsies > UserJourney**. 
3. Fill out the following **`String`** variables:
    ```
    String firstname = "";
    String lastname = "";
    String postal = "";
    ```
4. Save your changes and run the **UserJourney** class, you should see the following output:
    ![Actions Example](images/customer-journey.png)
    
    <br />
    
### Exercise 5: Write Test Assertion
#### Part One: Run the Test on Sauce Labs
1. Checkout branch `070`.
2. Navigate to **src > test > authentication > LogInTest**
3. In the IntelliJ toolbar navigate to **Run > Run Edit Configuration**.
4. In the configuration dialog box, locate **Environment Variables** and click the folder icon

    ![Actions Example](images/run-configuration.png)

5. In the new dialog box select the **+** symbol at the bottom to add the following Environment variables:
    >To find this information, login to [www.saucelabs.com](www.saucelabs.com) and select **User Settings**. Then copy and paste your username and access key to a text file/clipboard.
    ```
    SAUCE_USERNAME   | <your_username>
    SAUCE_ACCESS_KEY | <your_sauce_access_key>
    ``` 

6. Select **OK** in both the Environment Variables and Edit Configuration dialog boxes.
7. Create a new Base class for running tests on Sauce Labs.
    * Create a new Java class in the `base` package called **`BaseSauce.java`**
    * Add the following at the top of the file:
    ```
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
    ```
    * Create a `@Before` method with the following:
    ```
    public void setup() throws MalformedURLException {
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
        sauceCaps.setCapability("name", methodName);
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
#### Part Two: Write the Assertion
8. Navigate back to the **LogInTest** class. In the `@Test` method **`signInSuccessfully()`**, create the following **`Boolean`**:
    ```
    Boolean result = explicitWait.until(ExpectedConditions.urlMatches("https://www.saucedemo.com/inventory.html"));
    ```
    
8. Using the `junit` test method, create a test assertion that validates the above URL
9. Navigate to the "Automated Tests" section of the [www.saucelabs.com](www.saucelabs.com) dashboard. You should see something similar to the image below:
    
    ![sauce-complete-test](images/sauce-complete.png)
    
    Our test passed in IntelliJ, but the question mark symbol indicates that [www.saucelabs.com](www.saucelabs.com) didn't receive the test results.
 
10. Back in **`LogInTest`**, create an **`if`** statement that uses the **`JavascriptExecutor`** like so:
    ```
    if (result){
           JavascriptExecutor js = (JavascriptExecutor)driver;
           js.executeScript("sauce:job-result=" + (result));
       }
    ```
11. Save your changes and re-run **`LogInTest`**. In the [www.saucelabs.com](www.saucelabs.com) dashboard, the results should like similar to the image below:

    ![sauce-passed](images/sauce-passed.png)
    
### Exercise 6: Create an Invalid User
1. Checkout branch `06_invalid_user`.
2. In **LogInTest**, note the new method called **`signInUnsuccessfully`**. There is a **`User`** object that we import from **`test.data.*`** that uses the `Faker` library located [here](https://github.com/DiUS/java-faker). Enter in the values below for the following variables:
    ```
    User user = new User(blankPassword);
    String username = user.getUsername();
    String password = user.getPassword();
    ```
3. Run the test for **`signInUnsuccessfully`**. The test failed as expected yet we don't want the actual test results to report a "failed" result because the failure is intentional. Instead, we can change our test assertion so that our test "passes" when checking for an unsuccessfull login.
    * In a browser, inspect the following error icon element:
        ![sauce-passed](images/error-icon.png)
    * Add an explicit wait and a css locator for the error icon:
    ```
    WebElement error = explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.className("fa-times-circle")));
    String cssAttributeStartsWith = "svg[data-icon^=times]";
    ```
    * Change the **`Boolean result`** to test for the presence of the error icon:
    ```
    Boolean result = driver.findElements(By.cssSelector(cssAttributeStartsWith)).size() > 0;    
    ```
4. Change the test assertions to check whether or not the following CSS Selector matches against the **``WebElement error``** and if **`result`* is true:
    ```
    TestCase.assertEquals(error, driver.findElement(By.cssSelector(cssAttributeStartsWith)));
    TestCase.assertTrue(result);
    ```
5. Repeat steps 2 - 4 for the last `@Test` method, **`signInBlankPassword`**, with the one difference in how we declare the **`User`** object, like so:
    ```
    User user = User.blankPassword();
    ...
    ```
6. Save your changes and re-run the **LogInTest**. The **`signInUnsuccessfully`** test method should pass when you check both the IntelliJ console and the [www.saucelabs.com](www.saucelabs.com) automated test dashboard:

    * **IntelliJ Results:**
    
    ![invalid-user-test1](images/invalid-user-test1.png)
    
    * **Sauce Labs Dashboard:**
    
    ![invalid-user-test2](images/invalid-user-test2.png)
    
### Exercise 7: Refactor Test Code as Declaritive
1. Checkout branch ``07_declaritive_tests``
2. At this point our code is imperitive, to optimize test operations at scale, as well as simplifying troubleshooting, we will refactor our existing test methods as declartive. In **LogInTest**, refactor the following methods to be declartive:
    * signInSuccessfully()
    * signInUnsuccessfully()
    * signInBlankPassword()  
3. To best utilize declartive tests, we need to implement the page object model. Proceed to the next exercise to create a **`SignInPage`** and a **`HomePage`**. 

### Exercise 8: Create Page Objects
1. Checkout branch ``08_create_page_objects``.
2. In the package **Pages**, make note of the two new classes:
    * **SignInPage**
    * **HomePage**
3. Select **HomePage** and edit the following:
    * Add the following class selector for the sauce bot icon on the inventory.html page
    ```
    private By sauceBot = By.className("peek");
    ```
    * Add a `Boolean` value at the bottom of the page to confirm the presence of **`sauceBot`**:
    ```
    Boolean isSignedIn() { return driver.findElements(menu).size > 0; }
    ```
    * Uncomment the package import at the top of the file:
    ```
    import org.openqa.selenium.By;
    ```
4. Select **SignInPage** and edit the following methods:
    * **`signIn`**:
    ```
    this.driver = driver;
    ```
    * **`signInUnsuccessfully`**:
    ```
    fillForm(data);
    ```
    * **`hasErrorMessage`**:
    ```
    return driver.findElements(error).size() > 0;
    ```
    * **`fillForm`**:
    ```
    driver.findElement(userField).sendKeys(data.getUsername());
    driver.findElement(passwordField).sendKeys(data.getPassword());
    driver.findElement(loginButton).click();
    ```
5. Save your changes and run all tests in the **LogInTest** class to confirm if they still pass in both IntelliJ and the Sauce Labs Dashboard.
6. To see the answers, checkout branch `09_base_page_example`
    >To test your knowledge, try and create a `BasePage` object to abstract re-usable actions such as `sendKeys()` and `click()`. You can checkout the branch `09_complete_answers` to see the answer.
