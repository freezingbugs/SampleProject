package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = { ".//Features/HomePage.feature", 
".//Features/SupportPage.feature",
".//Features/API.feature",".//Features/TransformData.feature" }, glue = { "stepDefinitions" }, 
plugin = { "pretty", "html:test-output3" })
public class TestRunner extends AbstractTestNGCucumberTests {

}