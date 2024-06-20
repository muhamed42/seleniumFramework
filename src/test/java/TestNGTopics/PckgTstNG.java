package TestNGTopics;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class PckgTstNG {
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(){
        System.out.println("beforeSuite ..");
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite(){
        System.out.println("afterSuite ..");
    }
}
