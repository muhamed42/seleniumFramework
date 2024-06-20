package LastDemo;

import com.codoid.products.exception.FilloException;
import myDataProviders.ReadExcel;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class CalculatorTestDD {

    WebDriver driver=null;

    //	public void setup(@Optional("https://juliemr.github.io/protractor-demo/") String url){
    @BeforeMethod(alwaysRun = true)
    @Parameters("URL")
    //public void setup(String url) throws IOException{
    public void setup(@Optional("https://juliemr.github.io/protractor-demo/") String url){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        System.out.println("URL:"+url);
    }




    @AfterMethod(alwaysRun = true)
    public void teardown(ITestResult result) throws IOException {
        //
        // To do:
        //Take screenshot
        //

        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile,new File("./screenshots/test_"+System.currentTimeMillis()+result.getName()+".jpg"));

        if(result.getStatus()== ITestResult.FAILURE){
            File failedSrcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(failedSrcFile,new File("./screenshots_failed/test_"+System.currentTimeMillis()+result.getName()+".jpg"));
        }
        driver.quit();
        System.out.println("Result:"+result.getName());
    }

    @Test(groups = {"smoke","positive","data-driven"},dataProvider = "CalcDataProvider")
    public void calculate(String op1,String op,String op2,String expected) throws InterruptedException, IOException{
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5), Duration.ofMillis(250));
        driver.findElement(By.cssSelector("[ng-model=first]")).sendKeys(op1);
        driver.findElement(By.cssSelector("[ng-model=second]")).sendKeys(op2);

        Select operation =new Select( driver.findElement(By.cssSelector("select")));
        operation.selectByVisibleText(op);

        driver.findElement(By.cssSelector("#gobutton")).click();

        wait.until(ExpectedConditions.attributeToBe(By.cssSelector("h2.ng-binding"),"innerText" , expected));
        String actual=driver.findElement(By.cssSelector("h2.ng-binding")).getText();
        Assert.assertEquals(actual, expected,"It is wrong");
        Thread.sleep(1000);
    }


    @DataProvider (name = "CalcDataProviderOld")
    public Object[][] provideTestDataOld() {
        return new Object[][] {
                {"1","1","+", "2"},
                {"1","1","-", "0"},
                {"2","3","*", "6"}
        };
    }

    @DataProvider (name = "CalcDataProvider")
    public Object[][] provideTestData() throws FilloException, IOException {
        return  ReadExcel.getDataFromExcel("data/DataSample.xlsx","Select * from Sheet1");
    }


}

