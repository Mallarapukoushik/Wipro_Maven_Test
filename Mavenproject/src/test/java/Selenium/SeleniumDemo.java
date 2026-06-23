package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

 
public class SeleniumDemo {
 
	public static void main(String[] args) throws InterruptedException {
		// Automate the Google search
		//open the browser
		WebDriver driver = new ChromeDriver();//invoking the chrome browser
		//use driver object to enter the url
		//WebDriver driver = new FirefoxDriver();//firefox browser
		driver.get("https://google.com/");
		driver.manage().window().maximize();//to maximize the window
		String title = driver.getTitle();
		System.out.println(title);
		
		//validation
		if(title.equals("Google"))//forced delay of 2 seconds
		{
			System.out.println("Title is matching");
		}
		else
			System.out.println("Title does not match");
 
		Thread.sleep(5000);
		driver.close();			
	}
}



