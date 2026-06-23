package testing;
 
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
 
import util.Baseclass;
 
public class Log4JDemo extends Baseclass{
	//private WebDriver driver;
	private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(Log4JDemo.class);

	@BeforeClass
	public void setUp()
	{
		logger.info("Starting the browser setup");
		invokeBrowser("chrome");
		logger.info("Browser launched successfully");
	}
	@Test
	public void openGoogle()
	{
		logger.info("Navigating to google");
		driver.navigate().to("https://www.google.com");
		logger.info("Page title is:"+driver.getTitle());
	}
	@AfterClass
	public void tearDown()
	{
		logger.info("Closing the browser..");
		if(driver!=null)
		{
			driver.quit();
		}
		logger.info("Browser is closed...");
	}
 
}