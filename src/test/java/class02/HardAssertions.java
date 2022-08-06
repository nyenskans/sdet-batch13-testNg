package class02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static class01.testAnnotationDemo2.driver;

public class HardAssertions {


    //    navigate to syntaxhrms
    //    we need to write to case to verify the wrong credentials give error message
    //    quit the browser
    //    navigate to syntax HRMS website
    @BeforeMethod
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();;
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @Test
    public  void verifyInvalidCredentialsError(){
//finding the username text box
        WebElement username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
//send username
        username.sendKeys("WeatherMay");
//        finding the password field
        WebElement pswrd = driver.findElement(By.xpath("//input[@id='txtPassword']"));
//        send password
        pswrd.sendKeys("abcdefgh");
//        finding the element login btn
        WebElement loginBtn = driver.findElement(By.xpath("//input[@id='btnLogin']"));
//        click the login
        loginBtn.click();

//        get the element message invalid crdentials
        WebElement errorMsg = driver.findElement(By.xpath("//span[@id='spanMessage']"));
//        extract the error message
        String errorText = errorMsg.getText();
//
        System.out.println(errorText);
//        /declaring the message that we are expecting
        String expectedMsg="Invalid credentials";

//        making assertion to make sure that message is correct
        Assert.assertEquals(errorText,expectedMsg);


        // now we want to make sure the textbox username is displayed:
        // boolean displayed = username.isDisplayed();
        // we get an error: element is not attached to the page document  -  because once we hit the login button,
        // the dom gets refreshed so we have to reinitialize the WebElement username (find it again)
        username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        boolean displayed = username.isDisplayed();
        // the test will pass if argument passed is true

        Assert.assertTrue(displayed);
    }

    @AfterMethod
    public  void closeBrowser(){
        driver.quit();
    }
        // even though the test case should fail- it passed and just gave a message of failing.
        // which is why we shouldn't use if conditions in testng but Assertions:
     /*
        if(errorText.equals("Invalid credential")){
            System.out.println("Test case has passed");
        }else {
            System.out.println("Test case has failed");
        }
        */

}
