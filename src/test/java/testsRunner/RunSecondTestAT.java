package testsRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import static util.WebConnector.getDriver;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/cucumber-html-report/2.json"},
        features = {"src/test/resources/features"},
        glue = {"stepDefinitions"},
        tags = {"@bookingDemo","~@ignore"},
        monochrome = true
)

public class RunSecondTestAT {
    @AfterClass
    public static void closeBrowser() {
        getDriver().quit();
    }
}
