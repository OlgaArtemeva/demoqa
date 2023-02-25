package tests.AlertsFramesWindowsTests;

import org.junit.jupiter.api.Test;
import tests.TestBasePR;


import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class FramesTestPR extends TestBasePR {
    @Test
    public void SwitchToFrameById(){
        page.navigate("https://demoqa.com/frames");
        assertThat(page.frameLocator("#frame1").locator("#sampleHeading")).containsText("sample");
    }
}
