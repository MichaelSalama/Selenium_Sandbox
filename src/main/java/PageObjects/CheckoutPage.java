package PageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;

public class CheckoutPage extends AbstractComponent
{
    WebDriver driver;

    @FindBy(css = "[placeholder='Select Country']")
    private WebElement country;

    @FindBy(css = ".action__submit")
    private WebElement submit;

    @FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
    private WebElement selectCountry;

    By results = By.cssSelector(".ta-results");
    public CheckoutPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectCountry(String countryName){
        Actions a = new Actions(driver);
        a.sendKeys(country,countryName).build().perform();
        waitForElementToAppear(results);
        selectCountry.click();

    }
public ConfirmationPage submitOrder (){
        submit.click();
        return new ConfirmationPage(driver);
}




}











