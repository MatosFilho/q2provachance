package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions (
		format = {"pretty"},
		tags = "@deposito",
		features = "src/test/resources/features/",
	    dryRun = false,
	    monochrome = true,
	    glue = "steps"
		)

public class DepositoRunnerTest {}
