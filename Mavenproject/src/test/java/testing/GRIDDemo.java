package testing;
 
import java.net.MalformedURLException;
import java.net.URL;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
 
public class GRIDDemo {
	WebDriver driver;
	@Test
	public void gridTC1() throws MalformedURLException
	{
		FirefoxOptions options = new FirefoxOptions();
		//options.setCapability("BrowserName", "Firefox");
		driver = new RemoteWebDriver(new URL("http://192.168.0.106:4444/"),options);
		driver.get("https://www.selenium.dev/");
		System.out.println(driver.getTitle());
	}
	
	@Test (enabled=false)
	public void TC2() throws MalformedURLException
	{
		ChromeOptions options = new ChromeOptions();
		//options.setCapability("BrowserName", "Chrome");
		driver = new RemoteWebDriver(new URL("http://192.168.0.106:4444"),options);
		//driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com/");		
		//print the title of the page
		System.out.println(driver.getTitle());
	}
	
	@Test (enabled=false)
	public void gridDemo3() throws MalformedURLException
	{
		// GRID Demo
		EdgeOptions options = new EdgeOptions();
		//options.setCapability("BrowserName", "Edge");
		driver = new RemoteWebDriver(new URL("http://192.168.0.106:4444"),options);
		driver.get("http://www.rediff.com");
		System.out.println(driver.getTitle());
	}
 
}
 