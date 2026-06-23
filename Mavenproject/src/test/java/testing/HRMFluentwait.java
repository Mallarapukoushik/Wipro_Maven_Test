package testing;
 
import java.io.IOException;
import java.time.Duration;
 
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;
 
import util.Baseclass;
 
public class HRMFluentwait extends Baseclass{
	
	@Test
	public void HRMSlogin() throws InterruptedException, IOException
	{
		invokeBrowser("edge");
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//identify the fields and perform action
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
		screenShot("hrmtest");
		login.click();
		//Fluent wait-> better than thread.sleep-> forced sleep
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(3));
		WebElement dropdownMenu = wait.until(driver->driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")));
		dropdownMenu.click();
		screenShot("hrmtest2");
		driver.findElement(By.linkText("Logout")).click();
		closeBrowser();
	}
}
 