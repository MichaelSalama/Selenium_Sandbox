import PageObjects.ProductCatalogue;
import TestComponents.BaseTest;
import TestComponents.Retry;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ErrorValidationsTest extends BaseTest
{
    @Test (groups = {"ErrorHandling"}, retryAnalyzer = Retry.class )
    public void submitOrder() throws IOException
    {
        String productName = "ZARA COAT 3";
        ProductCatalogue productCatalogue = landingPage.loginApplication("anshika@gmail.com", "Iamki@000");
        Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
    }
}




















