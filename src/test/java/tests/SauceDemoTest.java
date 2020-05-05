package tests;
import org.testng.annotations.Test;

public class SauceDemoTest extends BaseTest {


    @Test
    public void loginTest () {
        loginPage.openPage();
        loginPage.login("standard_user","secret_sauce");
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        cartPage.openPage();
        cartPage.validateNumberOfProduct(1);
        cartPage.validateProductDetails("Sauce Labs Fleece Jacket", 1, 49.99);
    }


}
