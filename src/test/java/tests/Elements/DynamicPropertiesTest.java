package tests.Elements;

//27.03.2023
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import pages.Elements.DynamicPropertiesPage;
import pages.HomePage;
import pages.SideMenu;
import tests.TestBase;

public class DynamicPropertiesTest extends TestBase {
    DynamicPropertiesPage dynamicPropertiesPage;

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).openElements();
        new SideMenu(driver).openDynamicPropertiesPage();
    }

    @Test
    public void waitButton() {
        dynamicPropertiesPage = new DynamicPropertiesPage(driver);
        dynamicPropertiesPage.waitButton();
    }
}
