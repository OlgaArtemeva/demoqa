package tests.WidgetsTests;

import com.microsoft.playwright.Locator;

import org.junit.jupiter.api.Test;
import tests.TestBasePR;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class SliderTestPR extends TestBasePR {

    @Test
    public void moveSliderWithKeyboard() {
        page.navigate("https://demoqa.com/slider");

        Locator slider = page.locator(".range-slider--primary");

        slider.focus();
        while ( Integer.valueOf(slider.getAttribute("value")) < 40)  //getAttribute возвращает строку, метод valueOf преобразует ее в Integer
        {
            slider.press("ArrowRight");}     //https://playwright.dev/docs/api/class-keyboard

        assertThat( page.locator("#sliderValue") ).hasValue("40");
    }

    @Test
    public void moveSliderMouseClick() {
        page.navigate("https://demoqa.com/slider");
        Locator slider = page.locator(".range-slider--primary");

        var box = slider.boundingBox();
        page.mouse().click(box.x + box.width / 100 * 40, box.y + box.height / 2);
        assertThat( page.locator("#sliderValue") ).hasValue("40");
    }

}
