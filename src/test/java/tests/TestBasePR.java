package tests;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.awt.*;

public class TestBasePR {
    public static Playwright playwright;
    public static Browser browser;

    public BrowserContext context;
    public Page page;

    @BeforeAll
    static void launchBrowser() {
        var launchOpts = new BrowserType.LaunchOptions()
                .setHeadless(false) // делаем графический интерфейс видимым
                .setSlowMo(100); // задержка
        playwright = Playwright.create();
        browser = playwright.chromium().launch(launchOpts);
    }

    @AfterAll
    static void closeBrowser() {
        playwright.close();
    }

    @BeforeEach
    void createContextAndPage() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int heigth = (int) screenSize.getHeight();
        var connectOpts = new Browser.NewContextOptions().setViewportSize(width, heigth);


        context = browser.newContext();
        page = context.newPage();
    }

    @AfterEach
    void closeContext() {
        context.close();
    }
}
