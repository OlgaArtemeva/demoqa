package tests.WidgetsTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SideMenu;
import pages.Widgets.DatePickerPage;
import tests.TestBase;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import static com.google.common.base.Preconditions.checkArgument;

public class DatePickerTests extends TestBase {
    DatePickerPage datePickerPage;
    String testDate;
    String actualTestDate;
    String expectedTestDate;
    LocalDate date = LocalDate.now().plusDays(1);
    LocalDate datePlusMonths = LocalDate.now().plusMonths(1);
    String time;
    LocalDateTime timePlus = LocalDateTime.now().plusHours(2);
    DateTimeFormatter chooseFormatter;
    DateTimeFormatter actualFormatter;
    DateTimeFormatter timeFormatter;
    DateTimeFormatter  actualDateTimeFormatter;

    public String getRandomMin() {
        List<String> min = Arrays.asList("00", "15", "30", "45");
        Random random = new Random();
        int randomIndex = random.nextInt(min.size());
        return min.get(randomIndex);
    }

    public String getFormatter(LocalDate date) {
        checkArgument(date.getDayOfMonth() >= 1 && date.getDayOfMonth() <= 31, "illegal day of month: " + date.getDayOfMonth());
        if (date.getDayOfMonth() >= 11 && date.getDayOfMonth() <= 13) {
            return "th";
        }
        switch (date.getDayOfMonth() % 10) {
            case 1:
                return "st";
            case 2:
                return "nd";
            case 3:
                return "rd";
            default:
                return "th";
        }
    }

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).openWidgets();
        new SideMenu(driver).openDatePickerPage();
    }

    @Test
    public void choseDataTest() {
        // Monday, April 10th, 2023   !!!!!! ... 2nd, 3rd ...19th  21st 22nd
        chooseFormatter = DateTimeFormatter.ofPattern("EEEE, MMMM d'" + getFormatter(date) + "', yyyy", Locale.ENGLISH);
        // 04/18/2023
        actualFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.ENGLISH);
        testDate = date.format(chooseFormatter);
        expectedTestDate = date.format(actualFormatter);
        datePickerPage = new DatePickerPage(driver);
        Assert.assertTrue(datePickerPage.getCalendar());
        datePickerPage.chooseDate(testDate);
        actualTestDate = datePickerPage.getDateFromField();
        Assert.assertEquals(actualTestDate, expectedTestDate);
    }

    @Test
    public void choseDataPlusMonthsTest() {
        // Monday, April 10th, 2023   !!!!!! ... 2nd, 3rd ...19th  21st 22nd
        chooseFormatter = DateTimeFormatter.ofPattern("EEEE, MMMM d'" + getFormatter(datePlusMonths) + "', yyyy", Locale.ENGLISH);
        // 04/18/2023
        actualFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.ENGLISH);
        testDate = datePlusMonths.format(chooseFormatter);
        expectedTestDate = datePlusMonths.format(actualFormatter);
        datePickerPage = new DatePickerPage(driver);
        Assert.assertTrue(datePickerPage.getCalendar());
        datePickerPage.getNextMonth();
        datePickerPage.chooseDate(testDate);
        actualTestDate = datePickerPage.getDateFromField();
        Assert.assertEquals(actualTestDate, expectedTestDate);
    }

    @Test
    public void choseTimeDataTest() {
        // Monday, April 10th, 2023   !!!!!! ... 2nd, 3rd ...19th  21st 22nd
        chooseFormatter = DateTimeFormatter.ofPattern("EEEE, MMMM d'" + getFormatter(date) + "', yyyy", Locale.ENGLISH);
        // 04/18/2023
        String randomMin = getRandomMin();
        actualDateTimeFormatter = DateTimeFormatter.ofPattern("MMMM d, yyyy hh:" + randomMin + " a", Locale.ENGLISH);
        timeFormatter = DateTimeFormatter.ofPattern("HH:" + randomMin);

        testDate = timePlus.toLocalDate().format(chooseFormatter);
        expectedTestDate = timePlus.format(actualDateTimeFormatter);
        time = timePlus.format(timeFormatter);
        datePickerPage = new DatePickerPage(driver);
        Assert.assertTrue(datePickerPage.getDateTimeCalendar());
        datePickerPage.chooseDate(testDate);
        datePickerPage.chooseTime(time);
        actualTestDate = datePickerPage.getDateTimeFromField();
        Assert.assertEquals(actualTestDate, expectedTestDate);
    }
}