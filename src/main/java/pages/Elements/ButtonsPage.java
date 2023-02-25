package pages.Elements;

import pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;
import java.util.Collection;

public class ButtonsPage extends PageBase {
    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="doubleClickBtn")
    WebElement doubleClickBtn;

    @FindBy(id="rightClickBtn")
    WebElement rightClickBtn;

    @FindBy(id="doubleClickMessage")
    WebElement doubleClickMessage;

    @FindBy(id="rightClickMessage")
    WebElement rightClickMessage;

    public ButtonsPage doubleclick() {
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickBtn).perform();
        return this;
    }

    public ButtonsPage rightclick() {
        Actions actions = new Actions(driver);
        actions.contextClick(rightClickBtn).perform();
        return this;
    }

    public String checkDCMsg() {
        return doubleClickMessage.getText();
    }


    public String checkRCMsg() {
        return rightClickMessage.getText();
    }
}
