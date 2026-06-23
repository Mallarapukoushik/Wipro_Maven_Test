package Selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import util.Baseclass;
 
public class PopupDemo extends Baseclass{
 
	public static void main(String[] args) throws InterruptedException {
		// invoke Browser
		invokeBrowser("edge");
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Click the btn to handle the alerts
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		//driver.switchTo().alert().accept();//switch to alert and click on ok btn
		alert.accept();
		//handle the select box
		WebElement select = driver.findElement(By.name("dropdown-class-example"));
		Select sel = new Select(select);
		Thread.sleep(1000);
		sel.selectByIndex(1);
		Thread.sleep(1000);
		sel.selectByValue("option2");
		Thread.sleep(1000);
		sel.selectByVisibleText("Option3");
		//auto suggestion handling
		WebElement autosuggest = driver.findElement(By.cssSelector("input[id='autocomplete']"));
		autosuggest.sendKeys("India");
		Thread.sleep(2000);//explicit wait->webdriverwait
		autosuggest.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER);
		 Thread.sleep(2000);
	     //driver.quit();
	}
 
}

