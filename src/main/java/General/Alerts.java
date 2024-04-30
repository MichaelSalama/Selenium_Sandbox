package General;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class Alerts
{
    public static void main(String[] args) throws InterruptedException
    {
        String text = "Rahul";
        String path = "C:/Users/Lenovo/Downloads/chromedriver-win64/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");




    }

    public static void alerts(WebDriver driver, String text){
        driver.findElement(By.id("name")).sendKeys(text);
        driver.findElement(By.cssSelector("[id='alertbtn']")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        driver.findElement(By.id("confirmbtn")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
    }

    public static void JSExecutor (WebDriver driver) throws InterruptedException
    {
        //to execute JS script
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,500)");

        Thread.sleep(3000);
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

        List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));

        int sum = 0;
        for (int i = 0; i<values.size(); i++){
            sum += Integer.parseInt(values.get(i).getText());

        }
        System.out.println(sum);
        Assert.assertEquals(sum, Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount"))
                .getText().split(":")[1].trim()));
    }
}


















