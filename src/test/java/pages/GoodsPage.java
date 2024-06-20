package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoodsPage {
    private By goodsListAddToCart = By.xpath("//button[text()='Add to cart']");
    private WebDriver driver;
    private By inventory_items = By.cssSelector("div.inventory_item");

    private By cart = By.cssSelector("a.shopping_cart_link");
    public GoodsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectElements(int[] indexs){
        List<WebElement> add_item_buttons = driver.findElements(goodsListAddToCart);
        for(int i:indexs){
            add_item_buttons.get(i).click();
        }
    }

    public WebElement getItemByName(String name){
        List<WebElement> items = driver.findElements(inventory_items);
        for(WebElement item :items){
            if (item.getText().toLowerCase().startsWith(name.toLowerCase())){
                return item;
            }
        }
        return null;
    }

    public void gotoCart(){
        driver.findElement(cart).click();
    }

}
