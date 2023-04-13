package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions
       (
		features=".//Features/HomePage.feature",
		glue="stepDefinitions",
		dryRun=true,
		monochrome=true,
		plugin= {"pretty","html:test-output"}
		)
public class TestRun {		
	
}
