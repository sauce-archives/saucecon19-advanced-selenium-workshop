package test.examples;

import org.junit.Test;
import test.base.Base;
import test.data.User;
import test.pages.HomePage;
import test.pages.InventoryPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SignInTest extends Base {

    @Test
    public void validUser() {
        HomePage homePage = HomePage.visit(driver);
        User user = User.valid();

        homePage.signIn(user);

        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.onPage());
    }
}
