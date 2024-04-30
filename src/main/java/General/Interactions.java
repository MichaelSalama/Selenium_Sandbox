package General;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Interactions
{
    public static void main(String[] args)
    {


        String path = "C:/Users/Lenovo/Downloads/chromedriver-win64/chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", path);
        WebDriver driver = new ChromeDriver();

        driver.get("http://jqueryui.com/droppable/");

        WebElement frame = driver.findElement(By.cssSelector("iframe[class='demo-frame'"));
        driver.switchTo().frame(frame);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        Actions a = new Actions(driver);
        a.dragAndDrop(source, target).build().perform();
    }

    public static void someInteractions(WebDriver driver)
    {
        driver.get("https://www.amazon.com");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Actions a = new Actions(driver);

        WebElement hoverTo = driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));

        //Click and type in capitals
        a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT)
                .sendKeys("cheese").build().perform();

        a.contextClick(hoverTo).build().perform();

        driver.switchTo().defaultContent();

        //hover on an element
        // a.moveToElement(hoverTo).build().perform();
    }

    public static void switchWindows(WebDriver driver)
    {
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");

        driver.findElement(By.cssSelector(".blinkingText")).click();

        Set<String> windows = driver.getWindowHandles(); //parent id , child id
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);

        String email = driver.findElement(By.cssSelector(".im-para.red")).getText()
                .split("at")[1].trim().split("with")[0].trim();
        System.out.println(email);

        driver.switchTo().window(parentId);
        driver.findElement(By.id("username")).sendKeys(email);
    }
}






















