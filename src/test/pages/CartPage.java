package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.data.Product;

import java.util.List;

public class CartPage {

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getItemName() {
        return driver.findElement(By.className("inventory_item_name")).getText();
    }

    public Boolean hasProduct(Product product) {
        List<WebElement> items = driver.findElements(By.className("inventory_item_name"));
        for (WebElement item : items) {
            if(item.getText().equals(product.getName())) {
                return true;
            }
        }
        return false;
    }
}
