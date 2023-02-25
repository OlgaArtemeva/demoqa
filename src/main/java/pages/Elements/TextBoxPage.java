package pages.Elements;

import pages.PageBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.data.TextBoxData;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.Collection;

public class TextBoxPage extends PageBase {
    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName")
    WebElement fullName;

    @FindBy(id = "userEmail")
    WebElement email;

    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    @FindBy(id = "permanentAddress")
    WebElement permanentAddress;

    @FindBy(id = "submit")
    WebElement submit;

    public void fillAndSubmitForm() throws IOException, UnsupportedFlavorException {
        type(fullName, TextBoxData.FULLNAME);
        type(email, TextBoxData.EMAIL);
        type(currentAddress, TextBoxData.ADDRESS);

        Actions action = new Actions(driver);

        Keys cmdCtrl = getCmdCtrl();

        action.keyDown(currentAddress, cmdCtrl).sendKeys("a").keyUp(cmdCtrl).perform();
        action.keyDown(cmdCtrl).sendKeys("c").keyUp(cmdCtrl).perform();

        // проверяем содержимое буфера обмена
//        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//        Transferable contents = clipboard.getContents(null);
//
//        String result = (String)contents.getTransferData(DataFlavor.stringFlavor);
//
//        if (result == TextBoxData.ADDRESS) {
//            action.keyDown(Keys.TAB);
//            action.keyDown(cmdCtrl).sendKeys("v").keyUp(cmdCtrl).perform();
//        }

        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable contents = clipboard.getContents(null);

        String result = (String)contents.getTransferData(DataFlavor.stringFlavor);

        if (result.equals(TextBoxData.ADDRESS))
        {
            action.sendKeys(Keys.TAB);
            action.keyDown(cmdCtrl).sendKeys("v").keyUp(cmdCtrl).perform();
        }

        clickWithJSExecutor(submit, 0, 150);
    }

    @FindBy(id = "output")
    WebElement output;

    public String checkSubmittedData() {
        return output.getText();
    }
    @FindBy(xpath = "//p[@id='permanentAddress']")
    WebElement outPermanentAddress;
    public String getPermanentAdress() {
//        System.out.println(permanentAddress.getText()); //для проверки
        return outPermanentAddress.getText();
    }

}
