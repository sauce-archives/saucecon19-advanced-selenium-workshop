package test.examples;

import test.base.*;

import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Date;

public class Cookies extends Base {

    @Test
    public void cIsForCookie() {
        driver.get("http://a.testaddressbook.com");

        // Create
        Cookie cookie = new Cookie.Builder("name", "value")
                .domain("a.testaddressbook.com")
                .expiresOn(new Date(System.currentTimeMillis() + 500000000))
                .isHttpOnly(true)
                .isSecure(false)
                .path("/mypath")
                .build();

        // Add
        driver.manage().addCookie(cookie);

        // Read
        driver.get("http://a.testaddressbook.com/mypath");
        driver.manage().getCookieNamed("name");

        // Get All
        driver.manage().getCookies();

        // Delete
        driver.manage().deleteCookie(cookie);
    }

}

