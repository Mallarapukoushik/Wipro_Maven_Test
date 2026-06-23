package JpetTest;


import org.apache.logging.log4j.LogManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Jpet.Jpetcheckout;
import Jpet.Jpethome;
import Jpet.Jpetlogin;
import testing.Log4JDemo;
import util.Baseclass;

public class Jpettesting extends Baseclass {
	ExtentReports extent;
    ExtentTest test;
    Jpetlogin login;
    Jpethome home;
    Jpetcheckout checkout;
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(Log4JDemo.class);
    
    @BeforeSuite
    public void setupReport() {
        ExtentSparkReporter reporter =new ExtentSparkReporter("./Reports/JpCheckout.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        logger.info("Extent Report Setup Completed");
        
        
    }
    @BeforeMethod
    public void setup() {
        invokeBrowser("Edge");
        driver.manage().window().maximize();
        logger.info("Browser opened");
    }

    @Test
       public void checkoutFlow() {

           test = extent.createTest("JPetStore Checkout Flow");
           logger.info("Navigating to JPetStore URL");
           driver.get("https://jpetstore.aspectran.com/");

           login = new Jpetlogin(driver);
           home = new Jpethome(driver);
           checkout = new Jpetcheckout(driver);
           
         login.clickSignIn();
         test.info("Clicked Sign In");

         login.username("j2ee");
         test.info("Entered Username");

         login.password("j2ee");
         test.info("Entered Password");

         login.clickLogin();
         test.pass("Login Successful");

         home.clickFish();
         test.info("Clicked Fish");

         home.selectProduct();
         test.info("Selected Product");

         home.clickAddToCart();
         test.info("Added to Cart");

         home.clickCheckout();
         test.info("Clicked Checkout");
         
         checkout.clickContinue();
         test.info("Clicked Continue");

         checkout.clickConfirm();
         test.pass("Order Confirmed Successfully");
   }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        closeBrowser();
        logger.info("Closed the Browser");
    }
 
    @AfterSuite
    public void flushReport() {
        extent.flush();
        logger.info("Extent Report Generated");
    }

}
