package pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AlertsFrameWindowsPages.AlertsPage;
import pages.AlertsFrameWindowsPages.BrowserWindowsPage;
import pages.AlertsFrameWindowsPages.FramesPage;
import pages.AlertsFrameWindowsPages.NestedFramesPage;
import pages.BookStore.BookStorePage;
import pages.BookStore.LoginPage;
import pages.BookStore.ProfilePage;
import pages.Elements.*;
import pages.Forms.PracticeFormPage;
import pages.Interactions.DroppablePage;
import pages.Widgets.MenuPage;
import pages.Widgets.SelectMenuPage;

public class SideMenu extends PageBase{
    public SideMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[1]")
    WebElement LoginPageLink;

    public LoginPage openLoginPage() {
        clickWithJSExecutor(LoginPageLink, 0, 700);
        this.wait(500);
        return new LoginPage(driver);
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[3]/div/ul/li[2]")
    WebElement alertsPageLink;

    // переместить в SideMenu
    public AlertsPage openAlertsPage() {
        clickWithJSExecutor(alertsPageLink, 0, 200);
        return new AlertsPage(driver);
    }

    @FindBy(xpath = "//span[.='Book Store']")
    WebElement bookStorePageLink;

    public BookStorePage openBookStorePage() {
        wait(1000);
        clickWithJSExecutor(bookStorePageLink, 0, 700);
        return new BookStorePage(driver);
    }


    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[3]")

    WebElement profilePageLink;

    public ProfilePage openProfilePage() {
        wait(1000);
        clickWithJSExecutor(profilePageLink, 0, 700);
        return new ProfilePage(driver);
    }

    @FindBy(xpath = "//span[.='Browser Windows']")
    WebElement browserWindowsLink;

    public BrowserWindowsPage openBrowserWindowsPage() {
        click(browserWindowsLink);
        return new BrowserWindowsPage(driver);
    }

    @FindBy(xpath = "//span[.='Frames']")
    WebElement framesPage;
    public FramesPage openFramesPage() {
        clickWithJSExecutor(framesPage, 0, 250);
        return new FramesPage(driver);
    }

    @FindBy(xpath = "//span[.='Nested Frames']")
    WebElement nestedFramesPage;

    public NestedFramesPage openNestedFramesPage() {
        clickWithJSExecutor(nestedFramesPage, 0, 250);
        return new NestedFramesPage(driver);
    }

    @FindBy(xpath = "//span[.='Select Menu']")
    WebElement selectMenuPage;
    public SelectMenuPage openSelectMenuPage() {
        clickWithJSExecutor(selectMenuPage, 0, 950);
        return new SelectMenuPage(driver);
    }

    @FindBy(xpath = "//span[.='Text Box']")
    WebElement selectTestBoxPage;
    public TextBoxPage openTestBoxPage() {
        click(selectTestBoxPage);
        return new TextBoxPage(driver);
    }

    @FindBy(xpath = "//span[.='Buttons']")
    WebElement buttonsPageLink;
    public ButtonsPage openButtonsPage() {
        clickWithJSExecutor(buttonsPageLink,0,400);
        wait(1000);
        return new ButtonsPage(driver);
    }

    @FindBy(xpath = "//span[.='Upload and Download']")
    WebElement uploadAndDownloadPageLink;
    public UploadDownloadPage openUploadDownloadPage() {
        clickWithJSExecutor(uploadAndDownloadPageLink,0,400);
        return new UploadDownloadPage(driver);
    }

    @FindBy(xpath = "//span[.='Broken Links - Images']")
    WebElement brokenLinksImages;
    public BrokenLinksImagesPage openBrokenLinksImages() {
        clickWithJSExecutor(brokenLinksImages, 0, 400);
        return new BrokenLinksImagesPage(driver);
    }

    @FindBy(xpath = "//span[.='Droppable']")
    WebElement droppable;
    public DroppablePage openDroppablePage() {
        clickWithJSExecutor(droppable, 0, 400);
        return new DroppablePage(driver);
    }

    @FindBy(xpath = "//span[.='Menu']")
    WebElement selectMenu;
    public MenuPage openMenuPage() {
        clickWithJSExecutor(selectMenu, 0, 400);
        return new MenuPage(driver);
    }

    @FindBy(xpath = "//span[.='Radio Button']")
    WebElement radioButtonLink;


    public RadioButtonPage openRadioButtonPage() {
        clickWithJSExecutor(radioButtonLink, 0, 200);
        return new RadioButtonPage(driver);

    }

    @FindBy(xpath = "//span[.='Practice Form']")
    WebElement PracticeFormLink;
    public PracticeFormPage openPracticeFormPage() {
        clickWithJSExecutor(PracticeFormLink, 0, 200);
        return new PracticeFormPage(driver);

    }

    @FindBy(xpath = "//div[.='Book Store Application']")
    public WebElement bookStoreApplication;
}
