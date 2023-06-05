package runnerclasses;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/Features/Demo1.feature",
glue = "Stepdefinitions",
plugin = "html:reports/Demo1.html",
tags = "@cart")
public class demorunner {
}
