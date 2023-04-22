package tests.WidgetsTests;

import com.microsoft.playwright.Locator;

import org.junit.jupiter.api.Test;
import tests.TestBasePR;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DatePickerTestPR extends TestBasePR {
    @Test
    public void datePickerSelectTomorrow() {
        page.navigate("https://demoqa.com/date-picker");
        page.locator("#datePickerMonthYearInput").click();

        LocalDateTime todayDate = LocalDateTime.now();
        System.out.println(todayDate);
        LocalDateTime tomorrowDate = todayDate.plusDays(1);

        System.out.println(tomorrowDate);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy"); //паттерн
        String tomorrowDateFormatted = tomorrowDate.format(formatter);

        System.out.println(tomorrowDateFormatted);

//        для сравнения проверки, что разные xpath находят один и тот же элемент (не потребовалось)
//        String todayDay = page.locator("//div[contains(@class, 'today')]").getAttribute("aria-label");
//        String endMonthDay = page.locator("//*[@id='datePickerMonthYear']/div[2]/div[2]/div/div/div[2]/div[2]/div[6]/div[7]").getAttribute("aria-label");
//        if (todayDay.equals(endMonthDay)) {...}

//        System.out.println(todayDate.getDayOfWeek());
        String weekDay = todayDate.getDayOfWeek().toString();

        if (weekDay.equals("SATURDAY")) {
            page.locator("//div[contains(@class, 'today')]/following::div[1]/div[1]").click();
        } else {
            page.locator("//div[contains(@class, 'today')]/following-sibling::div[1]").click();
        }

        assertThat(page.locator("#datePickerMonthYearInput")).hasValue(tomorrowDateFormatted);

    }
}