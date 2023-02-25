package tests.WidgetsTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SideMenu;
import pages.Widgets.MenuPage;
import tests.TestBase;

public class MenuTest extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).openWidgets();
        new SideMenu(driver).openMenuPage();
    }

    // не работает
    @Test
    public void checkSubSubMenu() {
        Assert.assertTrue( new MenuPage(driver).openSubSubMenu().getSubSubItemText().contains("Item 1"));
    }

}

