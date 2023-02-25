package tests.Elements;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Elements.RadioButtonPage;
import pages.HomePage;
import pages.SideMenu;
import tests.TestBase;

public class RadioButtonTest extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).openElements();
        new SideMenu(driver).openRadioButtonPage();

    }

    @Test
    public void selectRadioButtons() {
        Assert.assertTrue( new RadioButtonPage(driver).selectYes().checkSelected().contains("Yes") );
    }
}

