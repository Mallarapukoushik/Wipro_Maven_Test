package Orangepage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import Orangepomdl.Orangehome;
import Orangepomdl.Orangelogin;
import testing.ExtentManager;
import testing.Log4JDemo;
import util.Baseclass;
public class OrangeP1 extends Baseclass{
	ExtentReports extent;
	ExtentTest test;
	Orangelogin ln;
	Orangehome hp;
	private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(Log4JDemo.class);
	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser)
	{

        extent = ExtentManager.getReportInstance();
        test = extent.createTest("OrangeHRM Login Test");

		logger.info("Starting the browser setup");
		
		invokeBrowser(browser);	
		logger.info("Browser launched successfully");
		test.info("Browser launched");
	}
	@Test
	public void Orangep() throws InterruptedException {
    logger.info("Navigating to orangehrm");
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    logger.info("Page title is:"+driver.getTitle());
        ln = new Orangelogin(driver); 
        ln.enterUsername("Admin");
        ln.enterPassword("admin123");
        ln.clickLogin();

        Thread.sleep(3000);
        hp = new Orangehome(driver);
        hp.clickProfile();
        hp.clickLogout();

    }
	@AfterMethod
	public void tearDown() throws InterruptedException
	{
		logger.info("Closing browser");
		closeBrowser();
		test.info("Browser closed");
		extent.flush();
	}
}
