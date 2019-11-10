Feature: User is going to search for Vegetable and Proceed to Checkout
  Scenario: Search for Items and validate the result
    Given User navigates to website
    When  User searches for "Cucumber"
    Then  "Cucumber" result is displayed


    Scenario Outline: Search for items and move to the checkout
      Given User navigates to website
      When  User searches for "<items>" vegetable
      And   Added to the cart
      And   User proceeds to the checkOut page
      Then  Verify selected "<items>" are displayed in the Checkout Page
      Examples:
        |items|
        |cucumber|
        |beetroot|
        |apple|


    @last
    Scenario: Add 2 or more items to the car and validate the results
      Given User navigates to website
      When  User added more than one item to the cart
      Then  User proceeds to the checkOut page
      And Verify selected items are displayed in the Checkout Page

