package pages.Widgets;

//27.03.2023
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PageBase;

import java.time.Duration;

public class ProgressBarPage extends PageBase {
    public ProgressBarPage(WebDriver driver) {
        super(driver);
    }

//    @FindBy(xpath = "//button[@id='startStopButton']")
    @FindBy(xpath = "//button[@id=\"startStopButton\"]")
    private WebElement startStopButton;

    @FindBy(xpath = "//div[@role='progressbar']")
    private WebElement progressBar;

    private final String ATTRIBUTE_NAME = "aria-valuenow";

    public void clickToButton() {
        startStopButton.click();
    }

    public String getAttributeValue() {
        return progressBar.getAttribute(ATTRIBUTE_NAME);
    }

    public void explicitWaitForAttribute(String persent) {
        new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.attributeToBe(progressBar, ATTRIBUTE_NAME, persent));
    }

    public void fluentWaitAttribute(String percent) {
        new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofNanos(2000000))
                .until(ExpectedConditions.attributeToBe(progressBar, ATTRIBUTE_NAME, percent));
    }

    public void clickToStop(String percent) {
//        explicitWaitForAttribute(percent);
        fluentWaitAttribute(percent);
        clickToButton();
    }

    public String getPercent() {
        return progressBar.getText();
    }
}
