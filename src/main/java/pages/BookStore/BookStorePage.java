package pages.BookStore;

import pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookStorePage extends PageBase {
    public BookStorePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "searchBox")
    WebElement searchBox;

    public BookStorePage searchBook(String web) {
        type(searchBox, web);
        wait(500);
        return this;
    }

    //    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[2]/div/span/a")
    @FindBy(xpath = "//span[@class='mr-2']")
    WebElement firstBook;

    public String getFirstBookTitle() {
        return firstBook.getText();
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[1]")
    WebElement LoginPageLink;


    public LoginPage openLoginPage() {
        clickWithJSExecutor(LoginPageLink, 0, 700);
        this.wait(500);
        return new LoginPage(driver);
    }

    public BookStorePage openFirstBook() {
        clickWithJSExecutor(firstBook, 0, 400);
        return this;
    }

    //    @FindBy(id = "addNewRecordButton") // такой же id у кнопки "Back To Book Store"
    @FindBy(xpath="/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[9]/div[2]/button")
    WebElement addNewRecordButton;

    public BookStorePage addToYourCollection() {
        clickWithJSExecutor(addNewRecordButton, 0, 350);
        wait(1000);
        driver.switchTo().alert().accept();
        return this;
    }

}
