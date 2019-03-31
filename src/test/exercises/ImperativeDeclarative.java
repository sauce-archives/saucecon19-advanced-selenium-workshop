package test.exercises;

import org.junit.Test;
import test.base.Base;
import test.pages.InventoryPage;
import test.pages.ProductPage;
import test.pages.CartPage;
import test.data.Product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

//
// Exercise:
// rewrite this test to be declarative in the method below
//

public class ImperativeDeclarative extends Base {

    @Test
    public void imperative() {
        driver.get("https://www.saucedemo.com/inventory.html");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.getInventoryItem("Sauce Labs Bike Light").click();

        ProductPage productPage = new ProductPage(driver);
        productPage.getAddToCartButton().click();
        productPage.getCartButton().click();

        CartPage cartPage = new CartPage(driver);
        assertEquals("Sauce Labs Bike Light", cartPage.getItemName());
    }

    @Test
    public void declarative() {
        Product product = Product.valid();

    }
}

