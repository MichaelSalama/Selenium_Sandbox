package PageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;
import java.util.List;

public class ProductCatalogue extends AbstractComponent
{
    WebDriver driver;

    public ProductCatalogue(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".mb-3")
    List<WebElement> products;

    @FindBy(css = ".ng-animating")
    WebElement spinner;

    By productBy = By.cssSelector(".mb-3");
    By addToCartBy = By.cssSelector(".card-body button:last-of-type");
    By toastMsgBy = By.cssSelector("#toast-container");

    public List<WebElement> getProductList()
    {
        waitForElementToAppear(productBy);
        return products;
    }

    public WebElement getProductByName(String productName)
    {
        return getProductList().stream().filter(p ->
                p.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);

    }

    public void addProductToCart(String productName)
    {
        WebElement product = getProductByName(productName);
        product.findElement(addToCartBy).click();
        waitForElementToAppear(toastMsgBy);
        waitForElementToDisappear(spinner);
    }
}
