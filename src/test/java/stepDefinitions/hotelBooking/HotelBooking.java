package stepDefinitions.hotelBooking;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import pageObjects.*;

import java.util.List;
import java.util.Map;

import static util.LoggerHelper.*;
import static util.WebConnector.getDriver;

public class HotelBooking {

    private final HotelBookingFormPage hotelBookingFormPage;

    public HotelBooking() {
        hotelBookingFormPage = PageFactory.initElements(getDriver(), HotelBookingFormPage.class);
    }

    @Given("^I am on the 'Hotel Booking Form' page$")
    public void iAmOnTheLandingPage() throws Throwable {
        navigating("to the Hotel Hotel Booking Form", hotelBookingFormPage::open);
    }

    @And("^I click the 'Save' button on the 'Hotel booking form' page$")
    public void iClickTheSaveButtonOnTheHotelBookingFormPage() throws Throwable {
        clicking("Save button on the 'Hotel booking form' page", hotelBookingFormPage::clickSaveButton);
    }

    @And("^I enter the following details on the 'Hotel booking form' page$")
    public void iEnterTheFollowingDetailsOnTheHotelBookingFormPage(DataTable table) throws Throwable {
        Map<String, String> bookingDetails = getBookingDetails(table);
        entering("details on the 'Hotel booking form' page", () -> hotelBookingFormPage.enterDetailsForBooking(bookingDetails));
    }

    @Then("^the following booking is added on the 'Hotel booking form' page$")
    public void theFollowingBookingIsAddedOnTheHotelBookingFormPage(DataTable table) throws Throwable {
        Map<String, String> bookingDetails = getBookingDetails(table);
        asserting("that the booking is added on the 'Hotel booking form' page", () -> Assert.assertTrue(hotelBookingFormPage.bookingIsAdded(bookingDetails)));
    }

    @And("^a booking with the following details is present$")
    public void aBookingWithTheFollowingDetailsIsPresent(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I delete the booking with the following details on the 'Hotel booking form' page$")
    public void iDeleteTheBookingWithTheFollowingDetailsOnTheHotelBookingFormPage(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the booking with the following details is not displayed$")
    public void theBookingWithTheFollowingDetailsIsNotDisplayed(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^I click on the Check-in input field on the 'Hotel booking form' page$")
    public void iClickOnTheCheckinInputBoxFieldOnTheHotelBookingFormPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^I click on the Check-out input field on the 'Hotel booking form' page$")
    public void iClickOnTheCheckoutInputBoxFieldOnTheHotelBookingFormPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the Calendar modal is displayed on the 'Hotel booking form' page$")
    public void theCalendarModalIsDisplayedOnTheHotelBookingFormPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    private Map<String, String> getBookingDetails(DataTable table) {
        List<Map<String, String>> bookingDetailsRow = table.asMaps(String.class, String.class);
        Map<String, String> bookingDetails = null;
        for (Map<String, String> bookingDetail : bookingDetailsRow) {
            bookingDetails = bookingDetail;
        }
        return bookingDetails;
    }
}