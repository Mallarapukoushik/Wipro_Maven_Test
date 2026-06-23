package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import util.Baseclass;
 
public class ScrollDownDemo extends Baseclass{
 
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		invokeBrowser("edge");
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//scroll down by pixels - 2000
		js.executeScript("window.scrollBy(0,200)");
		System.out.println("Scrolled down");
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("REST ")).click();
		closeBrowser();
	}
 
}
 
