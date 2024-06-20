package Org.example;

import baseUtils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.List;

public class SwagExample extends TestBase {


    @Test
    public void test01() throws InterruptedException {

//        doLogin("standard_user", "secret_sauce");
        LoginPage login = new LoginPage(driver);
        login.doLogin("standard_user", "secret_sauce");

        driver.findElement(By.xpath("(//button[text()='Add to cart'])[1]")).click();
        driver.findElement(By.cssSelector("span.shopping_cart_badge")).click();
        driver.findElement(By.xpath("(//button[text()='Remove'])")).click();
        driver.findElement(By.cssSelector("div.removed_cart_item"));
        Thread.sleep(3000);

    }


    @Test
    public void test02() throws InterruptedException {
//        doLogin("standard_user", "secret_sauce");

        LoginPage login = new LoginPage(driver);
        login.doLogin("standard_user", "secret_sauce");

        driver.findElement(By.xpath("(//button[text()='Add to cart'])[1]")).click();
        driver.findElement(By.xpath("(//button[text()='Add to cart'])[3]")).click();
        driver.findElement(By.cssSelector("span.shopping_cart_badge")).click();
        driver.findElement(By.xpath("(//button[text()='Remove'][1])")).click();
        driver.findElement(By.cssSelector("div.removed_cart_item"));
        Thread.sleep(3000);



    }


    @Test
    public void test03() throws InterruptedException {
//        doLogin("standard_user", "secret_sauce");
        LoginPage login = new LoginPage(driver);
        login.doLogin("standard_user", "secret_sauce");

//        driver.findElement(By.xpath("(//button[text()='Add to cart'])[1]")).click();
//        driver.findElement(By.xpath("(//button[text()='Add to cart'])[2]")).click();
//        driver.findElement(By.xpath("(//button[text()='Add to cart'])[3]")).click();
        List<WebElement> add_item_buttons = driver.findElements(By.xpath("//button[text()='Add to cart']"));
        add_item_buttons.get(0).click();
        add_item_buttons.get(2).click();
        add_item_buttons.get(4).click();

        driver.findElement(By.cssSelector("span.shopping_cart_badge")).click();
        List<WebElement> myElements = driver.findElements(By.cssSelector("div.cart_item_label"));
        Assert.assertEquals(myElements.size(),3);

//        driver.findElement(By.xpath("(//button[text()='Remove'])")).click();
        Thread.sleep(3000);

    }



}
