package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private By userNameTxt = By.cssSelector("#user-name");
    private By userPasswordTxt = By.id("password");
    private By loginBtn = By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void doLogin(String userName, String userPassword) {
        driver.findElement(userNameTxt).sendKeys(userName);
        driver.findElement(userPasswordTxt).sendKeys(userPassword);
        driver.findElement(loginBtn).click();
    }
}
