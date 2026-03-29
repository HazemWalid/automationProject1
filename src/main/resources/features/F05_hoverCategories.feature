@smoke
Feature: F05_hoverCategories | users could hover categories

  Scenario: user could hover and select sub-category
    Given user hover on random category
    When user select random sub-category
    Then sub-category page should be opened successfully