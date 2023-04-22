package pages.Widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

public class DatePickerPage extends PageBase {
    public DatePickerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='datePickerMonthYearInput']")
    private WebElement datePickerField;
    @FindBy(xpath = "//div[@class='react-datepicker__month-container']")
    private WebElement calendar;
    @FindBy(xpath = "//button[@aria-label='Next Month']")
    private WebElement nextMonth;
    @FindBy(xpath = "//input[@id='dateAndTimePickerInput']")
    private WebElement dateTimePickerField;
    @FindBy(xpath = "//div[@class='react-datepicker']")
    private WebElement dateTimeCalendar;

    public boolean getCalendar() {
        datePickerField.click();
        return calendar.isDisplayed();
    }

    public boolean getDateTimeCalendar() {
        dateTimePickerField.click();
        return dateTimeCalendar.isDisplayed();
    }
    public void chooseDate(String date){
        driver.findElement(By.xpath(String.format("//div[@aria-label='Choose %s']", date))).click();
    }
    public void chooseTime(String time){
        driver.findElement(By.xpath(String.format("//li[normalize-space()='%s']", time))).click();
    }
    public void getNextMonth() {
        driver.findElement(By.xpath("//button[@aria-label='Next Month']")).click();
    }
    public String getDateFromField() {
        return datePickerField.getAttribute("value");
    }

    public String getDateTimeFromField() {
        return dateTimePickerField.getAttribute("value");

    }
}
