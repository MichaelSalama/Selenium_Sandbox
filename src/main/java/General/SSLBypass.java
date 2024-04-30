package General;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SSLBypass
{
    public static void main(String[] args)
    {
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        //options.addExtensions(); -> to add extensions in runtime

        //set a proxy from network security team
        /*{
            Proxy proxy = new Proxy();
            proxy.setHttpProxy("ipaddess : portnum.") ->
            options.setCapability("proxy", proxy);

        }
        */

        //Set a preferred download folder
        /*
        {
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", "/directory/path");
        options.setExperimentalOption("prefs", prefs);
        }
        */

        String path = "C:/Users/Lenovo/Downloads/chromedriver-win64/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://expired.badssl.com");

        System.out.println(driver.getTitle());
    }
}
