package tests;
import org.testng.annotations.Test;

public class SauceDemoTest extends BaseTest {


    @Test (description="Логин + добавление продукта в корзину + проверка информации о добавленном продукте")
    public void loginTest () {
        loginPage.openPage();
        loginPage.login("standard_user","secret_sauce");
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        cartPage.openPage();
        cartPage.validateNumberOfProduct(1);
        cartPage.validateProductDetails("Sauce Labs Fleece Jacket", 1, 49.99);
    }


}
