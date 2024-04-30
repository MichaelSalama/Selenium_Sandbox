package General;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.List;

public class SepcialElements
{
    public static void main(String[] args) throws InterruptedException
    {
        String path = "C:/Users/Lenovo/Downloads/chromedriver-win64/chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", path);
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");


/*
        {
            //static dropdown -> tag name select
            Select dropdown = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
            dropdown.selectByIndex(0);
            dropdown.selectByVisibleText("USD");
             Assert.assertEquals("USD", dropdown.getFirstSelectedOption().getText());
        }


        {
        //suggestion list
            driver.findElement(By.id("autosuggest")).sendKeys("ind");
            Thread.sleep(3000);
            List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
            for (WebElement option : options) {
                if (option.getText().equalsIgnoreCase("India")) {
                    option.click();
                    break;
                }
            }
        }


 */
        {
            //checkboxes
            Assert.assertEquals(driver.findElements(By.cssSelector("input[type='checkbox'")).size(),6);
            driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
            Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        }
        {
            //Dynamic dropdowns -> using normal tags
            driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
            driver.findElement(By.xpath("//a[@value='AMD']")).click();
            Thread.sleep(2000);
            //driver.findElement(By.xpath("(a[@value='MAA'])[2]")).click();
            driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']")).click();
        }
        {
            // calendar , select highlighted date
            driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
        }
        {
            driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
            if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
                Assert.fail();

            } else {
                Assert.assertTrue(true);
            }

        }
        {
            driver.findElement(By.id("divpaxinfo")).click();
            Thread.sleep(2000L);
            for (int i = 1; i < 3; i++) {
                driver.findElement(By.id("hrefIncAdt")).click();
            }
            driver.findElement(By.id("btnclosepaxoption")).click();

            Assert.assertEquals("3 Adult", driver.findElement(By.id("divpaxinfo")).getText());

        }
        {
            //static dropdown -> tag name select
            Select dropdown = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
            dropdown.selectByIndex(0);
            dropdown.selectByVisibleText("USD");
            Assert.assertEquals("USD", dropdown.getFirstSelectedOption().getText());
        }
        {
            driver.findElement(By.cssSelector("input[type='submit'")).click();
        }

    }
}
