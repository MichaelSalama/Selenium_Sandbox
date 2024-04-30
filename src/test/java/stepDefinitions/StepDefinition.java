package stepDefinitions;

import PageObjects.*;
import TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class StepDefinition extends BaseTest
{
    public LandingPage landingPage;
    public ProductCatalogue productCatalogue;
    public CheckoutPage checkoutPage;
    public ConfirmationPage confirmationPage;

    @Given("I landed on the Ecommerce Page")
    public void I_landed_on_the_Ecommerce_Page() throws IOException
    {
        landingPage = launchApplication();
    }

    @Given("^Logged in with username (.+) and password (.+)$")
    public void logged_in_username_and_password(String username, String password)
    {
        // ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
        productCatalogue = landingPage.loginApplication(username, password);
    }

    @When("^I add the product (.+) from Cart$")
    public void i_add_product_to_cart(String productName)
    {
        List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCart(productName);
    }

    @When("^Checkout (.+) and submit the order$")
    public void checkout_submit_order(String productName)
    {
        CartPage cartPage = productCatalogue.goToCartPage();

        Boolean match = cartPage.VerifyProductDisplay(productName);
        Assert.assertTrue(match);
        checkoutPage = cartPage.goToCheckout();
        checkoutPage.selectCountry("india");
        confirmationPage = checkoutPage.submitOrder();
    }

    @Then("{string} message is displayed on ConfirmationPage")
    public void message_displayed_confirmationPage(String string)
    {
        String confirmationMsg = confirmationPage.getConfirmationMsg();
        Assert.assertTrue(confirmationMsg.equalsIgnoreCase(string));
        driver.close();
    }

    //@Then("^\"([^\"]*)\" message is displayed$")
    @Then("{string} message is displayed")
    public void smtng_message_is_displayed(String stringarg){
        Assert.assertEquals(stringarg, landingPage.getErrorMessage());
        driver.close();
    }

}





















