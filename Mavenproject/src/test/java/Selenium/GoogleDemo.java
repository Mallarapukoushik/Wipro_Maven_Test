package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
 
public class GoogleDemo {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// Google Demo	ctr+shift+o-> keyboard command to import
		//invoke browser
		driver = new EdgeDriver();
		//enter the url
		//driver.get("https://www.google.com/");
		//to maximize the window
		driver.manage().window().maximize();
		driver.navigate().to("https://www.google.com/");
 
		//identify the web-element
		//WebElement search = driver.findElement(By.name("q"));
		WebElement search = driver.findElement(By.id("APjFqb"));
		//Action-> write the value into the search box
		search.sendKeys("Selenium");
		
		closeBroswer();
	}
 
	//Method to close the browser
	public static void closeBroswer() throws InterruptedException
	{
		//Sleep
		Thread.sleep(2000);
		driver.quit();
	}
 
}