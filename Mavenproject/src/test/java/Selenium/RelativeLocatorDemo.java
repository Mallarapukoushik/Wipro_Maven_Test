package Selenium;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
 
import util.Baseclass;
 
public class RelativeLocatorDemo extends Baseclass{
	//static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		//  invoke the browser
		//Relative locator in selenium-4
		try
		{
			invokeBrowser("chrome");
			driver.navigate().to("https://www.way2automation.com/way2auto_jquery/index.php");
			//Relative locator concept - input tag above the select tag-> email 
			WebElement email = driver.findElement(RelativeLocator.with(By.tagName("input")).above(By.tagName("select")));
			//Relative locator concept - input tag below the select tag-> city 
			WebElement city = driver.findElement(RelativeLocator.with(By.tagName("input")).below(By.tagName("select")));
			email.sendKeys("kk@gmail.com");
			city.sendKeys("Pune");
			screenShot();
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

	private static void screenShot() {		
	}

}