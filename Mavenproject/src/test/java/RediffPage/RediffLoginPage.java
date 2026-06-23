package RediffPage;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 
public class RediffLoginPage {
	
	WebDriver driver;
	
	public RediffLoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Identify the web-elements
	By rediffHome = By.xpath("//img[@alt='Rediff.com logo']");
	By userName = By.xpath("//input[@name='login']");
	By password = By.id("password"); //css -> input[name='passwd']
	
	//User defined methods
	//driver.findElement(By.xpath("//input[@name='login']");
	public WebElement userName()
	{
		return driver.findElement(userName);
	}
	
	public WebElement password()
	{
		return driver.findElement(password);
	}
	
	public WebElement rediffHome()
	{
		return driver.findElement(rediffHome);
	}
 
}
 