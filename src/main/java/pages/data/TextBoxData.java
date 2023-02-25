package pages.data;

import pages.PageBase;
import org.openqa.selenium.WebDriver;

public class TextBoxData extends PageBase {
    public TextBoxData(WebDriver driver) {
        super(driver);
    }

    public static final String FULLNAME = "John Doe";
    public static final String EMAIL = "john@doe.com";
    public static final String ADDRESS = "10318, Germany, Berlin, Marksburgstrasse 1";

}
