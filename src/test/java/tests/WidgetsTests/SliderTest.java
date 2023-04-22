package tests.WidgetsTests;
// 29.03.2023
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SideMenu;
import pages.Widgets.SliderPage;
import tests.TestBase;

public class SliderTest extends TestBase {

    SliderPage sliderPage;

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).openWidgets();
        new SideMenu(driver).openSliderPage();
    }

    @Test
    public void sliderTest() {
        sliderPage = new SliderPage(driver);
        sliderPage.moveSlider("37");
//        sliderPage.moveSliderWithFor("37");
        Assert.assertEquals(sliderPage.getAttribute(), "37");
        Assert.assertEquals(sliderPage.getSliderValue(), "37");
    }
}
