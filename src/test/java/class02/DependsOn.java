package class02;

import org.testng.annotations.Test;

public class DependsOn {
    @Test
    public void login(){
        System.out.println("I have logged in successfully");
    }

    // sometimes the following test cases depend on the previous ones
    // meaning if the first one fails, it makes no sense to run the following ones
    // e.g. first test is Login on website, second is the next page
    // so if we don't login successfully, we logically cannot execute the next tests
    // so we add depends on as parameter in the following ones
    // (dependsOnMethods = methodName)
    // so if the first one fails, the second one will be skipped

    @Test(dependsOnMethods = "login")
    public void verificationOfDashboardPage(){
        System.out.println("I am on Dashboard page");
    }
}
