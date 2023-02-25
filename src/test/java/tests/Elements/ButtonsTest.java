package tests.Elements;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Elements.ButtonsPage;
import pages.HomePage;
import pages.SideMenu;
import tests.TestBase;

public class ButtonsTest extends TestBase {

    // Pre-conditions: Buttons page is opened from the home page and side menu
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).openElements();
        new SideMenu(driver).openButtonsPage();
    }

    // Title: Check double click massage is displayed after Double Click Me button is double clicked
    @Test
    public void clickOnDoubleClickButton() {
        //Step1: double click on Double Click Me button
        //Expected result: double click massage is displayed
        Assert.assertTrue(new ButtonsPage(driver).doubleclick().checkDCMsg().contains("double"));
    }

    // Title: Check right click massage is displayed after Right Click Me button is right clicked
    @Test
    public void clickOnRightClickButton() {
        //Step1: double click on Right Click Me button
        //Expected result: right click massage is displayed
        Assert.assertTrue(new ButtonsPage(driver).rightclick().checkRCMsg().contains("right"));
    }

}
