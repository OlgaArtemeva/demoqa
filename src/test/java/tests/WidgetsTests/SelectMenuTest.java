package tests.WidgetsTests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SideMenu;
import pages.Widgets.SelectMenuPage;
import tests.TestBase;

import java.util.List;

public class SelectMenuTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).openWidgets();
        new SideMenu(driver).openSelectMenuPage();
    }

    @Test
    public void  fillInTwoSelectFields() {
        Assert.assertTrue( new SelectMenuPage(driver).choseFromSelectValue().getSelectValueText().contains("Group 1"));
        Assert.assertTrue( new SelectMenuPage(driver).choseFromSelectOne().getSelectOneText().contains("Prof."));

    }

    @Test
    public void oldStyleSelectMenu() {
        SelectMenuPage ourPage = new SelectMenuPage(driver);

        // Step 1: Click on dropdown menu (old style select menu)
        // Step 2: Chose Yellow by clicking on this value in the list
        ourPage.choseYellowFromOldStyleSelect();

        // Expected result: Yellow is selected in the old style select
        String ourText = ourPage.getOldStyleSelectValueText();
        Assert.assertTrue( ourText.contains("Yellow") );

        //Assert.assertTrue( new SelectMenuPage(driver).choseFromOldStyleSelect().getOldStyleSelectValue().contains("Yellow") );
    }

    //    Write test to select Volvo and Opel from “Standard multi select” select menu
    @Test
    public void standardMultiSelect() {
        List<WebElement> selectItems= new SelectMenuPage(driver).choseVolvoAndOpelFromStandardMultiSelect().getStandardMultiValue();
        Assert.assertTrue(selectItems.get(0).getText().contains("Volvo"));
        Assert.assertTrue(selectItems.get(1).getText().contains("Opel"));
    }
}

