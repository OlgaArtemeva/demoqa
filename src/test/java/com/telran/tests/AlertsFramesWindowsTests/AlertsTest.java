package com.telran.tests.AlertsFramesWindowsTests;

import com.telran.pages.AlertsFrameWindowsPages.AlertsPage;
import com.telran.pages.HomePage;
import com.telran.pages.SideMenu;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).openAlertsFrameWindowsPage();
        new SideMenu(driver).openAlertsPage();
    }

    @Test
    public void invokeAlert() {
        new AlertsPage(driver).clickOnSimpleAlert();
    }

    @Test
    public void simpleAlert5Secs() {
        new AlertsPage(driver).clickOnSimpleAlertWithTimer();
    }

    @Test
    public void confirmBoxTest() {
        Assert.assertTrue(new AlertsPage(driver).clickOnConfirmBox("OK").getConfirmText().contains("OK"));
        Assert.assertTrue(new AlertsPage(driver).clickOnConfirmBox("Cancel").getConfirmText().contains("Cancel"));
    }

    @Test
    public void enterTextToPromptTest() {
        String name = "Olga";
        new AlertsPage(driver).enterTextToPrompt(name);
        Assert.assertTrue(new AlertsPage(driver).getPromptResult().contains(name));
    }

}