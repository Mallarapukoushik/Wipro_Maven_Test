package Jpet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Jpetcheckout {
	WebDriver driver;
	 
    public Jpetcheckout(WebDriver driver) {
        this.driver = driver;
    }
 
    By continueBtn = By.xpath("//button[text()='Continue']");
    By confirmBtn = By.xpath("//button[text()='Confirm']");
    By message = By.xpath("//div[@class='alert alert-info']//p");
 
    public void clickContinue() {
 
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(continueBtn)).perform();
        driver.findElement(continueBtn).click();
    }
 
    public void clickConfirm() {
 
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(confirmBtn)).perform();
        driver.findElement(confirmBtn).click();
    }

}
