package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = {".//FeatureFiles/Coursera.feature"},
		glue = "Cucumber",
		plugin= {"pretty", "html:reports/cucumberReports/myreport.html", 
				  "rerun:target/rerun.txt",
				  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				},
				
		dryRun=false,    // checks mapping between scenario steps and step definition methods
		monochrome=true,    // to avoid junk characters in output
		publish=true
		
				//tags="@sanity"  // this will execute scenarios tagged with @sanity
				//tags="@regression"
				//tags="@sanity and @regression" 
		
		)

public class runner {

}
