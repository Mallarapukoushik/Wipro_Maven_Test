package stepDef2;

import org.testng.AssertJUnit;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import HRMPages.HRMLoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HRMSSteps2 {

    WebDriver driver;
    HRMLoginPage loginPage;

    @Given("User is on HRMSLogin page")
    public void user_is_on_hrms_login_page() {

        System.out.println("invoke the browser");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @When("User enters username as {string} and {string}")
    public void user_enters_username_as_and(String name, String password) {

        loginPage = new HRMLoginPage(driver);

        loginPage.userName(name);
        loginPage.password(password);
        loginPage.submit();
    }

    @Then("user login validation should be {string}")
    public void user_should_be_able_to_login_if_valid_credentials_are_passed(String result) throws InterruptedException {

        String expectedURL = "dashboard";
        Thread.sleep(3000);

        boolean isLoggedIn = driver.getCurrentUrl().contains(expectedURL);

        if (result.equalsIgnoreCase("pass")) {
            AssertJUnit.assertTrue(isLoggedIn);
            System.out.println("Credentials are valid");
        } else {
            AssertJUnit.assertFalse(isLoggedIn);
            System.out.println("Invalid Credentials...");
        }
    }
    @Then("User logs out")
    public void user_logs_out() throws InterruptedException {
        loginPage.logout();
        Thread.sleep(2000);
    }
    @Then("Close browser")
    public void close_browser() {
        driver.quit();
    }
}