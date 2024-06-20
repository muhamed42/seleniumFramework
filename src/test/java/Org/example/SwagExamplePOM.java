package Org.example;

import baseUtils.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.GoodsPage;
import pages.LoginPage;

public class SwagExamplePOM extends TestBase {


    LoginPage login;
    GoodsPage goods;



    @Test
    public void test01() throws InterruptedException {
        login = new LoginPage(driver);
        goods = new GoodsPage(driver);

        login.doLogin("standard_user", "secret_sauce");
        goods.selectElements(new int[]{0});
        goods.gotoCart();
    }

    @Test
    public void test02() throws InterruptedException {
//        doLogin();
//        doLogin("standard_user", "secret_sauce");
        LoginPage login = new LoginPage(driver);
        login.doLogin("standard_user", "secret_sauce");
        Thread.sleep(1000);
        //Do something
        //Select 1 element in the goods' list
        driver.findElement(By.xpath("(//button[text()='Add to cart'])[3]")).click();
        Thread.sleep(1000);
        //Go to cart
        driver.findElement(By.cssSelector("span.shopping_cart_badge")).click();
        Thread.sleep(1000);
        //Remove from cart
        driver.findElement(By.xpath("(//button[text()='Remove'])")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("div.removed_cart_item"));

    }



    @Test
    public void test03() throws InterruptedException {
        login = new LoginPage(driver);
        goods = new GoodsPage(driver);

        login.doLogin("standard_user", "secret_sauce");
        goods.selectElements(new int[]{0,2,4});
        goods.gotoCart();
        Thread.sleep(3000);
    }


}
