package util;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
 
public class Baseclass {
	
	public static WebDriver driver;
	
	//invoke the browser
	public static void invokeBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("Chrome"))
		{
			//invoke chrome browser
			//System.setProperty("webdriver.chrome.driver","D:\\Automation\\dependency\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();//maximize the window
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		else if(browser.equalsIgnoreCase("EDGE"))
		{
			//invoke chrome browser
			//System.setProperty("webdriver.chrome.driver","D:\\Automation\\dependency\\chromedriver.exe");
			driver = new EdgeDriver();
			driver.manage().window().maximize();//maximize the window
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		}			
	}
	public static String screenShot(String testName) throws IOException
	{
	    TakesScreenshot ts = (TakesScreenshot) driver;

	    File src = ts.getScreenshotAs(OutputType.FILE);

	    String path = "./screenshot/" + testName + "-" 
	            + System.currentTimeMillis() + ".png";

	    File dest = new File(path);

	    FileUtils.copyFile(src, dest);

	    return path;
	}


	//close browser
	public static void closeBrowser() throws InterruptedException{
		driver.quit();
	}
}

 
