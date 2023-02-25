package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    public WebDriver driver;

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void init() {
                /*
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", "/users/ilya/documents");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        */

        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");   //20.02.2023 10:20

        //driver = new ChromeDriver(options);


        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }



    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

//    Вот пример настройки папки для скачивания файлов по умолчанию /users/user/documents

//    @BeforeMethod
//    public void init() {
//        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
//        chromePrefs.put("download.default_directory", "/users/user/documents");
//        ChromeOptions options = new ChromeOptions();
//        options.setExperimentalOption("prefs", chromePrefs);
//
//        driver = new ChromeDriver(options);
//
//        driver.manage().window().maximize();
//        driver.get("https://demoqa.com/");
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//    }

}
