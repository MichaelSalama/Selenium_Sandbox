package General;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CartApplication
{
    public static void main(String[] args)
    {
        String path = "C:/Users/Lenovo/Downloads/chromedriver-win64/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        WebDriver driver = new ChromeDriver();
        //implicit wait
        //driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        String[] expected = {"Cucumber", "Brocolli"};
        //explicit wait
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

        rahulCode(driver, expected);

        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
        //explicit wait
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));

       System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

    }

    public static void myCode(WebDriver driver, String[] expected ){
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));


        for (String name : expected){
            for (WebElement product: products) {
                if (product.getText().contains(name)) {
                    int index = products.indexOf(product);
                    //System.out.println(index);
                    driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(index).click();
                    break;
                };
            }
        }
    }

    public static void rahulCode(WebDriver driver, String[] expected ){
        int j = 0;
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        for (int i = 0; i < products.size(); i++) {
            String[] name = products.get(i).getText().split("-");
            String formattedName = name[0].trim();

            List expectedList = Arrays.asList(expected);

            if (expectedList.contains(formattedName)) {
                j++;
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                if (j==expected.length){
                    break;
                }
            }
        }
    }
}















