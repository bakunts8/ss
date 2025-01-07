package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestBase {

    @BeforeSuite
    public void setup() {
        Selenide.open(Configuration.baseUrl);
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @BeforeTest
    public HomePage login() {
        LoginPage loginPage = new LoginPage().open();
        return loginPage.login();
    }

    protected HomePage toHomePage() {
        HomePage page = new HomePage();
        Selenide.open(page.getEndpoint());
        return page;
    }
}
