package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class CartPage {

    WebDriver driver;
    By checkOutButton = By.xpath("//a[text() = 'CHECKOUT']");

    By mainPage = By.id("inventory_sidebar_link");
    By burgerButton = By.xpath("//div[@class = 'bm-burger-button']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS); // there's an implicit 3 second wait if no elements are found, need to reduce to 100 mil
    }

    public CheckoutInformationPage clickCheckOut() {
        driver.findElement(checkOutButton).click();
        return new CheckoutInformationPage(driver);
    }

    public ProductsPage clickAllItems() {
        driver.findElement(burgerButton).click();
        driver.findElement(mainPage).click();
        return new ProductsPage(driver);
    }
    public String getGoodName() {
        String name;
        try {
            name = driver.findElement(By.xpath("//div[@class = 'inventory_item_name']")).getText();
        } catch (NoSuchElementException e) {
            return null;
        }
        return name;
    }


}
