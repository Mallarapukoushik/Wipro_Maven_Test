package RediffTCs;
 
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
 
import RediffPage.RediffHomePage;
import RediffPage.RediffLoginPage;
import util.Baseclass;
 
public class RediffTC1 extends Baseclass{
	
	//WebDriver driver;
	RediffHomePage rhp;
	RediffLoginPage rlp;
	
	@BeforeMethod
	public void setUp()
	{
		invokeBrowser("edge");		
	}
	
	@Test
	public void rediffTC1() throws InterruptedException
	{
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		rlp = new RediffLoginPage(driver);//calling the home page class
		rlp.userName().sendKeys("admin");
		rlp.password().sendKeys("admin123");
		Thread.sleep(2000);
		rlp.rediffHome().click();//link-> Home page
		
		//How to perform actions on home page
		rhp = new RediffHomePage(driver);
		rhp.news().click();//click the new link
		Thread.sleep(2000);
	}
	
	@Test
	public void rediffTC2() throws InterruptedException
	{
		driver.get("https://www.rediff.com/");
		//How to perform actions on home page
		rhp = new RediffHomePage(driver);
		rhp.news().click();//click the new link
		Thread.sleep(2000);
		//redifflogin page
		driver.navigate().to("https://mail.rediff.com/cgi-bin/login.cgi");
		rlp = new RediffLoginPage(driver);//calling the home page class
		rlp.userName().sendKeys("admin");
		rlp.password().sendKeys("admin123");
		Thread.sleep(2000);
		rlp.rediffHome().click();//link-> Home page
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException
	{
		closeBrowser();
	}
	
}
 