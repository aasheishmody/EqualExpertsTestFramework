package stepDefinitions.hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

import static util.WebConnector.getDriver;
import static util.WebConnector.initialize;

public class Hooks {

    @Before
    public void beforeTest() {
        initialize();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            WebDriver augmentedDriver = new Augmenter().augment(getDriver());
            byte[] screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
        getDriver().manage().deleteAllCookies();
    }
}
