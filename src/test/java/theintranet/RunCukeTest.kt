package theintranet

import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import org.junit.runner.RunWith

@RunWith(Cucumber::class)
@CucumberOptions(features = ["classpath:features"],
        plugin = ["pretty", "html:target/cucumberHtmlReport",  // for html result
            "pretty:target/cucumber-json-report.json",  // for json result
            "pretty:junit:target/cucumber.xml"])

class RunCukeTest