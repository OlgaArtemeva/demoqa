package tests.AlertsFramesWindowsTests;

import org.junit.jupiter.api.Test;
import tests.TestBasePR;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class NestedFramesTestPR extends TestBasePR {

    @Test
    public void verifyTextInParentAndChildFrames(){
        page.navigate("https://demoqa.com/nestedframes");

        assertThat(page.frameLocator("#frame1").locator("body")).containsText("Parent frame");
        assertThat(page.frameLocator("#frame1").frameLocator("[srcdoc='<p>Child Iframe</p>']").locator("p")).containsText("Child Iframe");

    }
}
