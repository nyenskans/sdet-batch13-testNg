package class02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

import static class01.testAnnotationDemo2.driver;

public class SoftAssertion {
    WebDriver driver;
    //    navigate to syntax HRMS website
    @BeforeMethod(alwaysRun = true)  // we set this argument because of xml file where we marked @Test as group "Regression
                                    // so that this method would be ran as well
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();;
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    }
    @Test(groups = "regression")
    public  void invalidCredentials(){
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

//        get the element message invalid credentials
        WebElement errorMsg = driver.findElement(By.xpath("//span[@id='spanMessage']"));
//        extract the error message
        System.out.println(errorMsg.getText());
        String errorText=errorMsg.getText();
        //        expected text
        String expectedText="Invalid credentials";
        SoftAssert soft =new SoftAssert();
//        make sure error text is equal to expected text
        soft.assertEquals(errorText,expectedText);

//        get he webelement username from the website
        username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
//        is it displayed?
        boolean displayed = username.isDisplayed();
//        make sure the text box is dislplayed
        soft.assertTrue(displayed);

        soft.assertAll();

    }

    @AfterMethod(groups = "regression")
    public  void closeBrowser(){
        driver.quit();
    }


}
