package RediffPage;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 
public class RediffHomePage {
	
	WebDriver driver;
	
	public RediffHomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By news = By.linkText("NEWS");
	By sports = By.linkText("sports");
	By business = By.linkText("BUSINESS");
 
	//User defined methods
	public WebElement news()
	{
		return driver.findElement(news);
	}
	
	public WebElement sports()
	{
		return driver.findElement(sports);
	}
	
	public WebElement business()
	{
		return driver.findElement(business);
	}
}
 