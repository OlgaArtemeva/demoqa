package pages.Forms;

import pages.PageBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

public class SubmittingFormPage extends PageBase {
    public SubmittingFormPage(WebDriver driver) {
        super(driver);
    }

    //    @FindBy(xpath = "//td[contains(text(), 'Sergio Smith')]")
    @FindBy(xpath = "//tbody/tr[1]/td[2]")
    WebElement studentName;

    @FindBy(xpath = "//tbody/tr[2]/td[2]")
    WebElement studentEmail;

    @FindBy(xpath = "//tbody/tr[3]/td[2]")
    WebElement gender;

    @FindBy(xpath = "//tbody/tr[4]/td[2]")
    WebElement mobile;

    @FindBy(xpath = "//tbody/tr[5]/td[2]")
    WebElement dateOfBirth;

    @FindBy(xpath = "//tbody/tr[6]/td[2]")
    WebElement subjects;

    @FindBy(xpath = "//tbody/tr[7]/td[2]")
    WebElement hobbies;

    @FindBy(xpath = "//tbody/tr[8]/td[2]")
    WebElement picture;

    @FindBy(xpath = "//tbody/tr[9]/td[2]")
    WebElement address;

    @FindBy(xpath = "//tbody/tr[10]/td[2]")
    WebElement stateAndCity;

    @FindBy(id="closeLargeModal")
    WebElement closeLargeModal;


    public Map<String, String> getSubmittingFormInfo() {
        hideAds();
        Map<String, String> contactInfo = new HashMap<>();
        contactInfo.put("student name", studentName.getText());
        contactInfo.put("student Email", studentEmail.getText());
        contactInfo.put("gender", gender.getText());
        contactInfo.put("mobile", mobile.getText());
        contactInfo.put("date of Birth", dateOfBirth.getText());
        contactInfo.put("subjects", subjects.getText());
        contactInfo.put("hobbies", hobbies.getText());
        contactInfo.put("picture", picture.getText());
        contactInfo.put("address", address.getText());
        contactInfo.put("state and city", stateAndCity.getText());


//        PracticeFormPage sideMenu = new PracticeFormPage(driver);
        Actions act = new Actions(driver);
        act.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();


//        closeLargeModal.click();
//        clickWithJSExecutor(closeLargeModal, 0, 700);
        return contactInfo;

    }

}
