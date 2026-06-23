package HRMPages;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 
public class HRMLoginPage {
	//Declare webdriver	
	WebDriver driver;
	//Login page - object
	By userName = By.name("username");
	By password = By.name("password");	
	By login = By.cssSelector("button[type='submit']");
	//Logout - Develop
	By profileMenu = By.xpath("//span[@class='oxd-userdropdown-tab']");
	By logoutBtn = By.xpath("//a[text()='Logout']");
	//constructor
	public HRMLoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	//Methods
	public void userName(String name)
	{
		//Identify and pass the value
		driver.findElement(userName).sendKeys(name);
	}
	public void password(String pwd)
	{
		driver.findElement(password).sendKeys(pwd);
	}
	public void submit()
	{
		driver.findElement(login).click();
	}

    public void logout()
    {
        driver.findElement(profileMenu).click();
        driver.findElement(logoutBtn).click();
    }


 
}