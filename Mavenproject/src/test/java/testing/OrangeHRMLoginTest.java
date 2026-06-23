package testing;
 
import java.io.IOException;
import java.time.Duration;
 
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
 
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
 
import util.Baseclass;
 
public class OrangeHRMLoginTest extends Baseclass{
 
   // WebDriver driver;
    ExtentReports extent;
    ExtentTest test;
 
    @BeforeSuite
    public void setupReport() {
 
        extent = ExtentManager.getReportInstance();
    }
 
    @Test
    public void loginTest() throws IOException, InterruptedException {
 
        test = extent.createTest("OrangeHRM Login Test");
 
        //driver = new ChromeDriver();
        invokeBrowser("edge");
 
        test.info("Launching Browser");//information to the user
 
        driver.manage().window().maximize();
 
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));
 
        driver.get(
        "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
 
        test.pass("Application Opened");
 
        driver.findElement(
        By.name("username")).sendKeys("Admin");
 
        test.pass("Username Entered");
 
        driver.findElement(
        By.name("password")).sendKeys("admin123");
 
        test.pass("Password Entered");
 
        driver.findElement(
        By.xpath("//button[@type='submit']")).click();
 
        test.pass("Login Button Clicked");
 
        String actualTitle =
                driver.findElement(
                By.xpath("//h6")).getText();
 
        Assert.assertEquals(actualTitle, "Dashboard");//true or false
 
        test.pass("Dashboard Verified");
 
        String screenshot =ScreenshotUtil.captureScreenshot(driver,
                        "LoginSuccess");
 
        test.addScreenCaptureFromPath(screenshot);
		/*
		 * Thread.sleep(3000); driver.quit();
		 */
    }
 
    @AfterMethod
    public void resultCapture(org.testng.ITestResult result)
            throws Exception {
 
        if(result.getStatus()
                == org.testng.ITestResult.FAILURE) {
 
            String screenshot =
                    ScreenshotUtil.captureScreenshot(driver,
                            result.getName());
 
            test.fail(result.getThrowable());
 
            test.addScreenCaptureFromPath(screenshot);
        }
    }
 
    @AfterSuite
    public void closeReport() throws InterruptedException {
 
        extent.flush();        
        closeBrowser();
    }
}