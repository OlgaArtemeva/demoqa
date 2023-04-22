package tests.Elements;
// 29.03.2023
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Elements.WebTablesPage;
import pages.HomePage;
import pages.SideMenu;
import tests.TestBase;

import java.util.List;
import java.util.Map;

public class WebTablesTest extends TestBase {
    WebTablesPage webTablesPage;
    List<Map<String, String>> rows;

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).openElements();
        new SideMenu(driver).openWebTablesPage();
    }

    @Test
    public void tableTest() {
        webTablesPage = new WebTablesPage(driver);
        rows = webTablesPage.getTableData();
//        String email = rows.get(2).get("Email");
        String email = rows.get((rows.size()) - 2).get("Email");
        System.out.println(email + "123456");

    }
}
