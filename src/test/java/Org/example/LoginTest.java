package Org.example;

import org.openqa.selenium.By;
import baseUtils.TestBase;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    private void doLogin(String userName, String userPassword) {
        driver.findElement(By.cssSelector("#user-name")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(userPassword);
        driver.findElement(By.id("login-button")).click();
    }


    @Test
    public void test01(){
        doLogin("standard_user", "secret_sauce");
        //Assert something
    }


    @Test
    public void test02(){
        doLogin("locked_out_user", "secret_sauce");
        //Assert Error message.
        // Epic sadface: Sorry, this user has been locked out.
    }



}
