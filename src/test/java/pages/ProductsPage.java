package pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private String ADD_TO_CART_LOCATOR = "//*[text()='%s']/../../..//button";
    private static final String LOGIN_URL = "https://www.saucedemo.com/inventory.html";


    public ProductsPage (WebDriver driver){
        super (driver);
    }
    @Step("Открытие страницы")
    public void openPage (){driver.get(LOGIN_URL);
    }

    @Step("Добавление продукта в корзину")
        public void  addToCart(String productName){
        By addToCartXpath = By.xpath(String.format(ADD_TO_CART_LOCATOR, productName));
        driver.findElement(addToCartXpath).click();

    }
}
