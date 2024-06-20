package TestNGTopics;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGDemoOther  extends TestNGDemoBase{


    @BeforeMethod
    public void setUp(){
        System.out.println("BeforeMethod");
    }

    @Test
    public void test01(){
        System.out.println("Test01");
    }

    @Test
    public void test02(){
        System.out.println("Test02");
    }


    @AfterMethod
    public void tearDown(){System.out.println("AfterMethod");
    }
}

