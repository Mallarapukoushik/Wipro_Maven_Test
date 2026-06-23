package Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class PracticePageDemo {
 
	public static void main(String[] args) throws InterruptedException {
		// Open the browser //input[@name='radioButton']
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		//enter the url
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		//Identify the web-element radio1
		WebElement radio1 = driver.findElement(By.xpath("//input[@value='radio1']"));
		radio1.click();//click on radio-1
		String value = radio1.getAttribute("value");//get the value of the attribute
		System.out.println(value);
		boolean b = radio1.isSelected();//to check
		System.out.println("Radio-1 selected state: "+b);
		
		System.out.println("Is displayed: "+radio1.isDisplayed());
		System.out.println("Is enabled: "+radio1.isEnabled());
		driver.findElement(By.linkText("Get Shortlisted by Recruiters - Take QA Skill Assessments on TechSmartHire")).click();
		//Sleep
		Thread.sleep(5000);
		driver.quit();
 
	}
 
}
