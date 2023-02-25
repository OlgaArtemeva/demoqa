package pages;

import pages.AlertsFrameWindowsPages.AlertsPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BookStore.BookStorePage;


public class HomePage extends PageBase{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[6]")
    WebElement bookStoreAppLink;

    public BookStorePage openBookStoreApp() {
        clickWithJSExecutor(bookStoreAppLink, 0, 500);

        return new BookStorePage(driver);
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[3]")
    WebElement alertsFrameWindowsLink;

    public AlertsPage openAlertsFrameWindowsPage() {
//        click(alertsFrameWindowsLink);
        clickWithJSExecutor(alertsFrameWindowsLink, 0, 200);
        return new AlertsPage(driver);
    }

    @FindBy(xpath = "//h5[.='Widgets']")
    WebElement openWidgetsLink;

    public SideMenu openWidgets() {
        clickWithJSExecutor(openWidgetsLink, 0, 200);
        return new SideMenu(driver);
    }

    @FindBy(xpath = "//h5[.='Elements']")
    WebElement elementlementsPageLink;
    public SideMenu openElements() {
        clickWithJSExecutor(elementlementsPageLink, 0, 200);
        return new SideMenu(driver);
    }

    @FindBy(xpath = "//h5[.='Interactions']")
    WebElement interactionsPageLink;
    public SideMenu openInteractions() {
        clickWithJSExecutor(interactionsPageLink, 0, 200);
        return new SideMenu(driver);

    }

    @FindBy(xpath = "//h5[.='Forms']")
    WebElement FormsPageLink;
    public SideMenu openForms() {
        clickWithJSExecutor(FormsPageLink, 0, 200);
        return new SideMenu(driver);
    }
}
