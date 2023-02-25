package tests.Elements;

import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import tests.TestBasePR;


import java.net.URI;
import java.net.URISyntaxException;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BrokenLinksImagesTestPR extends TestBasePR {

    // добавить проверку на относительные ссылки
    @Test
    public void checkBrokenLinks() throws URISyntaxException {
        page.navigate("https://demoqa.com/broken");
        for (Locator link : page.getByRole(AriaRole.LINK).all()) {
            System.out.println(link.textContent());
            APIResponse response = page.request().get(link.getAttribute("href"));
            assertThat(response).isOK(); // isOK() - status code is within 200..299 range
        }
    }


    @Test
    public void checkBrokenImages2() throws URISyntaxException {
        page.navigate("https://demoqa.com/broken");
        for (Locator image : page.getByRole(AriaRole.IMG).all()) {
            String src = image.getAttribute("src");
//            if (src.equals(null)){continue;}
            System.out.println("до " + src);
            // http(s) + :// + host  + src
            URI uri = new URI(page.url());
            // uri.getScheme() -- https
            // uri.getHost() -- demoqa.com
            if (!src.startsWith("http")) {src = uri.getScheme() + "://" + uri.getHost() + src;}
            System.out.println("после " + src);
            APIResponse response = page.request().get(src);
            assertThat(response).isOK();

            assertTrue(response.headers().get("content-type").contains("image"));
            System.out.println("получили " + image.evaluate("node => node.naturalWidth"));
            assertFalse(image.evaluate("node => node.naturalWidth").equals(0),   // https://playwright.dev/docs/evaluating
                    "Failed: image naturalWidth == 0");
        }
    }
}
