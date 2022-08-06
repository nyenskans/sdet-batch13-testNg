package class02;

import org.testng.annotations.Test;

public class EnableDisable {

    // in case we know one test is failing, but we want to continue working in the same class, within the failed test,
    // we can disable it by passing enabled=false in the test annotation
    @Test(enabled=false)
public void firstTest(){
        System.out.println("I am test #1");
    }

    @Test
    public void secondTest(){
        System.out.println("I am test #2");

    }
    @Test
    public void thirdTest(){
        System.out.println("I am test #2");

    }
}
