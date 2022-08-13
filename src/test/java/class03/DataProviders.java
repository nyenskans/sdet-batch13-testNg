package class03;

import class02.SoftAssertion;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DataProviders {
    // navigate to syntax hrm
    // 1. username: Admin password:"12345", verify the error message: "Invalid credentials"
    // 2. username: "ABCD", password:"Hum@nhrm123", verify the error message: "Invalid credentials"
    // 3. username: "", password:"Hum@nhrm123", verify the error message: "Username cannot be empty"
    // 4. username: "Admin", password:"", verify the error message: "Password cannot be empty"
    WebDriver driver;
    @BeforeMethod
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
    }

    @DataProvider(name = "Credentials")
    public Object [][] data() {
        Object[][] login = {
                {"Admin", "abc", "Invalid credentials" },
                {"ABCD", "Hum@nhrm123", "Invalid credentials" },
                {"Admin", "", "Password cannot be empty" },
                {"", "Hum@nhrm123", "Username cannot be empty" }};
        return login;
    }

    @Test(dataProvider = "Credentials")
    public void loginWithVariousCredentials(String username, String password, String expectedError){
        WebElement usrname = driver.findElement(By.id("txtUsername"));
        usrname.sendKeys(username);
        WebElement psswrd = driver.findElement(By.id("txtPassword"));
        psswrd.sendKeys(expectedError);
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        loginButton.click();

        // get the error text:
        WebElement errorMsg = driver.findElement(By.xpath("//span[@id='spanMessage']"));
        // extract the text
        String actualError = errorMsg.getText();
        // declare soft Assertion:
        SoftAssert soft = new SoftAssert();
        // assert that the error message is correct:
        soft.assertEquals(actualError,expectedError);
        // assert all:
        soft.assertAll();


    }



    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }
}
