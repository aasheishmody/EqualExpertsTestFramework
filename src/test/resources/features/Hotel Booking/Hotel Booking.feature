@booking
Feature: Hotel Booking

  As a business
  I want to add bookings for the hotel
  So that I have an accurate record of the past and existing bookings

  Background:
    Given I am on the 'Hotel Booking Form' page

  Scenario Outline: Booking can be made on the 'Hotel booking form' page with/without deposit
    And I enter the following details on the 'Hotel booking form' page
      | First Name  | Surname   | Price   | Deposit   | Check-in Date | Check-out Date |
      | <firstname> | <surname> | <price> | <deposit> | <check-in>    | <check-out>    |
    And I click the 'Save' button on the 'Hotel booking form' page
    Then the following booking is added on the 'Hotel booking form' page
      | First Name  | Surname   | Price   | Deposit   | Check-in Date | Check-out Date |
      | <firstname> | <surname> | <price> | <deposit> | <check-in>    | <check-out>    |

    Examples:
      | firstname | surname | price | deposit | check-in   | check-out  |
      | Krishna   | Das     | 180   | true    | Today      | Tomorrow   |
      | Gopal     | Chand   | 200   | false   | 2017-09-27 | 2017-09-28 |


  Scenario Outline: Booking can be deleted on the 'Hotel booking form' page
    And a booking with the following details is present
      | First Name  | Surname   | Price   | Deposit   | Check-in Date | Check-out Date |
      | <firstName> | <surname> | <price> | <deposit> | <check-in>    | <check-out>    |
    When I delete the booking with the following details on the 'Hotel booking form' page
      | First Name  | Surname   | Price   | Deposit   | Check-in Date | Check-out Date |
      | <firstName> | <surname> | <price> | <deposit> | <check-in>    | <check-out>    |
    Then the booking with the following details is not displayed
      | First Name  | Surname   | Price   | Deposit   | Check-in Date | Check-out Date |
      | <firstName> | <surname> | <price> | <deposit> | <check-in>    | <check-out>    |

  Examples:
  | firstName | surname | price | deposit | check-in   | check-out  |
  | Krishna   | Das     | 180   | true    | 2017-09-25 | 2017-09-26 |
  | Gopal     | Chand   | 200   | false   | 2017-09-27 | 2017-09-28 |

  Scenario Outline: Calendar modal is displayed for the <field> on the 'Hotel booking form' page
    And I click on the <field> on the 'Hotel booking form' page
    Then the Calendar modal is displayed on the 'Hotel booking form' page

    Examples:
      | field     |
      | Check-in input field  |
      | Check-out input field |