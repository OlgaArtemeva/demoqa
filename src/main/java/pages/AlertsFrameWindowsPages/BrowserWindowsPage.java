package pages.AlertsFrameWindowsPages;


import pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class BrowserWindowsPage extends PageBase {
    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="tabButton")
    WebElement newTabButton;

    @FindBy (id = "windowButton")
    WebElement newWindowButton;

    @FindBy(id="messageWindowButton")
    WebElement newMessageWindowButton;

    public BrowserWindowsPage openNewTab() {
        click(newTabButton);
        //String thisWindow = driver.getWindowHandle();
        List<String> allWindows = new ArrayList<>(driver.getWindowHandles());
        String tabName = allWindows.get(1);
        driver.switchTo().window(tabName);
        return this;
    }

    @FindBy(id="sampleHeading")
    WebElement newPageHeading;

    public String getNewPageHeading(){
        return newPageHeading.getText();
    }


    public BrowserWindowsPage openNewWindow() {
        click(newWindowButton);
        String thisWindow = driver.getWindowHandle();
        for (String windowH: driver.getWindowHandles()) {
            System.out.println(windowH);
            if (!thisWindow.contentEquals(windowH))
            {
                driver.switchTo().window(windowH);
                break;
            }
        }
        return this;
    }

    @FindBy(xpath = "/html/body/text()")
    WebElement newWindowPageHeading;

    // в Google Chrome окно не прогружается и обработать его не получается
    public String getNewWindowPageHeading() {
//        Browser.cancelDownload();
        return newWindowPageHeading.getText();
    }
    public BrowserWindowsPage openNewMessageWindowButton() {

        wait(1000);
        String thisWindow = driver.getWindowHandle(); // getWindowHandle() - строчка, идентифицирующая набором символов название текущего окна

        click(newMessageWindowButton);

        for (String windowH : driver.getWindowHandles()) // getWindowHandles() возвращает set из названий всех открытых окон
        {
            System.out.println(windowH);
            if (!thisWindow.contentEquals(windowH))
            {
                driver.switchTo().window(windowH);
                break;
            }
        }

        return this;
    }

}
