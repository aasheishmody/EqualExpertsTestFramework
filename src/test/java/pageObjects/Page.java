package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static util.WebConnector.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

public abstract class Page  {



    void click(WebElement element, int timeout) {
        getLogger().info("Waiting for " + element + " to be displayed");
        WebDriverWait wait = new WebDriverWait(getDriver(), getMediumTimeout());
        wait.until(ExpectedConditions.visibilityOf(element));
        getLogger().info(element + " found after waiting for it to be displayed");
        getLogger().info("Waiting for element to be clickable - " + element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        getLogger().info("Clicking " + element);
        element.click();
        getLogger().info("Clicked " + element);
    }

    private void waitForElementToBeDisplayed(WebElement element, int timeout) {
        getLogger().info("Waiting for " + element + " to be displayed");
        WebDriverWait wait = new WebDriverWait(getDriver(), getMediumTimeout());
        wait.until(ExpectedConditions.visibilityOf(element));
        getLogger().info(element + " found after waiting for it to be displayed");
    }

    void sendKeys(WebElement element, String text, int timeout) {
        waitForElementToBeDisplayed(element, timeout);
        getLogger().info("Sending text - " + text + " to element - " + element);
        element.sendKeys(text);
        getLogger().info("Sent text - " + text + " to element - " + element);
    }

    String getText(WebElement element, int timeout) {
        waitForElementToBeDisplayed(element, timeout);
        getLogger().info("Getting text from element - " + element);
        getLogger().info("Got text - " + element.getText() + " from element - " + element);
        return element.getText();
    }

    String getDate(Map<String, String> bookingDetails, String date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        switch (bookingDetails.get(date)) {
            case "Today":
                cal.add(Calendar.DATE, 0);
                date = dateFormat.format(cal.getTime());
                break;
            case "Tomorrow":
                cal.add(Calendar.DATE, 1);
                date = dateFormat.format(cal.getTime());
                break;
            case "Yesterday":
                cal.add(Calendar.DATE, -1);
                date = dateFormat.format(cal.getTime());
                break;
            default:
                date = bookingDetails.get(date);
        }
        return date;
    }
}