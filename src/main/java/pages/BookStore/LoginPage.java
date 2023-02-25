package pages.BookStore;

import pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login")
    WebElement loginButton;

    public ProfilePage login(String uName, String uPass) {
        type(username, uName);
        type(password, uPass);
//        click(loginButton);
        clickWithJSExecutor(loginButton, 0, 100);
        return new ProfilePage(driver);
    }

    @FindBy(id = "name")
    WebElement errorMsg;

    public String getErrorMessage() {
        return errorMsg.getText();
    }

    //    в классе LoginPage ради авторизованного пользователя в precondition
//    @FindBy(id = "submit") //id = "submit" есть у многих кнопок - это ошибка
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[3]/button")
    WebElement logoutButton;

    public LoginPage logOut() {
        click(logoutButton);
        return this;
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[1]/h5")
    WebElement welcomeMessage;

    public String getWelcomeMessage() {
        return welcomeMessage.getText();
    }
}
