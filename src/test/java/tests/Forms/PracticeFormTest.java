package tests.Forms;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Forms.PracticeFormPage;
import pages.Forms.SubmittingFormPage;
import pages.HomePage;
import pages.SideMenu;
import tests.TestBase;

import java.util.Map;

public class PracticeFormTest extends TestBase {


    Faker faker = new Faker();
    PracticeFormPage practiceFormPage;
    SubmittingFormPage submittingFormPage;
    Map<String, String> submittingFormInfo;


    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String Email = faker.internet().emailAddress();
    String mobileNumber = faker.numerify("##########");
    String currentAddress = faker.address().fullAddress();

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).openForms();
        new SideMenu(driver).openPracticeFormPage();
    }

    @Test
    public void fillPracticeFormPageTest() {
        practiceFormPage = new PracticeFormPage(driver);
        practiceFormPage.fillStudentRegistrationFormPositive(firstName, lastName, Email, mobileNumber, currentAddress);
        submittingFormPage = new SubmittingFormPage(driver);
        submittingFormInfo = submittingFormPage.getSubmittingFormInfo();

        Assert.assertEquals(submittingFormInfo.get("student name"), firstName + " " + lastName);
        Assert.assertEquals(submittingFormInfo.get("student Email"), Email);
        Assert.assertEquals(submittingFormInfo.get("gender"), "Male");
        Assert.assertEquals(submittingFormInfo.get("mobile"), mobileNumber);
        Assert.assertEquals(submittingFormInfo.get("date of Birth"), "18 February,2023");
        Assert.assertEquals(submittingFormInfo.get("subjects"), "English");
        Assert.assertEquals(submittingFormInfo.get("hobbies"), "Sports");
        Assert.assertEquals(submittingFormInfo.get("picture"), "");
        Assert.assertEquals(submittingFormInfo.get("address"), currentAddress);
        Assert.assertEquals(submittingFormInfo.get("state and city"), "NCR Delhi");
    }
}
