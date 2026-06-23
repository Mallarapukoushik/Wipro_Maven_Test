package Selenium;
 
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
 
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import util.Baseclass;
 
public class Loginout extends Baseclass{
 @Test
	public void enter() throws IOException {
		// Read the data from properties file
		FileInputStream fis = new FileInputStream("./src/test/java/util/data.properties");
		Properties prop = new Properties();//properties object
		prop.load(fis);
		String browser = prop.getProperty("browser");
		System.out.println(browser);
		System.out.println(prop.getProperty("userName"));
		System.out.println(prop.getProperty("password"));
		System.out.println(prop.getProperty("url"));
		
		//invoke and enter the url
		invokeBrowser(browser);
		driver.findElement(By.name("username")).sendKeys(prop.getProperty("userName"));
		driver.findElement(By.name("password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		driver.findElement(By.className("oxd-userdropdown-tab")).click();
		driver.findElement(By.cssSelector("//a[contains[href,'logout']")).click();
	}
 
}
 