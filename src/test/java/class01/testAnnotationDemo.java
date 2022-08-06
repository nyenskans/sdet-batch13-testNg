package class01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class testAnnotationDemo {
// go to fb.com
// enter invalid password and username
// click login
// make sure the error displays

    @Test
    public void BtestingInvalidCredentials(){
        // This is what we write in Maven project instead of setting property
        // We use a WebDriverManager dependency instead of driver.exe file
        WebDriverManager.chromedriver().setup();
        // The rest is the same
        WebDriver driver = new ChromeDriver();
        driver.get("https://fb.com");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Loki@gmail.com");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Lokikoki");

        String text=driver.findElement(By.xpath("//h2[text()='Connect with friends and the world around you on Facebook.']")).getText();
        if(text.equals("Connect with friends and the world around you on Facebook.")){
            System.out.println("Test successful");
        }else{
            System.out.println("failed");
        }
        driver.quit();
    }



    // go to fb.com
    // make sure create account  text is there

    @Test
    public void AcreateAccountText(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://fb.com");
        String text = driver.findElement(By.xpath("//a[text()='Create new account']")).getText();
        if(text.equals("Create new account")){
            System.out.println("Text matches");
        }else{
            System.out.println("Text doesn't match");
        }
        driver.quit();
    }
    // we can run each test separately by clicking on  it and running it
    // or, we can run all tests together by clicking on the class and running it
}


