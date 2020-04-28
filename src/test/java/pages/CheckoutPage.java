package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutPage extends BasePage {

    private static final String CHECKOUT_URL_STEP_ONE = "https://www.saucedemo.com/checkout-step-one.html";
    private static final By FIRST_INPUT =By.id("first-name");
    private static final By LAST_INPUT =By.id("last-name");
    private static final By ZIP_POSTAL_CODE =By.id("postal-code");
    private static final By CONTINUE_BUTTON = By.cssSelector(".cart_button");
    private static final By CANCEL_BUTTON = By.cssSelector(".cart_cancel_link");
    private static final By ERROR_BUTTON = By.tagName("h3");
    private String ERROR_BUTTON_MESSAGE = "Error: First Name is required";
    private String ERROR_BUTTON_MESSAGE_WITHOUT_ZIP = "Error: Postal Code is required";
    private String ERROR_BUTTON_MESSAGE_LASTNAME = "Error: Last Name is required";
    private static final By ITEM_TOTAL_ACTUAL = By.cssSelector(".summary_subtotal_label");
    private static final By SUMMARY_TAX_ACTUAL = By.cssSelector(".summary_tax_label");
    private static final By SUMMARY_TOTAL_ACTUAL = By.cssSelector(".summary_total_label");
    private static final By FINISH_BUTTON = By.cssSelector(".btn_action");
    private static final By CONFIRMATION_HEADER= By.className("complete-header");
    private String CONFIRMATION_HEADER_MESSAGE = "THANK YOU FOR YOUR ORDER";


    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(CHECKOUT_URL_STEP_ONE);
    }


    public void clickContinueButton (){
        driver.findElement(CONTINUE_BUTTON).click();
    }


    public void clickFinishButton (){
        driver.findElement(FINISH_BUTTON).click();
    }


    public void checkErrorMessage (){

        String actualErrorMessage = driver.findElement(ERROR_BUTTON).getText();
        Assert.assertEquals(actualErrorMessage,ERROR_BUTTON_MESSAGE,"Неверное сообщение об ошибке при нажатии на чекаут с пустыми полями");

    }

    public void checkErrorMessageIfEmptyZipcode (){

        String actualErrorMessage = driver.findElement(ERROR_BUTTON).getText();
        Assert.assertEquals(actualErrorMessage,ERROR_BUTTON_MESSAGE_WITHOUT_ZIP,"Неверное сообщение об ошибке при нажатии на чекаут с пустыми ZIP");

    }

    public void checkErrorMessageIfEmptyLastName (){

        String actualErrorMessage = driver.findElement(ERROR_BUTTON).getText();
        Assert.assertEquals(actualErrorMessage,ERROR_BUTTON_MESSAGE_LASTNAME,"Неверное сообщение об ошибке при нажатии на чекаут с пустой фамилией");

    }

    public void fillContinueForm (String firstName, String lastName, String zipCode ) {
        driver.findElement(FIRST_INPUT).sendKeys(firstName);
        driver.findElement(LAST_INPUT).sendKeys(lastName);
        driver.findElement(ZIP_POSTAL_CODE).sendKeys(zipCode);

    }

    public void checkOfAmountsWithoutProducts (){
        String actualItemTotal= driver.findElement(ITEM_TOTAL_ACTUAL).getText();
        Assert.assertEquals(actualItemTotal,"Item total: $0","Неверная стоимость продукта");


        String actualSummaryTax = driver.findElement(SUMMARY_TAX_ACTUAL).getText();
        Assert.assertEquals(actualSummaryTax,"Tax: $0.00","Неверная стоимость продукта");

        String actualTotal = driver.findElement(SUMMARY_TOTAL_ACTUAL).getText();
        Assert.assertEquals(actualTotal,"Total: $0.00","Неверная стоимость продукта");

    }

    public void checkConfirmationMessage (){

        String actualConfirmationMessage = driver.findElement(CONFIRMATION_HEADER).getText();
        Assert.assertEquals(actualConfirmationMessage,CONFIRMATION_HEADER_MESSAGE,"Сообщение на странице подтверждения не соответсвует ожидаемому");

    }

    public void checkOfAmountsWithProducts (){
        String actualItemTotal= driver.findElement(ITEM_TOTAL_ACTUAL).getText();
        Assert.assertEquals(actualItemTotal,"Item total: $49.99","Неверная стоимость продукта");


        String actualSummaryTax = driver.findElement(SUMMARY_TAX_ACTUAL).getText();
        Assert.assertEquals(actualSummaryTax,"Tax: $4.00","Неверная стоимость продукта");

        String actualTotal = driver.findElement(SUMMARY_TOTAL_ACTUAL).getText();
        Assert.assertEquals(actualTotal,"Total: $53.99","Неверная стоимость продукта");

    }
}
