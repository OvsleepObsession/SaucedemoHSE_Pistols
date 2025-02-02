package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutOverviewPage {

    WebDriver driver;
    By itemTotalPrice = By.xpath("//div[@class = 'summary_subtotal_label']");
    By taxPrice = By.xpath("//div[@class = 'summary_tax_label']");
    By totalPrice = By.xpath("//div[@class = 'summary_total_label']");

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getItemTotalPrice() {
        return driver.findElement(itemTotalPrice).getText();
    }

    public String getTaxPrice() {
        return driver.findElement(taxPrice).getText();
    }

    public String getTotalPrice() {
        return driver.findElement(totalPrice).getText();
    }


}
