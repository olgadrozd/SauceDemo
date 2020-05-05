package tests;
import org.testng.annotations.Test;

public class CheckoutTests extends BaseTest {


    @Test
    public void checkoutWithEmptyFields (){
        checkoutPage.openPage();
        checkoutPage.clickContinueButton();
        checkoutPage.checkErrorMessage("Error: First Name is required");
    }

    @Test
    public void checkConfirmationWithoutProducts (){
        checkoutPage.openPage();
        checkoutPage.fillContinueForm("Olga", "Drozd", "Code123");
        checkoutPage.clickContinueButton();
        checkoutPage.clickFinishButton();
        checkoutPage.checkConfirmationMessage("THANK YOU FOR YOUR ORDER");
    }

    @Test
    public void checkOfAmountsWithoutProducts (){
        checkoutPage.openPage();
        checkoutPage.fillContinueForm("Olga", "Drozd", "Code123");
        checkoutPage.clickContinueButton();
        checkoutPage.checkOfAmountsWithoutProducts("Item total: $0","Tax: $0.00", "Total: $0.00");
    }

    @Test
    public void checkOfAmountsWithProduct (){
        loginPage.openPage();
        loginPage.login("standard_user","secret_sauce");
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        cartPage.openPage();
        cartPage.validateNumberOfProduct(1);
        cartPage.validateProductDetails("Sauce Labs Fleece Jacket", 1, 49.99);
        cartPage.clickCheckoutButton();
        checkoutPage.fillContinueForm("Olga", "Drozd", "Code123");
        checkoutPage.clickContinueButton();
        checkoutPage.checkOfAmountsWithProducts("Item total: $49.99", "Tax: $4.00", "Total: $53.99");
    }

    @Test
    public void checkoutWithoutZipCode (){
        checkoutPage.openPage();
        checkoutPage.fillContinueForm("Ivan","Ivanov", "");
        checkoutPage.clickContinueButton();
        checkoutPage.checkErrorMessageIfEmptyZipcode("Error: Postal Code is required");
    }

    @Test
    public void checkoutWithoutLastName (){
        checkoutPage.openPage();
        checkoutPage.fillContinueForm("Ivan","", "123");
        checkoutPage.clickContinueButton();
        checkoutPage.checkErrorMessageIfEmptyLastName("Error: Last Name is required");
    }

}
