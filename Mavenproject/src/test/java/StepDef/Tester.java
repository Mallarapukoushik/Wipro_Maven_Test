package StepDef;
 
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 
public class Tester {
	@Given("I am a {string} tester")
	public void i_am_a_tester(String tester) {
	    // Write code here that turns the phrase above into concrete actions
	   System.out.println("I am a "+ tester +" tester");
	}
 
	@When("I apply for a job")
	public void i_apply_for_a_job() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("I apply for a job");
	}
 
	@Then("I got {string} paid job")
	public void i_got_paid_job(String paid) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("I got "+paid+" paid job");
	}
 
	@And("I am {string} satisfied with my salary")
	public void i_am_satisfied_with_my_salary(String satisfaction) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("I am "+satisfaction+" satisfied with my salary");
	}
 
	@But("my parents are {string} satisfied")
	public void my_parents_are_satisfied(String parents) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("my parents are "+parents+" satisfied");
	}
 
}