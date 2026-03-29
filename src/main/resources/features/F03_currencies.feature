@smoke
Feature: F03_currencies | users could change currency

  Scenario: user could select Euro currency
    Given user select Euro currency
    Then Euro symbol is shown on all products