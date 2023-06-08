package runnerclasses;


import com.cucumber.listener.Reporter;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;



import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/Features/Demo1.feature",
glue = "Stepdefinitions")
public class demorunner {
    @AfterClass
    public static void writeExtentReport() {
    }
}
