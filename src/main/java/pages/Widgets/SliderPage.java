package pages.Widgets;
// 29.03.2023 тест не рекомендова для автоматицации (нестабилен и не повторяет действия человека), лучше сделать unit тесты на бекэнде
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

public class SliderPage extends PageBase {
    public SliderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@type='range']")
    private WebElement slider;

    @FindBy(xpath = "//input[@id=\"sliderValue\"]")
    private WebElement sliderValue;

    public String getAttribute() {
        return slider.getAttribute("value");
    }

    public String getSliderValue() {
        return sliderValue.getAttribute("value");
    }

    public String getCss() {
        return sliderValue.getCssValue("range-slider");
    }

    // 1 вариант
    public void moveSlider(String value) {
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(slider, -500, 0).build().perform();
        String valueNow;

        do {
            actions.sendKeys(Keys.ARROW_RIGHT).perform();
            valueNow = getAttribute();
        } while (!valueNow.equals(value));
//        new WebDriverWait(driver, Duration.ofSeconds(20))
//                .until(ExpectedConditions.attributeToBe(slider,"value", value));

    }

    // 2 вариант
    public void moveSliderWithFor(String value) {
        int val = Integer.parseInt(value);
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(slider, -500, 0).build().perform();
        String valueNow;

        for(int i = 0; i<val; i++) {
            actions.sendKeys(Keys.ARROW_RIGHT).perform();
        }

    }
}
