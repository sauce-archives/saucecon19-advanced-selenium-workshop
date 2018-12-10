package test.authentication;

import test.base.*;
import test.data.*;

import org.junit.Test;

import static org.junit.Assert.*;

public class LogInTest extends Base {

    @Test
    public void signInSuccessfully() {
        SignInPage signInPage = SignInPage.visit(driver);
        signInPage.signIn(User.validUser());

        HomePage homePage = new HomePage(driver);
        assertTrue(homePage.isSignedIn());
    }

    @Test
    public void signInUnsuccessfully() {
        SignInPage signInPage = SignInPage.visit(driver);
        signInPage.signInUnsuccessfully(User.invalidUser());

        assertTrue(signInPage.hasErrorMessage());
    }

    @Test
    public void signInBlankPassword() {
        SignInPage signInPage = SignInPage.visit(driver);
        signInPage.signInUnsuccessfully(User.blankPassword());

        assertTrue(signInPage.hasErrorMessage());
    }
}
