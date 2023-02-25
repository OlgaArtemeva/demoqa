package pages.Widgets;

import pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends PageBase {
    public MenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[.='Main Item 2']")
    WebElement mainItem2;
    @FindBy(xpath = "//a[.='SUB SUB LIST »']")
    WebElement subSubList;
    @FindBy(xpath = "//a[.='Sub Sub Item 1']")
    WebElement subSubItem1;

    public MenuPage openSubSubMenu() {
        hideAds();

        Actions actions = new Actions(driver);
        wait(1000);
        actions.moveToElement(mainItem2).perform();
        wait(1000);
        actions.moveToElement(subSubList).perform();
        actions.moveToElement(subSubItem1).perform();

        return this;
    }


    public String getSubSubItemText() {
        return subSubItem1.getText();
    }

}
