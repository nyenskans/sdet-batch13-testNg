package class01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testAnnotationDemo2 {
// go to fb.com
// enter invalid password and username
// click login
// make sure the error displays
    // we have to declare driver as a static variable so it can be accessed in each @Test
    public static WebDriver driver=null;

    // we can define this part of code in @BeforeMethod to be executed before each test without typing it multiple times
    @BeforeMethod
    public void settingUpBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://fb.com");
    }

    @Test
    public void BtestingInvalidCredentials(){

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Loki@gmail.com");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Lokikoki");

        String text=driver.findElement(By.xpath("//h2[text()='Connect with friends and the world around you on Facebook.']")).getText();
        if(text.equals("Connect with friends and the world around you on Facebook.")){
            System.out.println("Test successful");
        }else{
            System.out.println("failed");
        }
    }

    // Task: go to fb.com,
    // make sure 'create account' text is there

    @Test
    public void AcreateAccountText(){

        String text = driver.findElement(By.xpath("//a[text()='Create new account']")).getText();
        if(text.equals("Create new account")){
            System.out.println("Text matches");
        }else{
            System.out.println("Text doesn't match");
        }
    }
    // we can run each test separately by clicking on  it and running it
    // or, we can run all tests together by clicking on the class and running it

@AfterMethod
    public void quittingTheBrowser(){
        driver.quit();
    }





}


