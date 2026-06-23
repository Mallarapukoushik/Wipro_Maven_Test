package testing;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import util.Baseclass;

public class OrangeHRMS extends Baseclass{
	ExtentReports extent;
    ExtentTest test;
 
    @BeforeSuite
    public void setupReport() {
    	 extent = ExtentManager.getReportInstance();
    }
    @DataProvider
    public Object[][] dp() {
      return new Object[][] {
        new Object[] {"Admin","admin123"},
        new Object[] {"Admin","wrongpwd"},
        new Object[] {"WrongUser","admin123"}
        };
}
    @Test(dataProvider="dp")
    public void loginTest(String username,String password) throws IOException, InterruptedException {
    	test = extent.createTest("Login Test - " + username + " / " + password);
        //driver = new ChromeDriver();
        invokeBrowser("edge");
 
        driver.manage().window().maximize();
 
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));
 
        driver.get(
        "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        
        driver.findElement(
                By.name("username")).sendKeys(username);
         
                driver.findElement(
                By.name("password")).sendKeys(password);
         
         
                driver.findElement(
                By.xpath("//button[@type='submit']")).click();
    
    if (username.equals("Admin") && password.equals("admin123")) {
            String url = driver.getCurrentUrl();

            if (url.contains("dashboard")) {
                Assert.assertTrue(true);
                test.pass("Login success");
            }
            else {
                Assert.assertTrue(false);
            }

} else {

            // failure check
            boolean isErrorDisplayed = driver.findElement(
                    By.xpath("//p[contains(@class,'oxd-alert-content-text')]"))
                    .isDisplayed();

            if (isErrorDisplayed) {
                Assert.assertTrue(true);
                test.fail("Invalid login - error displayed");
            } else {
                Assert.assertTrue(false);
            }
        }
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