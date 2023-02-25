package tests.Elements;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import tests.TestBasePR;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class RadioButtonTestPR extends TestBasePR {
    @Test
    public void selectRadioButtons() {
        page.navigate("https://demoqa.com/radio-button");
        page.locator("#yesRadio").check(new Locator.CheckOptions().setForce(true));
        System.out.println(page.locator(".test-success"));
        assertThat( page.locator(".text-success") ).containsText("Yes");

        page.locator("#impressiveRadio").check(new Locator.CheckOptions().setForce(true));
        System.out.println(page.locator(".test-success"));
        assertThat( page.locator(".text-success") ).containsText("Impressive");

    }
}
