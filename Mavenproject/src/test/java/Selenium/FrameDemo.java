package Selenium;

import org.openqa.selenium.By;

import util.Baseclass;
 
public class FrameDemo extends Baseclass{
 
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		invokeBrowser("edge");
		driver.navigate().to("file:C:/Users/MA20696615/Downloads/html/page.html");
		//t1
		driver.findElement(By.id("t1")).sendKeys("testing");
		
		//switch to a frame
		driver.switchTo().frame(0);
		driver.findElement(By.id("t2")).sendKeys("automation");
		Thread.sleep(1000);
		driver.findElement(By.id("t3")).sendKeys("selenium");
		Thread.sleep(1000);
		
		driver.switchTo().defaultContent();//main window
		Thread.sleep(2000);
		driver.findElement(By.id("t1")).clear();
		driver.findElement(By.id("t1")).sendKeys("Frame demo");
		
		//close browser
		closeBrowser();
		
		
		
	}
 
}
