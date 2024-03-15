import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckGoodsDeletedFromCart extends BaseTest {

    @Test(description = "Проверка удаления товара из корзины прямо со страницы товаров")
    public void test_good_is_in_cart() {
        loginPage.open()
                .login("standard_user", "secret_sauce")
                .isPageOpened()
                .addToCart("Sauce Labs Bike Light")
                .clickCart();
        Assert.assertEquals(cartPage.getGoodName(),
                "Sauce Labs Bike Light");
        cartPage.clickAllItems();
        Assert.assertFalse(productsPage.isThereNoGoodInCart());
        productsPage.addToCart("Sauce Labs Bike Light"); // deletes good from cart when pressed twice
        Assert.assertTrue(productsPage.isThereNoGoodInCart());
        productsPage.clickCart();
        Assert.assertNotEquals(cartPage.getGoodName(),
                "Sauce Labs Bike Light");
    }
}
