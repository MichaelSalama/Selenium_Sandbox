package General;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentReportDemo
{
    ExtentReports extent = new ExtentReports();

    @BeforeTest
    public void config()
    {
        //extentSparkReporter & ExtentReports
        String path = System.getProperty("user.dir")+"\\reports\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Rahul Shetty");
    }

    @Test
    public void initialDemo()
    {
        ExtentTest test = extent.createTest("initialDemo");
        String path = "C:/Users/Lenovo/Downloads/chromedriver-win64/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/");
        System.out.println(driver.getTitle());
        driver.close();
        //test.fail("Result doesn't match");
        extent.flush();
    }
}













