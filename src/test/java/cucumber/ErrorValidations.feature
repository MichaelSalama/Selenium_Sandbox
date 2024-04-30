@tag
Feature: Error Validations

  @ErrorValidation
  Scenario Outline: Positive Test of Submitting the order
    Given I landed on the Ecommerce Page
    When Logged in with username <name> and password <password>
    Then "Incorrect email or password." message is displayed

    Examples:
      | name                 | password  |
      | rahulshetty@gmil.com| IamKing@000 |


















