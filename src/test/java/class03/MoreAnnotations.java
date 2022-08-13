package class03;

import org.testng.annotations.*;

public class MoreAnnotations {

    @BeforeSuite
    public void beforeSuit(){
        System.out.println(" I am Before Suite");
    }
    @AfterSuite
    public void afterSuit(){
        System.out.println(" I am After Suite");
    }


    //    If 2 or more classes have the same pre/postcondition, we use @BeforeClass/@AfterClass
    @BeforeTest
    public void beforeTest(){
        System.out.println("I am before test");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("I am before class");
    }
    @Test
    public void aTest(){
        System.out.println("I am A test");
    }
    @Test
    public void bTest(){
        System.out.println("I am B test");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("I am after class");
    }
}
