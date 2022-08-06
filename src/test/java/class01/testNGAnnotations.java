package class01;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testNGAnnotations {
    // Writing the first test case:

    @Test // test annotation used to indicate that this is a test case
    public void firstTestCase(){
        System.out.println("I am the first test case!");
    }
    @Test
    public void secondTestCase(){
        System.out.println("I am the second test case!");
    }
    @Test
    public void thirdTestCase(){
        System.out.println("I am the third test case!");
    }

    @BeforeMethod
    public void beforeMethod(){
        // NOT A TEST CASE
        // we cannot run it individually
        // will be ran before each @Test
        System.out.println("I AM A BEFORE METHOD");
    }

    @AfterMethod
    // NOT A TEST CASE
    // we cannot run it individually
    // will be ran after each @Test
    public void afterMethod(){
        System.out.println("I AM AFTER METHOD");
    }
}
