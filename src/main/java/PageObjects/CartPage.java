package PageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstractComponent
{
    WebDriver driver;

    @FindBy(css = ".totalRow button")
    WebElement checkOutElement;

    @FindBy(css = ".cartSection h3")
    private List<WebElement> productsTitles;

    public CartPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Boolean VerifyProductDisplay(String productName)
    {
        return productsTitles.stream().anyMatch(p -> p.getText().equalsIgnoreCase(productName));
    }

    public CheckoutPage goToCheckout()
    {
        checkOutElement.click();
        return new CheckoutPage(driver);
    }
}

















