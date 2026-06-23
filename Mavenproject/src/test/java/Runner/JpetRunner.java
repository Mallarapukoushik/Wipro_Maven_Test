package Runner;
 
import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;
 
@CucumberOptions(

		features = "src/test/java/feature/Jpet.feature",

		glue={"StepDef","hooks"}, monochrome=true,

		plugin = {"pretty", "html:target/cucumber-reports/Jpet.html"}

		)

public class JpetRunner extends AbstractTestNGCucumberTests {
 
}

 