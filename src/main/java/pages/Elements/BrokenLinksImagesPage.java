package pages.Elements;

import pages.PageBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.List;

public class BrokenLinksImagesPage extends PageBase {
    public BrokenLinksImagesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "img")
    List<WebElement> images;

    public int checkNumberBrokenImages() {
        int numberOfBrokeLImages = 0;
        for (int i = 0; i < images.size(); i++) {
            WebElement image = images.get(i);
            String imageURL = image.getAttribute("src");
            try {
                boolean isImageDisplayed = (Boolean) ((JavascriptExecutor) driver).executeScript("return (typeof arguments[0].naturalWidth != undefined && arguments[0].naturalWidth>0);", image);

                if (isImageDisplayed) {
                    System.out.println("Image displayed: " + imageURL);
                } else {
                    System.out.println("Image not displayed: " + imageURL);
                    numberOfBrokeLImages = numberOfBrokeLImages + 1;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.toString());
            }
        }
        return numberOfBrokeLImages;

    }

    @FindBy(tagName = "a")
    List<WebElement> links;

    public int checkNumberBrokenLinks() {
        hideAds();  // 2:29 скрыть лишние ненужные ссылки (Скрыть рекламу -см. PageBase)
        int numberOfBrokenLinks = 0;
        for (int i = 0; i < links.size(); i++) {
            WebElement link = links.get(i);
            String href = link.getAttribute("href");

            // 2:29 ссылка на рекламе
            if ((href == null) && (link.getAttribute("id").equals("close-fixedban"))){
                System.out.println("Link is strange, skipped by id: " + link.getAttribute("id"));
                continue; // ?! пропускаем код ниже, возвращаемся в цикл (стр. for)
            }
            int broken = 0;
            try {
                broken = checkLink(href);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            numberOfBrokenLinks = numberOfBrokenLinks + broken;
            System.out.println("Link is broken: " + broken + ". URL: "+ href + ". Link element: " + link.getText());
        }
        return numberOfBrokenLinks;
    }
}
