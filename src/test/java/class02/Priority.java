package class02;

import org.testng.annotations.Test;

public class Priority {

    // The test are always executed in sequence top to bottom, but
    // if we want the Test executed in a specific order, we can pass priority as an argument in @Test
    // the Tests without priority execute first in order, and then the ones with priority in order

    @Test(groups = "smoke") // if we pass groups as argument, we can use that group in xml file
    public void firstTest(){
        System.out.println("I am test #1");
    }

    @Test(priority=2)
    public void secondTest(){
        System.out.println("I am test #2");
    }
    @Test(priority=1)
    public void thirdTest(){
        System.out.println("I am test #3");
    }
    @Test
    public void fourthTest(){ // this one will be executed first because 0 is default
        System.out.println("I am test #4");
    }
}
