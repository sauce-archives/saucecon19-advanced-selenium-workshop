package test.exercises;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.base.Base;

public class Actions extends Base {

    //
    // Exercise:
    // Use Selenium to submit the sign up form
    //

    @Test
    public void signUpExistingAccount() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // navigate to desired page
        driver.get("http://a.testaddressbook.com/sign_up");

        // Specify Data

        String email = "user@example.com";
        String password = "password";

        // wait for Email Field

        // fill out email field using `email` variable

        // fill out password field using `password` variable

        // click Sign Up button (or Submit Form)


        // Note that because this user already exists, Sign Up will not be successful
        wait.until(ExpectedConditions.urlMatches("http://a.testaddressbook.com/users"));
    }

}