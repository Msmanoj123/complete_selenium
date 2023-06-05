Feature: Register to QAfox website

  Background:
    Given open the browser and enter the url"https://www.tutorialsninja.com/demo/"

  @register_validdata
  Scenario: create an account in QAfox site
    When user click on my account and click on register
    And enter the valid data for all the fields
    And click on subscribe checkbox and select privacy-policy checkbox and continue
    Then check account is created

  @register_invaliddata
  Scenario: create an account in QAfox site
    When user click on my account and click on register
    And click on subscribe checkbox and select privacy-policy checkbox and continue
    Then check the error msg is displayed

  @login_valid
  Scenario Outline:login to QAfox site
    When user click on my account and click on login
    And enter the email address <email> and password <password>
    Then Title should be "My Account"

  Examples:
    |email|password|
    |deekshigowda@gmail.com|Deekshi|

  @login_invalid
  Scenario Outline:login to QAfox site
    When user click on my account and click on login
    And enter the email address <email> and password <password>
    Then error msg should be display "Warning: No match for E-Mail Address and/or Password."
  Examples:
    |email|password|
    |deekshigowda@gmail.com| |
    | |Deekshi               |
    | | |

  @cart
  Scenario: Add an item to cart
    When user click on tablets
    And add item into cart
    Then check the item in the cart