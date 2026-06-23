package Jpet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Jpethome {
	WebDriver driver;
	 
    public Jpethome(WebDriver driver) {
        this.driver = driver;
    }
 
    By fish = By.linkText("Fish");
    By product = By.linkText("FI-SW-01");
    By addToCart = By.xpath("//a[contains(@href,'addItemToCart')]");
    By checkout = By.xpath("//a[@href='/order/newOrderForm']");
   
    public void clickFish() {
        driver.findElement(fish).click();
    }
    public void selectProduct() {
        driver.findElement(product).click();
    }
    public void clickAddToCart() {
        driver.findElement(addToCart).click();
    }
    public void clickCheckout() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(checkout)).perform();
        driver.findElement(checkout).click();
    }

}


