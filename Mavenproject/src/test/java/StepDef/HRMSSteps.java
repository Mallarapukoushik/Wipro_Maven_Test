//package StepDef;
// 
//import java.time.Duration;
// 
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
// 
//public class HRMSSteps {
//	WebDriver driver;
//	@Given("User is on HRMSLogin page")
//	public void user_is_on_hrms_login_page() {
//	    // Write code here that turns the phrase above into concrete actions
//	    System.out.println("invoke the browser");
//	    //Open the browser
//	    driver = new ChromeDriver();
//	    driver.manage().window().maximize();
//	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");	  
//	}
// 
//	@When("User enters username as {string} and {string}")
//	public void user_enters_username_as_and(String name, String password) throws InterruptedException {
//	    // Write code here that turns the phrase above into concrete actions
//	    //Identify the web-elements
//		driver.findElement(By.name("username")).sendKeys(name);
//		driver.findElement(By.name("password")).sendKeys(password);
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
//	}
// 
//	@Then("user should be able to login if valid credentials are passed")
//	public void user_should_be_able_to_login_if_valid_credentials_are_passed() throws InterruptedException {
//	    // Write code here that turns the phrase above into concrete actions
//	    String expectedURL="dashboard";
//	    Thread.sleep(3000);
//	    //validation
//	    boolean status = driver.getCurrentUrl().contains(expectedURL);
//	    if(driver.getCurrentUrl().contains(expectedURL)) {
//	    	System.out.println("Credentials are valid..");
//	    }
//	    else
//	    	System.out.println("Invalid Credentials..");
//	    Thread.sleep(2000);
//	    Assert.assertEquals(status, true);
//	}
//}