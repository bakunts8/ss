package smoke;

import base.TestBase;
import org.example.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    @Test
    public void verifyProducts() {
        int productsSize = new HomePage().getProducts().size();

        Assert.assertEquals(HomePage.PRODUCTS_SIZE, productsSize);
    }
}
