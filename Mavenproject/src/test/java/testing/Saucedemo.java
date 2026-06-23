package testing;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import util.Baseclass;

public class Saucedemo extends Baseclass{

    ExtentReports extent;
    ExtentTest test;

	@Parameters({"browser"})
	
	@BeforeMethod
	public void beforeMethod(String browser) {

        ExtentSparkReporter spark = new ExtentSparkReporter("./Reports/sauceReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Tester", "koushik");
        extent.setSystemInfo("Environment", "Stage");

		invokeBrowser(browser);
	}
	

    @AfterMethod
    public void afterMethod() throws InterruptedException {

        extent.flush();
        closeBrowser();
    }

	
	@Test
	public void Saucelogin() throws InterruptedException, IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/java/util/sauce.properties");
		Properties prop = new Properties();//properties object
		prop.load(fis);
		
		
	//identify the fields and perform action
	driver.get(prop.getProperty("url"));
	driver.findElement(By.name("user-name")).sendKeys(prop.getProperty("userName"));
	driver.findElement(By.name("password")).sendKeys(prop.getProperty("password"));
	WebElement login = driver.findElement(By.id("login-button"));
	screenShot("scetest");
	login.click();
	//Fluent wait-> better than thread.sleep-> forced sleep
	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(3));
	WebElement dropdownMenu = wait.until(driver->driver.findElement(By.id("react-burger-menu-btn")));
	dropdownMenu.click();
	screenShot("scetest2");
	driver.findElement(By.id("logout_sidebar_link")).click();
		
	}
}