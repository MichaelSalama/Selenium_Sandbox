package General;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverInfo;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class WindowActivity
{
    public static void main(String[] args) throws IOException
    {
        String path = "C:/Users/Lenovo/Downloads/chromedriver-win64/chromedriver.exe";


        System.setProperty("webdriver.chrome.driver", path);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();

        driver.get("https://google.com");

        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("D://screenshot.png"));
    }

    public static void GetvsNavigateTo(WebDriver driver)
    {

        //waits until loaded and component to load
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        //Doesn't wait until page is loaded only need to use wait manually
        driver.navigate().to("http://google.com");

    }

    public static void WindowsNavigation(WebDriver driver)
    {
        driver.navigate().back();
        driver.navigate().forward();
    }
}













