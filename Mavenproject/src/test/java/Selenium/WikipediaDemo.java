package Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
import util.Baseclass;
 
public class WikipediaDemo extends Baseclass{
	//static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		//  invoke the browser
		//call the function
		try
		{
			/*
			 * driver = new FirefoxDriver(); driver.manage().window().maximize();
			 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			 */
			invokeBrowser("chrome");
			driver.navigate().to("https://www.wikipedia.org/");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(
					By.partialLinkText("English"))).click();
		}
		catch(Exception e)
		{
			//driver.findElement(By.partialLinkText("English")).click();
			System.out.println("Did not click on English link");		
			closeBrowser();
		}
		finally
		{
			System.out.println("We are done with try/catch block");
			closeBrowser();
		}
	}

	public static void invokeBrowser(String string) {
		// TODO Auto-generated method stub
		
	}

	public static void closeBrowser() {
		// TODO Auto-generated method stub
		
	}
 
	/*
	 * public static void closeBrowser() throws InterruptedException {
	 * Thread.sleep(2000); driver.quit(); }
	 */
 
}
