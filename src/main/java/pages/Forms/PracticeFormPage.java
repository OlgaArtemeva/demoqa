package pages.Forms;

import pages.PageBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.SideMenu;

public class PracticeFormPage extends PageBase {
    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='firstName']")
    WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='lastName']")
    WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='userEmail']")
    WebElement EmailInput;

    @FindBy(xpath = "//label[.='Male']")
    WebElement labelMale;

    @FindBy(xpath = "//input[@id='userNumber']")
    WebElement mobileNumberInput;

//    @FindBy(xpath = "//input[@id='userNumber']")
//    WebElement dateOfBirth;

    @FindBy(xpath = "//div[@id='subjectsContainer']")
    WebElement subjectsContainerInput;

    @FindBy(xpath = "//label[.='Sports']")
    WebElement Sports;

    @FindBy(xpath = "//textarea[@id='currentAddress']")
    WebElement currentAddressInput;

    @FindBy(xpath = "//div[@id='Select State']")
    WebElement selectState;

    @FindBy(xpath = "//div[@id='state']")
    WebElement selectStateInput;
//    Select drpCountry = new Select(selectStateInput);



    @FindBy(xpath = "//div[@id='city']")
    WebElement selectCityInput;

    @FindBy(xpath = "//button[@id='submit']")
    WebElement submitButton;



    public void fillStudentRegistrationFormPositive(String firstName, String lastName, String Email, String mobileNumber
            ,/* String subjectsContainer,*/ String currentAddress) {
        hideAds();

        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
        EmailInput.clear();
        EmailInput.sendKeys(Email);
        labelMale.click();
        mobileNumberInput.clear();
        mobileNumberInput.sendKeys(mobileNumber);
//        Select Date of Birth
        Actions actions = new Actions(driver);
        clickWithJSExecutor(subjectsContainerInput, 0, 700);
        actions.sendKeys(subjectsContainerInput, "English" + Keys.ENTER).perform();
        wait(1000);
        clickWithJSExecutor(Sports, 0, 500);
//        Select picture
        currentAddressInput.clear();
        currentAddressInput.sendKeys(currentAddress);
        wait(500);
        clickWithJSExecutor(selectStateInput, 0, 900);
        wait(500);
        actions.sendKeys(selectStateInput, "NCR" + Keys.ENTER).perform();
        wait(500);
        clickWithJSExecutor(selectCityInput, 0, 900);
        wait(500);
        actions.sendKeys(selectCityInput, "Delhi" + Keys.ENTER).perform();
        wait(1000);
        removeFooter();
        // если выбран только State, в State and City он не попадает
        // бывает недоступна кнопка "Submit" (например, появляется только после позиционирования в поле 'Select State')

        SideMenu sideMenu = new SideMenu(driver); // отрабатывает в selectCityInput (Keys.ENTER)
        clickWithJSExecutor(sideMenu.bookStoreApplication, 0, 700);
        wait(1000);
        clickWithJSExecutor(submitButton, 0, 900);

    }

//    public SelectMenuPage choseFromSelectValue() {
//        Actions actions = new Actions(driver);
//        actions.sendKeys(selectStateInput, "NSR" + Keys.ENTER).perform();
//    }


}
