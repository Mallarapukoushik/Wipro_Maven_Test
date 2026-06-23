package testing;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
 
public class HtmlUnitDriverDemo {
	
	@Test
	public void htmlDriver()
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");//faster without the UI
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com/");
		
		//print the title of the page
		driver.getTitle();
		
		//close browser
		driver.quit();
	}
 
}