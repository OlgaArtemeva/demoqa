package tests.AlertsFramesWindowsTests;

import org.junit.jupiter.api.Test;
import tests.TestBasePR;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class AlertsTestPR extends TestBasePR {

    @Test
    public void confirmBoxTestOK() {
        page.navigate("https://demoqa.com/alerts");
        page.onDialog(dialog -> dialog.accept());
        page.locator("#confirmButton").click();
        assertThat(page.locator("#confirmResult")).containsText("Ok");
    }
    @Test
    public void confirmBoxTestCancel() {
        page.navigate("https://demoqa.com/alerts");
        page.onDialog(dialog -> dialog.dismiss());
        page.locator("#confirmButton").click();
        assertThat(page.locator("#confirmResult")).containsText("Cancel");
    }

    @Test
    public void confirmPromptBoxTestCancel() {
        page.navigate("https://demoqa.com/alerts");
        page.onDialog(dialog -> dialog.accept("1231232"));
        page.locator("#promtButton").click();
        assertThat(page.locator("#promptResult")).containsText("1231232");
    }

}
