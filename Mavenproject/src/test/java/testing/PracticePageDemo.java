package testing;
 
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
 
import util.Baseclass;
 
public class PracticePageDemo extends Baseclass{
	
	@BeforeClass //executes for every test case
	public void openBrowser()
	{
		invokeBrowser("chrome");//fail
	}
	
	@Test (priority=1)
	public void alertDemo() throws InterruptedException
	{
		
		System.out.println("We are clicking on alert button");
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("alertbtn")).click();
		//handle alert
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
	}
	
	@Test (priority=0,dependsOnMethods = {"alertDemo"})
	public void orangeHRMS() throws InterruptedException
	{
		
		System.out.println("We are clicking on alert button");
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//driver.findElement(By.id("alertbtn")).click();
		
	}
	
	@AfterClass	
	public void close() throws InterruptedException
	{
		closeBrowser();
	}
 
}
 