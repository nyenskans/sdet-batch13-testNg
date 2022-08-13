package class03;

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

public class ParallelTesting {
    WebDriver driver;
    //    navigate to syntax HRMS website
    @BeforeMethod(alwaysRun = true)  // we set this argument because of xml file where we marked @Test as group "Regression
    // so that this method would be ran as well
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();;
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @Test(groups = "regression")
    public  void invalidCredentials() throws InterruptedException {
        WebElement username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        username.sendKeys("WeatherMay");
        WebElement pswrd = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        pswrd.sendKeys("abcdefgh");
        WebElement loginBtn = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        loginBtn.click();
//        get the element message invalid credentials
        WebElement errorMsg = driver.findElement(By.xpath("//span[@id='spanMessage']"));
//        extract the error message
        System.out.println(errorMsg.getText());
        String errorText=errorMsg.getText();
        //        expected text
        String expectedText="Invalid credentials";
        SoftAssert soft =new SoftAssert();
        soft.assertEquals(errorText,expectedText);
// we have to reassingn username webElement because the page got refreshed
        username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        boolean displayed = username.isDisplayed();
        soft.assertTrue(displayed);
        Thread.sleep(5000 );
        soft.assertAll();

    }

    @AfterMethod(groups = "regression")
    public  void closeBrowser(){
        driver.quit();
    }

}
