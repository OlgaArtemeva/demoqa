package tests.WidgetsTests;
//27.03.2023
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SideMenu;
import pages.Widgets.ProgressBarPage;
import tests.TestBase;

public class ProgressBarTest extends TestBase {
    String percent = Integer.toString(faker.number().numberBetween(10, 99));
    String actualPercent;
    ProgressBarPage progressBarPage;

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).openWidgets();
        new SideMenu(driver).openProgressBarPage();
    }

//    тест нестабилен т.к. динамический элемент (progressBar) меняется оч. часто (с fluentWait отрабатывае лучше, чем с explicitWait)
//    тест отработал на Firefox
    @Test
    public void progressBarTest() {
        progressBarPage = new ProgressBarPage(driver);
        progressBarPage.clickToButton();
        progressBarPage.clickToStop(percent);
        actualPercent = progressBarPage.getPercent();
        Assert.assertEquals(actualPercent, percent + "%");
        System.out.println(percent);
    }
}
