package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutPage extends BasePage {

    private static final String CHECKOUT_URL_STEP_ONE = "https://www.saucedemo.com/checkout-step-one.html";
    private static final By FIRST_INPUT =By.id("first-name");
    private static final By LAST_INPUT =By.id("last-name");
    private static final By ZIP_POSTAL_CODE =By.id("postal-code");
    private static final By CONTINUE_BUTTON = By.cssSelector(".cart_button");
    private static final By ERROR_BUTTON = By.tagName("h3");
    private static final By ITEM_TOTAL_ACTUAL = By.cssSelector(".summary_subtotal_label");
    private static final By SUMMARY_TAX_ACTUAL = By.cssSelector(".summary_tax_label");
    private static final By SUMMARY_TOTAL_ACTUAL = By.cssSelector(".summary_total_label");
    private static final By FINISH_BUTTON = By.cssSelector(".btn_action");
    private static final By CONFIRMATION_HEADER= By.className("complete-header");


    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы")
    public void openPage() {
        driver.get(CHECKOUT_URL_STEP_ONE);
    }

    @Step("Нажатие на кнопку CONTINUE")
    public void clickContinueButton (){
        driver.findElement(CONTINUE_BUTTON).click();
    }

    @Step("Нажатие на кнопку FINISH")
    public void clickFinishButton (){
        driver.findElement(FINISH_BUTTON).click();
    }

    @Step("Проверка текста сообщения об ошибке при нажатии на чекаут с пустыми полями")
    public void checkErrorMessage (String errorMessage){
        String actualErrorMessage = driver.findElement(ERROR_BUTTON).getText();
        Assert.assertEquals(actualErrorMessage,errorMessage,"Неверное сообщение об ошибке при нажатии на чекаут с пустыми полями");
    }
    @Step("Проверка текста сообщения об ошибке при нажатии на чекаут с пустым ZIP")
    public void checkErrorMessageIfEmptyZipcode (String errorButtonMessageWithoutZip){
        String actualErrorMessage = driver.findElement(ERROR_BUTTON).getText();
        Assert.assertEquals(actualErrorMessage,errorButtonMessageWithoutZip,"Неверное сообщение об ошибке при нажатии на чекаут с пустым ZIP");
    }

    @Step("Проверка текста сообщения об ошибке при нажатии на чекаут с пустым полем фамилия")
    public void checkErrorMessageIfEmptyLastName (String errorButtonMessageLastname){
        String actualErrorMessage = driver.findElement(ERROR_BUTTON).getText();
        Assert.assertEquals(actualErrorMessage,errorButtonMessageLastname,"Неверное сообщение об ошибке при нажатии на чекаут с пустой фамилией");
    }

    @Step("Заполнение формы данными Имя, Фамилия, ZIP code")
    public void fillContinueForm (String firstName, String lastName, String zipCode ) {
        driver.findElement(FIRST_INPUT).sendKeys(firstName);
        driver.findElement(LAST_INPUT).sendKeys(lastName);
        driver.findElement(ZIP_POSTAL_CODE).sendKeys(zipCode);
    }

    @Step("Заполнение формы данными Имя, Фамилия, ZIP code")
    public void checkOfAmountsWithoutProducts (String itemTotal, String taxes, String total){
        String actualItemTotal= driver.findElement(ITEM_TOTAL_ACTUAL).getText();
        Assert.assertEquals(actualItemTotal, itemTotal,"Неверная стоимость продукта");

        String actualSummaryTax = driver.findElement(SUMMARY_TAX_ACTUAL).getText();
        Assert.assertEquals(actualSummaryTax, taxes,"Неверная сумма такс");

        String actualTotal = driver.findElement(SUMMARY_TOTAL_ACTUAL).getText();
        Assert.assertEquals(actualTotal, total,"Неверная итоговая стоимость заказа");
    }
    @Step("Проверка сообщения на странице подтверждения")
    public void checkConfirmationMessage (String confirmationHeaderMessage){

        String actualConfirmationMessage = driver.findElement(CONFIRMATION_HEADER).getText();
        Assert.assertEquals(actualConfirmationMessage,confirmationHeaderMessage,"Сообщение на странице подтверждения не соответсвует ожидаемому");
    }
    @Step("Проверка сумм в корзине")
    public void checkOfAmountsWithProducts (String itemTotal, String taxes, String total){
        String actualItemTotal= driver.findElement(ITEM_TOTAL_ACTUAL).getText();
        Assert.assertEquals(actualItemTotal,itemTotal,"Неверная стоимость продукта");

        String actualSummaryTax = driver.findElement(SUMMARY_TAX_ACTUAL).getText();
        Assert.assertEquals(actualSummaryTax, taxes,"Неверная сумма такс");

        String actualTotal = driver.findElement(SUMMARY_TOTAL_ACTUAL).getText();
        Assert.assertEquals(actualTotal, total,"Неверная итоговая стоимость заказа");
    }
}
