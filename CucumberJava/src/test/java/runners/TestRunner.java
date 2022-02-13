package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class) 
@CucumberOptions(
	features="./src/test/resources/Features/movie_rent.feature",
	glue={"steps"},
	monochrome = true,
	plugin = { "pretty", "json:target/JSONReports/report.json"}
	)
public class TestRunner {
}

