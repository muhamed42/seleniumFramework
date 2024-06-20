package TestNGTopics;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestNGDemoBase {
        @BeforeClass
        public void beforeClass(){
            System.out.println("beforeClass " +this.getClass().getName());
        }

        @AfterClass
        public void afterClass(){
            System.out.println("afterClass "+this.getClass().getName());
        }
    }
