package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private static final By USERNAME_INPUT =By.id("user-name");
    private static final By PASSWORD_INPUT =By.id("password");
    private static final By LOGIN_BUTTON = By.cssSelector(".btn_action");
    private static final String LOGIN_URL = "https://www.saucedemo.com/index.html";

    public LoginPage (WebDriver driver){
        super (driver);
    }

    public void openPage (){
        driver.get(LOGIN_URL);
    }

    public void login (String userName, String password) {
    driver.findElement(USERNAME_INPUT).sendKeys(userName);
    driver.findElement(PASSWORD_INPUT).sendKeys(password);
    driver.findElement(LOGIN_BUTTON).click();
    }
}
