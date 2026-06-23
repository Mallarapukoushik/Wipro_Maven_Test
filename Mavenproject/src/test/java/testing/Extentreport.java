package testing;
 
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
 
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
 
public class Extentreport {
	
	ExtentReports extent;//extent report
	ExtentTest test;//loggin the test result
	
	@Test
	public void skipTest()
	{
		test = extent.createTest("Sample skip test");
		test.skip("Sample skipped test");
	}
	
	@Test
	public void passTest()
	{
		test = extent.createTest("Sample pass test");
		test.pass("Addition is done");
	}
	
	@Test
	public void failTest()
	{
		test = extent.createTest("Sample fail test");
		test.fail("test is failed");
	}
	
	@Test
	public void validation()
	{
		test = extent.createTest("Sample validation test");
		Assert.assertEquals(10, 12);//not matching  stop execution
		//test.fail("test executed");
	}
	
	@AfterMethod
	public void getResult(ITestResult result)
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.pass("Test is passed");
		}
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			test.fail(result.getThrowable());
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			test.skip("Test skipped");
		}
	}
	
	@BeforeSuite
	public void beforeSuite()
	{
		ExtentSparkReporter reporter = new ExtentSparkReporter("./Reports/Extent-Report.html");
		reporter.config().setReportName("Automation Test Report");
		
		//Attach the report to extent Reports
		extent = new ExtentReports();
		extent.attachReporter(reporter);	
		
		extent.setSystemInfo("Tester", "Wipro");
		extent.setSystemInfo("Browser", "chrome");
	}
	
	@AfterSuite
	public void afterSuite()
	{
		extent.flush();//ensure the report is generated
	}
 
}
 