package PageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage extends CartPage
{
    WebDriver driver;

    @FindBy(css ="tr td:nth-child(3)" )
   private List<WebElement> productNames;
    public OrderPage(WebDriver driver)
    {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public Boolean verifyOrdersToDisplay (String productName){
        return productNames.stream().anyMatch((p-> p.getText().equalsIgnoreCase(productName)));

    }
}
























