package tests.BookStoreTests;

import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.*;
import pages.data.LoginData;
import tests.TestBasePR;

import java.awt.*;
import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class BookStoreLoginTestPR extends TestBasePR {

    @Test
    public void positiveAuthTest() {
        page.navigate("https://demoqa.com/");
//        page.navigate("https://demoqa.com/login");

        page.locator("#app > div > div > div.home-body > div > div:nth-child(6)").click();
//        page.locator("#item-0 > span").click();
        page.getByRole(AriaRole.LIST).getByText("Login").click();

        assertThat(page).hasTitle(Pattern.compile("DEMOQA"));

        page.locator("input[id='userName']").click();
        page.locator("input[id='userName']").fill(LoginData.USERNAME);
        page.getByPlaceholder("Password").click();
        page.getByPlaceholder("Password").fill(LoginData.PASSWORD);

        page.locator("#login").click(); // #login < - > id="login"

        assertThat(page.locator("#userName-value")).containsText(LoginData.USERNAME);
    }
}
