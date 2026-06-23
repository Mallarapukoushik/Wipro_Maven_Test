package Runner;
 
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
@CucumberOptions(
		features = "src/test/java/feature/HRMS.feature",
		glue={"stepDef2", "hooks"},
		tags = "@smoke",
		plugin= {"pretty","html:target/HRMS2.html"}
		)
public class HRMSRunner extends AbstractTestNGCucumberTests{
 
}