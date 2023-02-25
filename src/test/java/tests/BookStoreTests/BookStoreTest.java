package tests.BookStoreTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BookStore.BookStorePage;
import pages.HomePage;
import tests.TestBase;

public class BookStoreTest extends TestBase {

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).openBookStoreApp();
    }

    @Test
    public void searchForBookTest(){
        new BookStorePage(driver).searchBook("Web");
        sleep(500);
        Assert.assertTrue(new BookStorePage(driver).getFirstBookTitle().contains("Web"));
    }
}
