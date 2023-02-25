package pages.data;

import pages.PageBase;
import org.openqa.selenium.WebDriver;

public class LoginData extends PageBase {
    public LoginData(WebDriver driver) {
        super(driver);
    }

    public static final String USERNAME = "OlgaSArte";
    public static final String PASSWORD = "Aos-123456!";
}
