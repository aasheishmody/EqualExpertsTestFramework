package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

import static util.WebConnector.getBaseURL;
import static util.WebConnector.getDriver;
import static util.WebConnector.getMediumTimeout;

public class HotelBookingFormPage extends Page {

    @FindBy(id = "firstname")
    private WebElement FirstnameInputBox;
    @FindBy(id = "lastname")
    private WebElement SurnameInputBox;
    @FindBy(id = "totalprice")
    private WebElement PriceInputBox;
    @FindBy(id = "depositpaid")
    private WebElement DepositInputBox;
    @FindBy(id = "checkin")
    private WebElement CheckInDateInputBox;
    @FindBy(id = "checkout")
    private WebElement CheckOutDateInputBox;
    @FindBy(css = "input[type='button'][value=' Save ']")
    private WebElement SaveButton;
    @FindBy(id = "bookings")
    private WebElement BookingsTable;

    public void open() {
        getDriver().get(getBaseURL());
    }

    private void enterCheckOutDate(Map<String, String> bookingDetails) {
        sendKeys(CheckOutDateInputBox, getDate(bookingDetails, "Check-out Date"), getMediumTimeout());
    }

    private void enterCheckInDate(Map<String, String> bookingDetails) {
        sendKeys(CheckInDateInputBox, getDate(bookingDetails, "Check-in Date"), getMediumTimeout());
    }

    private void enterDeposit(Map<String, String> bookingDetails) {
        sendKeys(DepositInputBox, bookingDetails.get("Deposit"), getMediumTimeout());
    }

    private void enterPrice(Map<String, String> bookingDetails) {
        sendKeys(PriceInputBox, bookingDetails.get("Price"), getMediumTimeout());
    }

    private void enterSurname(Map<String, String> bookingDetails) {
        sendKeys(SurnameInputBox, bookingDetails.get("Surname"), getMediumTimeout());
    }

    private void enterFirstname(Map<String, String> bookingDetails) {
        sendKeys(FirstnameInputBox, bookingDetails.get("First Name"), getMediumTimeout());
    }

    public void clickSaveButton() {
        click(SaveButton, getMediumTimeout());
    }

    public void enterDetailsForBooking(Map<String, String> bookingDetails) {
        enterFirstname(bookingDetails);
        enterSurname(bookingDetails);
        enterPrice(bookingDetails);
        enterDeposit(bookingDetails);
        enterCheckInDate(bookingDetails);
        enterCheckOutDate(bookingDetails);
    }

    private String getexpectedFirstname(Map<String, String> bookingDetails){
        return bookingDetails.get("First Name");
    }

    private String getexpectedSurname(Map<String, String> bookingDetails){
        return bookingDetails.get("Surname");
    }

    private String getexpectedPrice(Map<String, String> bookingDetails){
        return bookingDetails.get("Price");
    }

    private String getexpectedDeposit(Map<String, String> bookingDetails){
        return bookingDetails.get("Deposit");
    }

    private String getexpectedCheckinDate(Map<String, String> bookingDetails){
        return getDate(bookingDetails, "Check-in Date");
    }

    private String getexpectedCheckoutDate(Map<String, String> bookingDetails){
        return getDate(bookingDetails, "Check-in Date");
    }

    public boolean bookingIsAdded(Map<String, String> bookingDetails) {
        String expectedFirstname = getexpectedFirstname(bookingDetails);
        String expectedSurname = getexpectedSurname(bookingDetails);
        String expectedPrice = getexpectedPrice(bookingDetails);
        String expectedDeposit = getexpectedDeposit(bookingDetails);
        String expectedCheckinDate = getexpectedCheckinDate(bookingDetails);
        String expectedCheckoutDate = getexpectedCheckoutDate(bookingDetails);
        return  getText(BookingsTable, getMediumTimeout()).contains(expectedFirstname)    &&
                getText(BookingsTable, getMediumTimeout()).contains(expectedSurname)      &&
                getText(BookingsTable, getMediumTimeout()).contains(expectedPrice)        &&
                getText(BookingsTable, getMediumTimeout()).contains(expectedDeposit)      &&
                getText(BookingsTable, getMediumTimeout()).contains(expectedCheckinDate)  &&
                getText(BookingsTable, getMediumTimeout()).contains(expectedCheckoutDate);
    }
}