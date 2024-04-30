package PageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponent
{
    WebDriver driver;
    public LandingPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    //WebElement userEmail = driver.findElement(By.id("userEmail"));

    //page factory design patter
    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id =  "userPassword")
    WebElement passwordElement;

    @FindBy(id = "login")
    WebElement submit;

    @FindBy(css = "[class*='flyInOut']")
    WebElement errorMsg ;

    public ProductCatalogue loginApplication(String email, String password){
        userEmail.sendKeys(email);
        passwordElement.sendKeys(password);
        submit.click();
        return new ProductCatalogue(driver);

    }

    public  void goTo(){
        driver.get("https://www.rahulshettyacademy.com/client");
    }

    public String getErrorMessage(){
        return errorMsg.getText();
    }
}












