package testing;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Spicejet {
	WebDriver driver;
	@Test
	public void open() {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://book.spicejet.com/");
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		 WebElement deptbutton =driver.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchVieworiginStation1_CTXT"));
		 wait.until(ExpectedConditions.elementToBeClickable(deptbutton));
		 deptbutton.click();
		 WebElement agrabutton =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@value='AGR']")));
		 agrabutton.click();
		 WebElement delbutton =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@value='DEL']")));
		 delbutton.click();
		
		
	}
	
	

}
