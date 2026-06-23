package Selenium;
 
import java.time.Duration;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class MouseHover {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/tool-tips");
        driver.manage().window().maximize();
 
     // Explicit wait
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
 
        // Locate button
        WebElement button =driver.findElement(By.id("toolTipButton"));
 
        // Mouse hover
        Actions act = new Actions(driver);
 
        act.moveToElement(button).perform();     
        
     // Wait until tooltip visible
        WebElement tooltip = wait.until(ExpectedConditions.visibilityOfElementLocated( By.xpath("//div[@class='tooltip-inner']")));
 
        // Get tooltip text
        String tooltipText = tooltip.getText();
 
        System.out.println("Tooltip Text: " + tooltipText);
 
        // Validation
        if(tooltipText.equals("You hovered over the Button")) {
 
            System.out.println("Tooltip Verified");
 
        } else {
 
            System.out.println("Tooltip Verification Failed");
        }
	}
 
}
 