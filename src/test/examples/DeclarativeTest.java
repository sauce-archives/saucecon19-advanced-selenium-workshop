package test.examples;

import test.pages.HomePage;
import test.pages.InventoryPage;
import test.data.User;

import org.junit.Test;
import test.base.Base;

import static org.junit.Assert.*;

public class DeclarativeTest extends Base {

    @Test
    public void imperative() {
        driver.get("https://www.saucedemo.com/");

        String username = "standard_user";
        String password = "secret_sauce";

        HomePage homePage = new HomePage(driver);
        homePage.getUsername().sendKeys(username);
        homePage.getPassword().sendKeys(password);
        homePage.getSubmit().click();

        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }

    @Test
    public void declarative() {
        HomePage homePage = HomePage.visit(driver);
        User user = User.valid();

        homePage.signIn(user);

        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.onPage());
    }
}
