package test.exercises;

import org.junit.Test;
import test.base.Base;
import test.data.*;
import test.pages.*;

import static org.junit.Assert.assertTrue;

public class CheckoutInformationTest extends Base {

    //
    // Exercise:
    // Arrange: Navigate to Checkout Page
    // Act: Enter Information
    // Assert: Successful Submission
    //

    @Test
    public void checkout() {
        CheckoutPage checkoutPage = CheckoutPage.visit(driver);
        checkoutPage.enterInformation();

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        assertTrue(checkoutOverviewPage.onPage());
    }
}
