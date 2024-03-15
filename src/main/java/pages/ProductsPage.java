package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class ProductsPage {

    WebDriver driver;
    By title = By.xpath("//div[@class = 'product_label']");
    String addToCartButton = "//div[text()='%s']/ancestor::div[@class = 'inventory_item']//button";
    By cartButton = By.id("shopping_cart_container");

    By sortMenu = By.xpath("//select[@class = 'product_sort_container']");
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS); // there's an implicit 3 second wait if no elements are found, need to reduce to 100 mil
    }

    public ProductsPage isPageOpened() {
        driver.findElement(title).isDisplayed();
        return this;
    }

    public ProductsPage addToCart(String product) {
        driver.findElement(By.xpath(String.format(addToCartButton, product))).click();
        return this;
    }

    public CartPage clickCart() {
        driver.findElement(cartButton).click();
        return new CartPage(driver);
    }

    public ProductsPage selectSort(String sort) {
        Select select = new Select(driver.findElement(sortMenu));
        select.selectByVisibleText(sort);
        return this;
    }
    
// returns true if element is not found
    public boolean isThereNoGoodInCart() {
        return driver.findElements(By.xpath("//button[text() = 'REMOVE' and contains(@class,'btn_secondary btn_inventory')]")).isEmpty();
    }

}
