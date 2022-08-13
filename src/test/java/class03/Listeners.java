package class03;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

    // they listen to events (test passing/failure)
    // execute different code in the event of test fail/success
    // we must implement  interface ITestListeners


public void onTestSuccess(ITestResult result){
    System.out.println("This test case has passed successfully: "+result.getName());
}

public void onTestFailure(ITestResult result){
    System.out.println("The test case has failed successfully: "+result.getName());
}
}
