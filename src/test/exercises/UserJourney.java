package test.exercises;

import junit.framework.TestCase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.base.Base;

public class UserJourney extends Base {


    @Test
    public void fullCustomerJourney() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // navigate to desired page
        driver.get("https://www.saucedemo.com");

        // Specify Data
        String firstname = "james";
        String lastname = "tacker";
        String postal = "94551";

        // Ignore the following selectors
        String username = "standard_user";
        String password = "secret_sauce";
        String userField = "[data-test='username']";
        String passField = "[data-test='password']";
        String loginBtn = "[value='LOGIN']";
        String backpack = "div:nth-child(1) > div.pricebar > button";
        String jacket = "div:nth-child(4) > div.pricebar > button";
        String cart = "#shopping_cart_container";
        String rmvBtn = "div:nth-child(4) > div.cart_item_label > div.item_pricebar > button";
        String continueShopping = "a.cart_cancel_link";
        String checkoutLink = "a.cart_checkout_link";
        String firstNameField = "[data-test='firstName']";
        String lastNameField = "[data-test='lastName']";
        String postalField= "[data-test='postalCode']";
        String cartCheckout = "[value='CONTINUE']";
        String finished = "a.cart_checkout_link";
        String inventoryPage = "https://www.saucedemo.com/inventory.html";
        String cartPage = "https://www.saucedemo.com/cart.html";
        String checkout1 = "https://www.saucedemo.com/checkout-step-one.html";
        String checkout2 = "https://www.saucedemo.com/checkout-step-two.html";
        String complete = "https://www.saucedemo.com/checkout-complete.html";

        // wait for username field
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(userField)));

        // send username keystrokes
        driver.findElement(By.cssSelector(userField)).sendKeys(username);

        // send password keystrokes
        driver.findElement(By.cssSelector(passField)).sendKeys(password);

        // click login button to submit keystrokes
        driver.findElement(By.cssSelector(loginBtn)).click();

        // wait for expected URL to appear
        wait.until(ExpectedConditions.urlMatches(inventoryPage));

        // add items to the cart
        driver.findElement(By.cssSelector(backpack)).click();
        driver.findElement(By.cssSelector(jacket)).click();

        // proceed to checkout
        driver.findElement(By.cssSelector(cart)).click();

        // remove item from cart
        wait.until(ExpectedConditions.urlMatches(cartPage));
        driver.findElement(By.cssSelector(rmvBtn)).click();

        // continue shopping
        driver.findElement(By.cssSelector(continueShopping)).click();

        // re-add item to cart and proceed to checkout
        wait.until(ExpectedConditions.urlMatches(inventoryPage));
        driver.findElement(By.cssSelector(jacket)).click();
        driver.findElement(By.cssSelector(cart)).click();
        wait.until(ExpectedConditions.urlMatches(cartPage));
        driver.findElement(By.cssSelector(checkoutLink)).click();

        // proceed to shipping info (checkout step 1)
        wait.until(ExpectedConditions.urlMatches(checkout1));
        driver.findElement(By.cssSelector(firstNameField)).sendKeys(firstname);
        driver.findElement(By.cssSelector(lastNameField)).sendKeys(lastname);
        driver.findElement(By.cssSelector(postalField)).sendKeys(postal);
        driver.findElement(By.cssSelector(cartCheckout)).click();

        //  proceed to confirmation page (checkout step 2)
        wait.until(ExpectedConditions.urlMatches(checkout2));
        driver.findElement(By.cssSelector(finished)).click();


        // assert that the test passed and quit driver
        Boolean result = wait.until(ExpectedConditions.urlMatches(complete));
        TestCase.assertTrue(result);
        driver.quit();
    }
}