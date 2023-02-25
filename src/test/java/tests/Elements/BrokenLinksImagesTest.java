package tests.Elements;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Elements.BrokenLinksImagesPage;
import pages.HomePage;
import pages.SideMenu;
import tests.TestBase;

import java.io.IOException;

public class BrokenLinksImagesTest extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).openElements();
        new SideMenu(driver).openBrokenLinksImages();
    }

    // Title: Check double click massage is displayed after Double Click Me button is double clicked
    @Test
    public void checkBrokenImages() {
        Assert.assertEquals(new BrokenLinksImagesPage(driver).checkNumberBrokenImages(), 0);

    }

    // status code >=400
    @Test
    public void checkBrokenLinks() throws IOException {
        Assert.assertEquals(new BrokenLinksImagesPage(driver).checkNumberBrokenLinks(), 0);

    }

//    можно проверить и другие ссылки, например, span из sideMenu

}