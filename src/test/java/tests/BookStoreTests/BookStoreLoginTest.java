package tests.BookStoreTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BookStore.BookStorePage;
import pages.BookStore.LoginPage;
import pages.BookStore.ProfilePage;
import pages.HomePage;
import pages.SideMenu;
import pages.data.LoginData;
import tests.TestBase;

public class BookStoreLoginTest extends TestBase {

    //OlgaSArte
    //Aos-123456!
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).openBookStoreApp();
        new BookStorePage(driver).openLoginPage();
    }

    @Test
    public void positiveAuthTest() {
        new LoginPage(driver).login(LoginData.USERNAME, LoginData.PASSWORD);
        Assert.assertEquals(new ProfilePage(driver).getUserNameValue(), "OlgaSArte");
    }

    @Test
    public void negativeAuthTest() {
        new LoginPage(driver).login("qwmklad", "mkalsd");
        String error = "Invalid username or password";
        Assert.assertTrue(new LoginPage(driver).getErrorMessage().contains(error));
    }

    @Test
    public void logOutTest() {
        new LoginPage(driver).login("OlgaSArte", "Aos-123456!");
        sleep(1000);
        new SideMenu(driver).openLoginPage();
        sleep(1000);
        new LoginPage(driver).logOut();
        Assert.assertTrue(new LoginPage(driver).getWelcomeMessage().contains("Login in Book Store"));
    }

}
