package StepDef;
 
import java.time.Duration;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
import hooks.Hooks;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jpetStorePages.JpetHomePage;
import jpetStorePages.JpetLoginPage;
import junit.framework.Assert;
 
public class JpetSteps {
	WebDriver driver;
	JpetLoginPage jpetlogin;
	JpetHomePage  jpetchekout;

	@Given("User is on JpetStore Login page")
	public void User_is_on_JpetStore_Login_Page() {
		this.driver=Hooks.driver;
		jpetlogin=new JpetLoginPage(driver);
        jpetchekout=new JpetHomePage(driver);
		driver.get("https://jpetstore.aspectran.com/");
	}
	@When("User enters username {string} password {string"
			+ "}")
	public void User_enters_username_password(String name,String pass) {
		jpetlogin.loginIntoJpet(name, pass);

	}
	boolean isLoginSuccessful = true;

	@Then("user should be logged in and see greeting for user {string}")
	public void user_should_be_logged_in_and_see_greeting_for_user(String username) {

 
		
		String expectedGreeting = "Welcome " +username+ "!";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), expectedGreeting));
	String bodyText=driver.findElement(By.tagName("body")).getText();
	if(bodyText.contains("Welcome "+username+"!")) {
		Assert.assertTrue(bodyText.contains("Welcome " + username + "!"));
		isLoginSuccessful = true;
		System.out.println("Valid Credentials :"+username);
	}else {
		Assert.assertTrue("Login Verification Failed! Missing greeting for user: " + username, 
			    bodyText.contains("Welcome " + username + "!"));
		isLoginSuccessful = false;
		System.out.println("InValid Credentials :"+username);
	    }
	}

	@When("User checkout Amazon Parrot in the Birds category link")
	public void user_checkouts_Amazon_Parrot_in_the_Birds_Category_link() throws InterruptedException {
		if(isLoginSuccessful) {
			jpetchekout.checkOutItem();
			Thread.sleep(2000);
		}else {
			System.out.println("Skipping Birds category step layout because login state is flagged as failed.");
		}

	}
}