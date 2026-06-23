package Selenium;

import java.time.Duration;
import java.util.List;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class Suggestions {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// Suggestions ctr+shift+o-> keyboard command to import
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
		//Wait for the suggestions
		//Thread.sleep(2000);
		//Explicit wait for the specific object - wait for all the suggestions to display
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@role='listbox']//li")));
		//store/capture the suggestions
		List<WebElement> suggestions = driver.findElements(By.xpath("//ul[@role='listbox']//li"));
		
		//print the suggestions
		for(WebElement option: suggestions)
		{
			String text = option.getText();
			System.out.println(text);
			
			if(text.equals("selenium java")) {
				option.click();
				break;
			}
			else
			{
				System.out.println("not found");
			}
		}
		
		
		closeBroswer();
	}
 
	//Method to close the browser
	public static void closeBroswer() throws InterruptedException
	{
		//Sleep
		Thread.sleep(5000);
		driver.quit();
	}
 
}
 
