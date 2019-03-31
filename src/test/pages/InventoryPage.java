package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.data.Product;

import java.util.List;

public class InventoryPage {

    private WebDriver driver;
    private static String url = "https://www.saucedemo.com/inventory.html";

    public static InventoryPage visit(WebDriver driver) {
        driver.get(url);
        return new InventoryPage(driver);
    }

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public Boolean onPage() {
        return driver.getCurrentUrl().equals(url);
    }

    public WebElement getInventoryItem(String product) {
        List<WebElement> items = driver.findElements(By.className("inventory_item_label"));
        for (WebElement item : items) {
            if(item.getText().contains(product)) {
                return item.findElement(By.tagName("a"));
            }
        }
        return null;
    }

    public void selectProduct(Product product) {
        getInventoryItem(product.getName()).click();
    }
}
