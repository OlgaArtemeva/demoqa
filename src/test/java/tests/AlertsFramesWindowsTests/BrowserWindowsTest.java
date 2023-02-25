package tests.AlertsFramesWindowsTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AlertsFrameWindowsPages.BrowserWindowsPage;
import pages.HomePage;
import pages.SideMenu;
import tests.TestBase;

public class BrowserWindowsTest extends TestBase {
    @BeforeMethod
    public void preconditions() {
        new HomePage(driver).openAlertsFrameWindowsPage();
        new SideMenu(driver).openBrowserWindowsPage();
    }

    @Test
    public void clickOnNewTabTest() {
        new BrowserWindowsPage(driver).openNewTab();
        Assert.assertTrue(new BrowserWindowsPage(driver).getNewPageHeading().contains("sample"));
    }

    @Test
    public void clickOnNewWindow() {
        new BrowserWindowsPage(driver).openNewWindow();
        Assert.assertTrue(new BrowserWindowsPage(driver).getNewPageHeading().contains("sample"));
    }
// не отрабатывает, т.к. в Google Chrome окно не прогружается и обработать его не получается
//    @Test
//    public void openNewMessageWindowButtonTest() {
//        new BrowserWindowsPage(driver).openNewMessageWindowButton();
//        Assert.assertTrue( new BrowserWindowsPage(driver).getNewWindowPageHeading().contains("Knowledge") );
//    }
}


