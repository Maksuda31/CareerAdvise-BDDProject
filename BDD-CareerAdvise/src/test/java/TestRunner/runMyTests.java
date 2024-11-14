package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="Features",
		glue="StepDefinition",
		plugin={"pretty", "html:target/cucumber-reports/cucumber.html"},
		publish=true
		)

public class runMyTests extends AbstractTestNGCucumberTests {

}
