package pages.BookStore;

import pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProfilePage extends PageBase {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//*[@id=\"submit\"]")
    WebElement logOutButton;

    public LoginPage logout() {
        click(logOutButton);
        return new LoginPage(driver);
    }

    @FindBy(id = "userName-value")
    WebElement userNameValue;

    public String getUserNameValue() {
        return userNameValue.getText();
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[2]/div/span")
    WebElement firstBookTitle;

    public String getFirstBookTitle() {
        return firstBookTitle.getText();
    }

    @FindBy(id = "delete-record-undefined")
    WebElement deleteButton;

    @FindBy(id = "closeSmallModal-ok")
    WebElement closeSmallButton;

    public ProfilePage deleteBook() {
        click(deleteButton);
        wait(1000);
        click(closeSmallButton);
        wait(1000);
        driver.switchTo().alert().accept();
        return this;
    }

    @FindBy(id = "submit")
    WebElement submitButton;

    public LoginPage logOut() {
        clickWithJSExecutor(submitButton, 0, -400);
        return new LoginPage(driver);
    }

}
