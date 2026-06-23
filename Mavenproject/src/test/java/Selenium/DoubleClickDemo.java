package Selenium;

import org.openqa.selenium.By;
import util.Baseclass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

public class DoubleClickDemo extends Baseclass {
	public static void main(String[] args) throws InterruptedException,IOException {
		invokeBrowser("edge");
		driver.get("https://demoqa.com/buttons");
		Actions act = new Actions(driver);
		Thread.sleep(2000);	
		WebElement btnElmt =  driver.findElement(By.id("doubleClickBtn"));
		WebElement rightElmt =  driver.findElement(By.id("rightClickBtn"));

		
		act.doubleClick(btnElmt).perform();
		act.contextClick(rightElmt).perform();
	
		Thread.sleep(2000);
		//driver.quit();
	}

}
