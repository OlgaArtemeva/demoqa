package tests.Interactions;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.Interactions.DroppablePage;
import pages.SideMenu;
import tests.TestBase;

public class DroppableTest extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).openInteractions();
        new SideMenu(driver).openDroppablePage();
    }

    @Test
    public void dragHereTest() {
        Assert.assertTrue(new DroppablePage(driver).testDroppableHere().getDroppedResult().contains("Dropped!"));
    }

    @Test
    public void dragByOffsetElement() {
        Assert.assertTrue(new DroppablePage(driver).testDroppableByOffset().getDroppedResult().contains("Dropped!"));
    }

}
