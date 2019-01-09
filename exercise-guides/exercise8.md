# Exercise 8: Create Page Objects
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
6. To see the answers, checkout branch `09_complete_answers`

### Bonus Challenge
Test your knowledge! Try and create a `BasePage` object to abstract re-usable actions such as `sendKeys()` and `click()`. Then try to create page objects for the remaining pages. 

Checkout the branch: `10_complete_examples` to see the complete answers.
