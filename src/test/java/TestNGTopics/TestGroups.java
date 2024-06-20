package TestNGTopics;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class TestGroups {

    @BeforeMethod(alwaysRun=true)
    public void setup(Method m){
        System.err.println("TestNGIntro===@BeforeMethod : "+m.getName() );
    }

    @AfterMethod(alwaysRun=true)
    public void tearDown(ITestResult result) //, ITestNGMethod testMethod){
    {
        System.err.println("TestNGIntro==@AfterMethod : "+ result.getName()+" "+ ( result.getStatus()==1 ? "Passed" :"Failed"));

        // cond ? onTrue : onFalse;
        if(result.getStatus()!=1){
            // Take a screenshot of the system.
        }
    }


    @Test(groups ={"test","smoke","basic"} )
    public void testcase1(){
        System.err.println("TestNGIntro==@Test  1");
    }

    @Test(groups={"grp0"})
    public void testcase2(){
        System.err.println("TestNGIntro==@Test   2");
    }

    @Test(groups={"smoke","grp0"})
    public void testcase3(){
        System.err.println("TestNGIntro==@Test  3");
    }

    @Test(groups={"smoke","maintenance"})
    public void testcaseFailing(){
        System.err.println("TestNGIntro==@Test  3");
        Assert.assertEquals("actual", "expected", "It is designed to fail...");
    }

}

