package pages.Widgets;

import pages.PageBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.Collection;
import java.util.List;


public class SelectMenuPage extends PageBase {
    public SelectMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='withOptGroup']/div")
//    @FindBy(xpath = "//*[@id=\"withOptGroup\"]/div")
    WebElement selectValueSelect;

    @FindBy(id = "selectMenuContainer")
    WebElement containerFreeSpase;

    public SelectMenuPage choseFromSelectValue() {

//        type(selectValueSelect, "Group 1"); // указали в actions.sentKeys...
        Actions actions = new Actions(driver);
        actions.sendKeys(selectValueSelect, "Group 1, option 1" + Keys.ENTER).perform();
        click(containerFreeSpase); // кликаем по пустой области
        wait(3000);
        return this;
    }

    @FindBy(xpath = "//*[@id='selectOne']/div/div[1]")
//    @FindBy(xpath = "//*[@id=\"selectOne\"]/div/div[1]")
    WebElement selectValueOne;

    public SelectMenuPage choseFromSelectOne() {
        Actions actions = new Actions(driver);
        actions.sendKeys(selectValueOne, "Prof" + Keys.ENTER).perform();
        click(containerFreeSpase);
        wait(3000);
        return this;
    }

    public String getSelectValueText() {
        return selectValueSelect.getText();
    }

    public String getSelectOneText() {
        return selectValueOne.getText();
    }

//    мой вариант
//    @FindBy(xpath = "//select[@id='oldSelectMenu']/option[4]")
//    WebElement choseYellow;
//    public SelectMenuPage choseYellowFromOldStyleSelect() {
//        click(choseYellow);
//        wait(1000);
//        return new SelectMenuPage(driver);
//    }
//
//    public String getOldStyleSelectValueText() {
//        return choseYellow.getText();
//    }

//    вариант Ильи

    //@FindBy(id="oldSelectMenu")
    @FindBy(xpath="//*[@id='oldSelectMenu']")
    WebElement oldSelectMenu;

    public SelectMenuPage choseYellowFromOldStyleSelect() {
        Select select = new Select(oldSelectMenu);
        select.selectByValue("3");
        return this;
    }


    public String getOldStyleSelectValueText() {
        Select select = new Select(oldSelectMenu);
        return select.getFirstSelectedOption().getText();
    }

    @FindBy(xpath = "//select[@id='cars']")
    WebElement standardMultiSelectMenu;

    public SelectMenuPage choseVolvoAndOpelFromStandardMultiSelect() {
        Select select = new Select(standardMultiSelectMenu);
        select.selectByValue("volvo");
        select.selectByValue("opel");
        wait(3000);
//        select.getAllSelectedOptions();
        return this;
    }

    public List<WebElement> getStandardMultiValue() {
        Select select = new Select(standardMultiSelectMenu);
        return select.getAllSelectedOptions();
    }

}
