package pages.Elements;

import pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.util.Collection;

public class UploadDownloadPage extends PageBase {
    public UploadDownloadPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "downloadButton")
    WebElement downloadButton;

    @FindBy(id = "uploadFile")
    WebElement uploadFileButton;

// мое   public String getClickOnDownloadButtonResult() {
//        click(downloadButton);
//        return driver.switchTo().alert().getText();
//    }

    public boolean verifyDownload() {
        //Clicked -> files is download -> check file exists

        String path = "/Users/olgaartemeva/Downloads/sampleFile.jpeg";
        File f = new File(path);

        if (f.exists()) {
            f.delete();
        }
        click(downloadButton);
        wait(4000);

        if (f.exists()) {
            f.delete();
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public UploadDownloadPage selectFile() {
        uploadFileButton.sendKeys("/Users/olgaartemeva/Downloads/sampleFile.jpeg");
        return this;
    }

    @FindBy(id = "uploadedFilePath")
    WebElement uploadedFilePath;

    public boolean checkFileIsSelected() {
        return uploadedFilePath.isDisplayed();
    }

}
