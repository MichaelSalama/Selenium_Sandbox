package General;//import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
//import org.openqa.selenium.manager.SeleniumManager;
//import org.testng.annotations.BeforeSuite;


public class Introduction
{
    //Using manager to setup driver
    //WebDriver driver;

    //@BeforeSuite
    //public void setup(){
    //    WebDriverManager.chromedriver().setup();
    //    driver = new ChromeDriver();
    //}

    public static void main(String[] args) throws InterruptedException
    {
        //Invoking  Browser by using driver
        //Webdriver is an interface that will be implemented by chromedriver class
        //selenium manager or manually giving the path

        // Manually setup driver
        //need to be compatible with installed browser

        String path = "C:/Users/Lenovo/Downloads/chromedriver-win64/chromedriver.exe";
        String url = "https://rahulshettyacademy.com/locatorspractice/";

        System.setProperty("webdriver.chrome.driver", path);
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        //implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        String name = "Rahul";


        //selectors

        //driver.findElement(By.id("inputUsername")).sendKeys(name);
        //driver.findElement(By.name("inputPassword")).sendKeys("hello123");
        //driver.findElement(By.className("signInBtn")).click();
        //System.out.println(driver.findElement(By.cssSelector("p.error")).getText());


        String pwd = getPassword(driver, url);

        driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys(name);
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(pwd);
        Thread.sleep(1000);
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+name+",");

        driver.findElement(By.xpath("//*[text()='Log Out']")).click(); //* means anything in html



        //difference between close & quit
        //close will close the url it is focused on but the quit will close all related windows opened by selenium
        //driver.close();
        //driver.quit();

    }

    public  static String getPassword(WebDriver driver, String url) throws InterruptedException
    {
        driver.get(url);
        driver.findElement(By.linkText("Forgot your password?")).click();
        //Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John Doe");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("John@rsa.com");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
        driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("johm@gmail.com");
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("0123");
        //Thread.sleep(1000);
        driver.findElement(By.cssSelector("Button.reset-pwd-btn")).click();
        String pwdText = driver.findElement(By.cssSelector("form p")).getText();
        String[] pwdArray = pwdText.split("'");
        return pwdArray[1].split("'")[0];
    }
}













