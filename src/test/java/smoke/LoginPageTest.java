package smoke;

import base.TestBase;
import org.example.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test(groups = "smoke")
public class LoginPageTest extends TestBase {

    @Test
    public void verifyLogin() {
        String title = new HomePage().getTitle();
        System.out.println("the test is executed........");
        Assert.assertEquals(title, "Products");
    }
}
