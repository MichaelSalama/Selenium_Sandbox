package General;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class BrokenLinks
{
    public static void main(String[] args) throws IOException
    {
        String path = "C:/Users/Lenovo/Downloads/chromedriver-win64/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        SoftAssert a = new SoftAssert();

        for (WebElement link : links) {
            String url = link.getAttribute("href");

            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.connect();
            int respCode = connection.getResponseCode();
            System.out.println(respCode);
            //hard assertion
            //Assert.assertTrue(respCode < 400, "The link with text " + link.getText() + " is broken with code " + respCode);
            //soft assertion

            a.assertTrue(respCode < 400, "The link with text " + link.getText() + " is broken with code " + respCode);
        }
        a.assertAll();
    }

    public static void TestwithOneLink(WebDriver driver) throws IOException
    {
        String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("HEAD");
        connection.connect();
        System.out.println(connection.getResponseCode());
    }
}
