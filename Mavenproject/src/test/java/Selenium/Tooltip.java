package Selenium;
 
import java.time.Duration;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
 
public class Tooltip {
	@Test
	    public void tip() {
		WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/tooltip/");
        driver.manage().window().maximize();
 
     // Explicit wait
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
 
        // Locate button
        WebElement button =driver.findElement(By.id("age"));
 
        // Mouse hover
        Actions act = new Actions(driver);
 
        act.moveToElement(button).perform();     
 
        WebElement tooltip = wait.until(ExpectedConditions.visibilityOfElementLocated( By.xpath("//*[@id=\"age\"]")));
        
		// Get tooltip text
        String tooltipText = tooltip.getText();
 
        System.out.println("Tooltip Text: " + tooltipText);
 
        // Validation
        if(tooltipText.equals("We ask for your age only for statistical purposes")) {
 
            System.out.println("Tooltip Verified");
 
        } else {
 
            System.out.println("Tooltip Verification Failed");
        }
	}
 
}