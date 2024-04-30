package General;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class Streams
{
    public static void main(String[] args)
    {
        String path = "C:/Users/Lenovo/Downloads/chromedriver-win64/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));
        List<WebElement> filteredList= veggies.stream().filter(v -> v.getText().contains("Rice")).collect(Collectors.toList());
       // Assert.assertEquals(veggies.size(), filteredList.size());

    }

    public static  void FindByStream(WebElement driver){


        List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));
        List<String> originalList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
        // Assert.assertTrue(originalList.equals(sortedList));
        List<String> price;
        do {
            List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));

            price = rows.stream().filter(s -> s.getText().contains("Almond")).map(s -> getPriceVeggie(s)
            ).collect(Collectors.toList());

            price.forEach(a -> System.out.println(a));

            if (price.size() < 1) {
                driver.findElement(By.cssSelector("[aria-label='Next']")).click();
            }
        } while (price.size() < 1);
    }

    private static String getPriceVeggie(WebElement s)
    {
        return s.findElement(By.xpath("following-sibling::td[1]")).getText();
    }
}














