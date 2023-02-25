package tests.AlertsFramesWindowsTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AlertsFrameWindowsPages.FramesPage;
import pages.HomePage;
import pages.SideMenu;
import tests.TestBase;


public class FramesTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).openAlertsFrameWindowsPage();
        new SideMenu(driver).openFramesPage();
    }

    @Test(enabled = false) // не можем корректно выполнить из-за окон рекламы
    public void ensureNumberOfFrames(){
        Assert.assertEquals(new FramesPage(driver).getFramesNumber(), 2);
    }

    @Test
    public void switchToFrameByID() {
        Assert.assertTrue( new FramesPage(driver).switchToFrameByID().getH1().contains("sample"));
    }
}

