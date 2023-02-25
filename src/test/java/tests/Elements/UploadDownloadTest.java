package tests.Elements;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Elements.UploadDownloadPage;
import pages.HomePage;
import pages.SideMenu;
import tests.TestBase;

public class UploadDownloadTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).openElements();
        new SideMenu(driver).openUploadDownloadPage();
    }

    // Title: File is downloaded after Download button is clicked
    @Test
    public void clickOnDownloadButton() {
        //Step1: double click on Download button
        //Expected result: File is downloaded locally
//   мое     String name = "sampleFile";
//   мое     Assert.assertTrue(new UploadDownloadPage(driver).getClickOnDownloadButtonResult().contains(name));
        Assert.assertTrue(new UploadDownloadPage(driver).verifyDownload());
    }

    @Test
    public void selectFileToUpload() {
        //Step1: double click on Download button
        //Expected result: File is downloaded locally
        Assert.assertTrue(new UploadDownloadPage(driver).selectFile().checkFileIsSelected());
    }

}

