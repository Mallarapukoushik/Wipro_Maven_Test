package Runner;
 
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/feature/Tester.feature",
		glue="StepDef", monochrome=true
		)
public class TesterRunner {
 
}